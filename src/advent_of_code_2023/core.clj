(ns advent-of-code-2023.core
  (:gen-class)
  (:require [clojure.java.io :as io])
  (:require [clj-http.client :as http]))

(def input-path-template "resources/input/%s/day_%s")

(defn save-string-to-file [file-path content]
  (let [file (io/file file-path)
        parent-dir (.getParentFile file)]
    (.mkdirs parent-dir))
  (spit file-path content))

(defn make-request [url]
  (let [headers {"Cookie" (System/getenv "AOC_COOKIE")}
        response (http/get url {:headers headers})]
    response))

(defn get-input [year day]
  (slurp (format input-path-template year day)))

(defn -main [command year day]
  (if (= command "download")
    (let [url-template "https://adventofcode.com/%s/day/%s/input"]
      (save-string-to-file
       (format input-path-template year day)
       (:body (make-request (format url-template year day))))))
  (if (= command "run")
    (let [file-path (str "src/advent_of_code_2023/" year "/day_" day ".clj")]
      (if (.exists (java.io.File. file-path))
        (load-file file-path)
        (println (str "The file " file-path " does not exist."))))))
