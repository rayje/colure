(ns colure.routes.post
  (:require [compojure.core :refer :all]
            [colure.models.post :as post]
            [cheshire.core :as json]))

(def to-json json/generate-string)

(defn create [params]
	(let [user (json/parse-string params)]
		(prn user)
		{:status 201
		 :headers {"Content-Type" "application/json"}
		 :body (to-json user)}))

(defroutes post-routes
  (POST "/posts" {body :body} (create (slurp body))))
