(ns advent-of-code-2023.2018.day-1
  (:require [advent-of-code-2023.core :as core]
            [clojure.string :as str]))
(def input
  (core/get-input 2018 1))

(defn get-numbers
  "hello there this is documentation right?"
  [input]
  (map parse-long (str/split input #"\n")))

(defn part-1 []
  (reduce + (get-numbers input)))

(part-1)

(defn part-2 []
  (let [nums (get-numbers input)
        cycled-nums (cycle nums)
        freqs (reductions + cycled-nums)
        visited (atom #{})]
    (loop [f (first freqs)
           fs (rest freqs)]
      (if (contains? @visited f)
        f
        (do
          (swap! visited conj f)
          (recur (first fs) (rest fs)))))))

(part-2)
