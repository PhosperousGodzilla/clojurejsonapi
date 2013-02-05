(ns clojurejsonapi.handler
  (:use [compojure.core]
        [ring.middleware.json])
  (:require [clojure.string :as str]
        		[compojure.handler :as handler]
        		[compojure.core :as cc]
        		[compojure.route :as route]
        		[cheshire.core :refer :all :as json] 
        		[ring.adapter.jetty :as jetty]
        		[ring.middleware.json :as middleware]
            [clojurejsonapi.crud :as crud])
  (:gen-class))

;function declarations
(declare json-response)

(def my-data {:foo "bar" :baz 5 })

(cc/defroutes app-routes 
  (cc/GET "/"
    []
    "Hello")
  (cc/GET "/add"
    []
    (json-response(crud/add)))
  (cc/POST "/add" 
    {params :params} 
    (str "params: " params))

  (route/not-found "Nope"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-params)
      ;(middleware/wrap-json-body)
      ;(middleware/wrap-json-response)
      ))

; stop from blocking user repl
; for deployment purposes
(defn -main
  [& [port]]
  (let [port (Integer. (or port
                           (System/getenv "PORT")
                           33433))]
    (jetty/run-jetty #'app {:port  port
                            :join? false})))

;json wrapper for responses
(defn json-response [data & [status]]
  {:status (or status 200)
    :headers {"Content-Type" "application/json"}
    :body (json/generate-string data {:pretty true})})