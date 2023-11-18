(ns advent-of-code-2023.2016.day-1
  (:require [advent-of-code-2023.core :as core]
            [clojure.string :as str]))

(defn move [direction distance position]
  (let [[x y] position
        [dx dy] direction]
    [(+ x (* dx distance)) (+ y (* dy distance))]))

(defn solve [seq]
  (str/split seq #", "))

(solve "R5, L5, R5, R3")

(println (= (solve "R2, L3") 5))
(println (= (solve "R2, R2, R2") 2))
(println (= (solve "R5, L5, R5, R3") 12))
(println (solve (core/get-input 2016 1)))
