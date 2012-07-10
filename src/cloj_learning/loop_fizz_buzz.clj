;;;; NOT OPTIMAL FOR SOLVING FIZZ-BUZZ

(defn multiple? [n div]
  (= 0 (mod n div)))

(loop [data (range 1 101)]
  (if (not (empty? data))
      (let [n (first data)]
        (cond (and (multiple? n 3)(multiple? n 5))
                     (println "FizzBuzz")
                   (multiple? n 3)
                     (println "Fizz")
                   (multiple? n 5)
                     (println "Buzz")
                 :else (println n))
             (recur (rest data)))))
