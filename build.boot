(def +version+ "0.1.0")

(set-env!
  :resource-paths #{"src"}
  :dependencies   '[[org.clojure/clojure "1.8.0" :scope "provided"]
                    [boot/core "2.6.0" :scope "provided"]
                    [boot/aether "2.6.0" :scope "test"]])

(task-options!
  pom {:project     'metosin/boot-deps-size
       :version     +version+
       :description ""
       :url         "https://github.com/metosin/boot-deps-size"
       :scm         {:url "https://github.com/metosin/boot-deps-size"}
       :license     {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build []
  (comp
    (pom)
    (jar)
    (install)))

(deftask dev []
  (comp
   (watch)
   (repl :server true)
   (build)
   (target)))

(deftask deploy []
  (comp
   (build)
   (push :repo "clojars" :gpg-sign (not (.endsWith +version+ "-SNAPSHOT")))))
