(ns advent-of-code-2023.2017.day-1
  (:require [advent-of-code-2023.core :as core]
            [clojure.string :as str]))

(defn convert-char-to-digit [char]
  (. Character (digit char 10)))

(defn sum-if-prev-same [[prev-sum prev-dig] current-dig]
  (if (= prev-dig current-dig)
    [(+ prev-sum current-dig) current-dig]
    [prev-sum current-dig]))

(defn solve [input]
  (reduce + (map convert-char-to-digit input)))

(solve "1585")

(solve (core/get-input 2017 1))



