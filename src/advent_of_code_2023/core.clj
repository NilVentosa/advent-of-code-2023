(ns advent-of-code-2023.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [clj-http.client :as http]))

(defn ensure-parent-dir [file-path]
  (let [file (io/file file-path)
        parent-dir (.getParentFile file)]
    (.mkdirs parent-dir)))

(defn save-string-to-file [file-path content]
  (ensure-parent-dir file-path)
  (spit file-path content))

(defn make-request [url]
  (let [headers {"Cookie" (System/getenv "AOC_COOKIE")}
        response (http/get url {:headers headers})]
    response))

(defn -main [year day]
  (let [url-template "https://adventofcode.com/%s/day/%s/input"]
    (save-string-to-file
      (format "resources/input/%s/day_%s" year day)
      (:body (make-request (format url-template year day))))))
