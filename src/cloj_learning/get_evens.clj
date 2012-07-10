;;;; Compare to for_loop file for worse implementation
(defn take_evens
    ([x nums](take_evens x nums 0 nil))
    ([x nums n-count result]
      (if (empty? nums)
          (reverse result)
          (if (< n-count x)
              (let [n (first nums)]
                (if (even? n)
                    (recur x (rest nums) (inc n-count) (cons n result))
                    (recur x (rest nums) n-count result)))
              (reverse result)))))

(print (take_evens 1000 (range 1 10000)))

;;real	0m1.900s
;;user	0m2.616s
;;sys	0m0.170s
