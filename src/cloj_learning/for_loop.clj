;;;; Compare to get_evens file for better implementation
(defn take_evens [x nums]
  "give even numbers; accepts two args: limit of printed numbers and the range
  EX: (take_events 10, range(1 101))"
  (take x
        (for [n nums
              :when (even? n)]
          n)))


(print (take_evens 1000 (range 1 100000)))

;real	0m1.827s
;user	0m2.471s
;sys	0m0.163s
