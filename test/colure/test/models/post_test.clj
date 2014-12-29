(ns colure.test.models.post_test
	(:require [clojure.test :refer :all]
			  [colure.models.post :refer :all]))

(init-db "test")

(deftest persist-test
	(let [id (create { :title "Foo" :message "This is a test" })
		  retrieved (fetch id)]
		(testing "Inserts and retrieves a document."
			(is (= (retrieved :title) "Foo")))))