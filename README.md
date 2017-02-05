# Boot-deps-size [![Clojars Project](https://img.shields.io/clojars/v/metosin/boot-deps-size.svg)](https://clojars.org/metosin/boot-deps-size)

Boot task to check size of dependencies.

## Features

```
$ boot deps-size
...
org.clojure/clojure, self size 4.3 MB, recursive size 4.3 MB
org.clojure/clojurescript, self size 730.7 kB, recursive size 11.7 MB
    com.google.javascript/closure-compiler-unshaded, self size 4.1 MB, recursive size 7.4 MB
        args4j, self size 74.7 kB, recursive size 74.7 kB
        com.google.code.findbugs/jsr305, self size 33.0 kB, recursive size 33.0 kB
        com.google.code.gson/gson, self size 190.4 kB, recursive size 190.4 kB
        com.google.guava/guava, self size 2.3 MB, recursive size 2.3 MB
        com.google.javascript/closure-compiler-externs, self size 153.1 kB, recursive size 153.1 kB
        com.google.jsinterop/jsinterop-annotations, self size 4.1 kB, recursive size 4.1 kB
        com.google.protobuf/protobuf-java, self size 533.5 kB, recursive size 533.5 kB
    org.clojure/data.json, self size 8.1 kB, recursive size 8.1 kB
    org.clojure/google-closure-library, self size 5.7 MB, recursive size 5.8 MB
        org.clojure/google-closure-library-third-party, self size 71.0 kB, recursive size 71.0 kB
    org.clojure/tools.reader, self size 45.6 kB, recursive size 45.6 kB
    org.mozilla/rhino, self size 1.1 MB, recursive size 1.1 MB
org.clojure/tools.namespace, self size 19.9 kB, recursive size 22.9 kB
    org.clojure/java.classpath, self size 3.0 kB, recursive size 3.0 kB
org.slf4j/slf4j-nop, self size 4.0 kB, recursive size 45.1 kB
    org.slf4j/slf4j-api, self size 41.1 kB, recursive size 41.1 kB
org.webjars.bower/bootstrap, self size 325.7 kB, recursive size 325.7 kB
org.webjars/bootstrap, self size 662.2 kB, recursive size 840.5 kB
    org.webjars/jquery, self size 178.2 kB, recursive size 178.2 kB
reloaded.repl, self size 4.6 kB, recursive size 10.0 kB
    suspendable, self size 5.4 kB, recursive size 5.4 kB
ring/ring-core, self size 29.5 kB, recursive size 340.6 kB
    clj-time, self size 20.7 kB, recursive size 642.7 kB
        joda-time, self size 622.0 kB, recursive size 622.0 kB
    commons-fileupload, self size 69.0 kB, recursive size 69.0 kB
    commons-io, self size 208.7 kB, recursive size 208.7 kB
    crypto-equality, self size 3.7 kB, recursive size 3.7 kB
    crypto-random, self size 3.7 kB, recursive size 3.7 kB
    ring/ring-codec, self size 5.3 kB, recursive size 238.1 kB
        commons-codec, self size 232.8 kB, recursive size 232.8 kB
```

## License

Copyright © 2016-2017 Juho Teperi

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
