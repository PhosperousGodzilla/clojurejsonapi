(defproject clojurejsonapi "0.1.0"
  :description "Trying this json api service in clojure" 
  :dependencies [[org.clojure/clojure "1.4.0"] 
           [compojure "1.1.5"]
           [cheshire "5.0.1"]
           [ring/ring-json "0.1.2"]
           [ring/ring-jetty-adapter "1.1.8"]
           [clojurewerkz/neocons "1.0.2"]]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler clojurejsonapi.handler/app
         :port 3005}
  :main clojurejsonapi.handler
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
