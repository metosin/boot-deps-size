(ns metosin.boot-deps-size
  {:boot/export-tasks true}
  (:require [boot.pod :as pod]
            [boot.core :as core]))

(core/deftask deps-size
  "Check size of dependencies."
  []
  (let []
    (fn [handler]
      (fn [fileset]
        ;; FIXME: Impelement
        (handler fileset)))))
