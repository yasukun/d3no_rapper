(defproject d3no_rapper "0.1.0-SNAPSHOT"
  :source-paths ["src/clj" "src/cljs"]
  :description "A ClojureScript wrapper for d3js"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2156"]]
  :plugins [[lein-clojars "0.9.1"]]
;  :hooks [leiningen.cljsbuild]
  :jar-exclusions [#"index.html|d3no_rapper.js|core.clj$"]
  :profiles {:dev {:repl-options {:init-ns d3no_rapper.core}
                   :dependencies [[ring "1.2.1"]
                                  [compojure "1.1.6"]
                                  [enlive "1.1.5"]]
                   :plugins [[lein-cljsbuild "1.0.2"]
                             [com.cemerick/austin "0.1.3"]]
                   :cljsbuild {:builds [{:jar true
                                         :source-paths ["src/cljs"]
                                         :compiler {:output-to "target/classes/public/d3no_rapper.js"
                                                    :optimizations :simple
                                                    :pretty-print true}}]}}})
