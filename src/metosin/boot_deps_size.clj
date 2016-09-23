(ns metosin.boot-deps-size
  {:boot/export-tasks true}
  (:require [boot.pod :as pod]
            [boot.core :as core]))

(def ^:private deps
  [['boot/aether "2.6.0"]])

(core/deftask deps-size
  "Check size of dependencies."
  ;; TODO: Select scopes
  [f flat       bool ""
   s sort-by-key   VAL kw ""]
  (let [p (-> (core/get-env)
              (update-in [:dependencies] into deps)
              pod/make-pod
              future)]
    (fn [handler]
      (fn [fileset]
        ;; TODO: Show selected or all pods
        (let [pod-env (core/get-env)]
          (pod/with-call-in @p
            (metosin.boot-deps-size.impl/print-deps-size
              ~pod-env
              {:flat? ~flat
               :sort-by-key ~sort-by-key})))
        (handler fileset)))))
