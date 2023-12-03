(ns advent-of-code-2023.2023.day-1
  (:require [advent-of-code-2023.core :as core]
            [clojure.string :as str]))

(def input
  (str/split (core/get-input 2023 1) #"\n"))

(def test-input-1
  ["1abc2" "pqr3stu8vwx" "a1b2c3d4e5f" "treb7uchet"])

(def test-input-2 ["two1nine" "eightwothree" "abcone2threexyz" "xtwone3four" "4nineeightseven2" "zoneight234" "7pqrstsixteen"])

(defn extract-first-and-last-digit [line]
  (let [digits (keep #(if (Character/isDigit %) %) line)]
    (str (first digits) (last digits))))

(defn part-1 [in]
  (let [thing (map extract-first-and-last-digit in)]
    (reduce + (map #(Integer/parseInt %) thing))))

(part-1 input)

(defn iterate-substrings [s]
  (for [i (range (count s))]
    (subs s i)))

(defn check-for-numbers [in]
  (cond
    (str/starts-with? in "one") \1
    (str/starts-with? in "two") \2
    (str/starts-with? in "three") \3
    (str/starts-with? in "four") \4
    (str/starts-with? in "five") \5
    (str/starts-with? in "six") \6
    (str/starts-with? in "seven") \7
    (str/starts-with? in "eight") \8
    (str/starts-with? in "nine") \9
    :else (first in)))

(defn convert-line [in]
  (reduce str (map #(check-for-numbers %) (iterate-substrings in))))

(defn part-2 [in]
  (part-1 (map #(convert-line %) in)))

(part-2 input)




