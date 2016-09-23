(ns metosin.boot-deps-size.impl
  (:require [cemerick.pomegranate.aether :as aether]
            [boot.aether :as boot-aether]
            [boot.pod :as pod]
            [clojure.java.io :as io]
            [clojure.walk :as walk]))

(defn add-size [env dep deps]
  (let [jar (io/file (pod/resolve-dependency-jar env dep))
        size (.length jar)]
    (assoc (pod/coord->map dep)
           :jar jar
           :size size
           :recursive-size (reduce + size (map :size deps)))))

(defn add-sizes [env m]
  (for [[dep deps] m]
    (let [deps (if deps (add-sizes env deps))]
      (assoc (add-size env dep deps) :deps deps))))

(defn deps-size
  [env]
  (-> env
      boot-aether/resolve-dependencies-memoized*
      (->> (aether/dependency-hierarchy (:dependencies env))
           (add-sizes env))))

(defn humanize-filesize
  [bytes & [fmt]]
  (let [units ["bytes" "kB" "MB" "GB" "TB" "PB"]
        unit (if (zero? bytes)
               0
               (int (/ (Math/log bytes) (Math/log 1000))))
        size (/ bytes (Math/pow 1000 unit))]
    (format (or fmt "%.1f %s") size (get units unit))))

(defn print-deps-size'
  [i x]
  (doseq [{:keys [project size recursive-size deps]} x]
    (println (format "%s%s, self size %s, recursive size %s"
                     (apply str (repeat i "    "))
                     project
                     (humanize-filesize size)
                     (humanize-filesize recursive-size)))
    (print-deps-size' (inc i) deps)))

(defn flatten-deps [x]
  (mapcat (fn [dep]
            (conj (flatten-deps (:deps dep))
                  (dissoc dep :deps)))
          x))

(defn print-deps-size
  [env {:keys [flat? sort-by-key]}]
  (let [x (deps-size env)
        x (if flat?
            (flatten-deps x)
            x)
        x (if sort-by-key
            (reverse (sort-by sort-by-key x))
            x)]
    (print-deps-size' 0 x)))

(comment
  (deps-size boot.pod/env)
  (print-deps-size boot.pod/env nil)
  (print-deps-size boot.pod/env {:flat? true :sort-by-key :size})
  (print-deps-size boot.pod/env {:flat? true :sort-by-key :recursive-size})
  (add-sizes boot.pod/env {['org.codehaus.plexus/plexus-interpolation "1.14" :scope "test"] nil})
  (add-size boot.pod/env '[org.apache.maven/maven-model-builder "3.0.4" :scope "test"] {{:size 1000000} nil}))
