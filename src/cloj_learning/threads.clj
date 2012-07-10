(defn my-fn [ms]
  (println "entered my fn")
  (Thread/sleep ms)
  (println "leaving my-fn"))

(defn thread-myfunc-test [thread_sleep]
  (time (let [thread (Thread. #(my-fn thread_sleep))] ;
   (time (.start thread))
    (println "... reflects inside started thread scope")
    (while (.isAlive thread)
      (print ".")
      (flush))
    (println "\n thread stopped and outside of scope: total =>"))))

(thread-myfunc-test 2)

;;;;;;;;;;;;;;;;;;using these functions for thread test;;;;;;;;;;;;;;;
(defn- polynomial
  "computes the value of a polynomial
   with the given coefficients for a given value x"
  [coefs x]
  ; For example, if coefs contains 3 values then exponents is (2 1 0).
  (let [exponents (reverse (range (count coefs)))]
    ; Multiply each coefficient by x raised to the corresponding exponent
    ; and sum those results.
    ; coefs go into %1 and exponents go into %2.
    (apply + (map #(* %1 (Math/pow x %2)) coefs exponents))))

(defn- derivative
  "computes the value of the derivative of a polynomial
   with the given coefficients for a given value x"
  [coefs x]
  ; The coefficients of the derivative function are obtained by
  ; multiplying all but the last coefficient by its corresponding exponent.
  ; The extra exponent will be ignored.
  (let [exponents (reverse (range (count coefs)))
        derivative-coefs (map #(* %1 %2) (butlast coefs) exponents)]
    (polynomial derivative-coefs x)))

(def f (partial polynomial [2 1 3])) ; 2x^2 + x + 3
(def f-prime (partial derivative [2 1 3]))
;(f-prime 2)

;;;;;;;;;;;;;;;;;;using these functions for thread test;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn thread-test [n]
  (println "creating future...")
  (def my-future (future (f-prime n)))
  (println "created future.")
  (println "original result is..." @my-future)
  (def new-my-future (+ 1.0 @my-future))
  (println "modified result is..." new-my-future)
  (shutdown-agents))

(thread-test 2)

