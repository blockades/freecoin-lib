(defproject org.clojars.dyne/freecoin-lib "0.4.0"
  :description "Freecoin digital currency toolkit"
  :url "https://freecoin.dyne.org"

  :license {:author "Dyne.org Foundation"
            :email "foundation@dyne.org"
            :year 2017
            :key "gpl-3.0"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.taoensso/timbre "4.10.0"]
                 [org.clojure/math.numeric-tower "0.0.4"]
                 [buddy/buddy-hashers "1.2.0"]
                 [simple-time "0.2.1" :exclusions [joda-time]]
                 [environ "1.1.0"]
                 [clojure-humanize "0.2.2"]

                 ;; mongodb
                 [com.novemberain/monger "3.1.0"]

                 ;; fxc secret sharing protocol
                 [org.clojars.dyne/fxc "0.5.0"]

                 ;; Data validation
                 [prismatic/schema "1.1.6"]

                 [clj-btc "0.11.2"]]

  :source-paths ["src"]
  :resource-paths ["resources" "test-resources"]
  :jvm-opts ["-Djava.security.egd=file:/dev/random"
             ;; use a proper random source (install haveged)

             "-XX:-OmitStackTraceInFastThrow"
             ;; prevent JVM exceptions without stack trace
             ]
  :env [[:base-url "http://localhost:8000"]]
  :profiles {:dev [:dev-common :dev-local]
             :dev-common {:dependencies [[midje "1.8.3"]]
                          :repl-options {:init-ns freecoin-lib.core}
                          :plugins [[lein-midje "3.1.3"]]}}
  :plugins [[lein-environ "1.0.0"]])
