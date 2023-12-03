(ns advent-of-code-2023.2023.day-2
  (:require [advent-of-code-2023.core :as core]
            [clojure.string :as str]))

(def input 
  (core/get-input 2023 2))

(def test-input "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")

(def pattern #"(\d+) (\w+)")

(defn thing [in] 
 (let [[_ amount animal] (re-matches pattern in)]
    {(keyword animal) amount}))

(thing "3 blue, 4 red")

(defn is-enough? [s]
  (let [n (first (str/split s #" "))
        color (second (str/split s #" "))]
    (cond
      (= color "blue") (>= 14 (Integer/parseInt n))
      (= color "red") (>= 12 (Integer/parseInt n))
      (= color "green") (>= 13 (Integer/parseInt n)))))

(defn is-game-possible? [game]
  (let [plays (str/split (second (str/split game #": ")) #"[,;]\s")]
    (every? identity (map  #(is-enough? %) plays))))

(defn index-plus-one-if-true [index value]
  (when value (inc index)))


(defn part-1 [in]
  (let [bools (vec (map #(is-game-possible? %) (str/split in #"\n")))
        indexed-plus-one-true-elements (map-indexed index-plus-one-if-true bools)]
        (reduce + (filter some? indexed-plus-one-true-elements))))

(part-1 input)

