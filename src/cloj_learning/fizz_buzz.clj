(defn multiple? [n div]
  (= 0 (mod n div)))

(doseq [i (range 1 101)]
  (cond (and (multiple? i 3)(multiple? i 5))
          (println "FizzBuzz")
        (multiple? i 3)
          (println "Fizz")
        (multiple? i 5)
          (println "Buzz")
    :else (println i)))

