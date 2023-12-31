(ns advent-of-code-2023.2022.day-1
  (:require [advent-of-code-2023.core :as core]
            [clojure.string :as str]))
(def input
  (core/get-input 2022 1))

(defn clean-input [input]
  (map #(str/split % #"\n") (str/split input #"\n *\n *")))

(defn sum-calories [clean-input]
  (for [elf-calories clean-input]
    (reduce + 0 (map parse-long elf-calories))))

(defn part-1 []
  (apply max (sum-calories (clean-input input))))

(part-1)

(defn part-2 []
  (reduce + (take 3 (sort > (sum-calories (clean-input input))))))

(part-2)
