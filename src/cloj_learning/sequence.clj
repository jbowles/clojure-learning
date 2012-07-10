(doseq [item [1 2 3]] (println item))
(dorun (map #(println %) [1 2 3]))
(doall (map #( do (println %) %) [1 2 3]))


;;;; Lazy sequences allow infinite sequences
(defn f [x]
  (println "calculating f of" x)
  (/ (* x x) 2.0))

;(f 4)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; binding the result to 'f-seq will allow it to cache results
;;;; and be faster (thoug it uses more memory)
(def f-seq (map f (iterate inc 0)))
(doall (take 3 f-seq))

(println "first is" (first f-seq))
(println (nth f-seq 2))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; by not binding the result to a variable the function is
;;;; not as fast but uses less memory than the functions above
(defn g-seq [] (map f (iterate inc 0)))
(println (first (g-seq)))
(println (nth (g-seq) 2))

;;;; avoid holding head of sequence in a binding by
;;;; passing lazy sequence to a function
(defn consumer [seq]
  ; Since seq is a local binding the evaluated items are 
  ; cached while in scope of function and then garbge collected
  (println (first seq))
  (println (nth seq 2)))

(consumer (map f (iterate inc 0)))
