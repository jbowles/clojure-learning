(loop [data (range 1 101)
       n (first data)
       n-count 0
       result nil]
  (if (and n (< n-count 10))
    (if (even? n)
      (recur (rest data) (first data) (inc n-count) (cons n result))
      (recur (rest data) (first data) n-count result))
    (reverse result)))
