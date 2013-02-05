(ns clojurejsonapi.crud
	(:use cheshire.core)
	(:use compojure.core)
	(:use ring.util.response)
	(:require 
			  ;[ring.middleware.json :as middleware]
			  [clojure.string :as str])) 

(def my-data {:foo "bar" :wolf 1 :people {:name "riding hood" :attr "red scarf" :age 6}})

(defn add []
	my-data
	)
