(ns advent-of-code-2023.2018.day-2
  (:require [advent-of-code-2023.core :as core]
            [clojure.string :as str]))
(def input
  (core/get-input 2018 2))

(def clean-input
  (str/split input #"\n"))

(def test-input
  ["abcdef" "bababc" "abbcde" "abcccd" "aabcdd" "abcdee" "ababab"])

(defn has-n-char-repetitions? [text n]
  (let [char-frequencies (frequencies text)]
    (boolean (some #(= (second %) n) char-frequencies))))

(defn part-1 [input]
  (* (count (filter #(has-n-char-repetitions? % 2) input))
     (count (filter #(has-n-char-repetitions? % 3) input))))

(part-1 clean-input)

(defn differ-by-one-char? [str1 srtr2]
  )

(differ-by-one-char? "hello" "hellp")

(defn part-2 [input]
  (let [twos (filter #(has-n-char-repetitions? % 2) input)
        threes (filter #(has-n-char-repetitions? % 3) input)
        all (concat twos threes)]
     ))

(part-2 test-input)
