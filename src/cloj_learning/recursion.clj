(defn factorial-1 [number]
  (loop [n number factorial 1]
    (if (zero? n)
      factorial
      (recur (dec n) (* factorial n)))))

(println (time (factorial-1 100.0)))
