;;;; dotimes
;(dotimes [card-number 3]
;  (println "deal card number" (inc card-number)))

;;;; while
(defn my-fn [ms]
  (println "entered my fn")
  (Thread/sleep ms)
  (println "leaving my-fn"))

(time (let [thread (Thread. #(my-fn 1000))] ;takes a little over a second
 (time (.start thread))
  (println "... reflects inside started thread scope")
  (while (.isAlive thread)
    (print ".")
    (flush))
  (println "\n thread stopped and outside of scope: total =>")))

