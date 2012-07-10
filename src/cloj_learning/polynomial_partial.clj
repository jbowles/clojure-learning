(defn- polynomial
  "computes value of polynomial with given coefficients for given value x"
  [coefs x]
  (let [exponents (reverse (range (count coefs)))]
    (apply + (map #(* %1 (Math/pow x %2)) coefs exponents))))

(defn- derivative
  "computes value of deriviative of polynomial with given coefficients for given value x"
  [coefs x]
  (let [exponents (reverse (range (count coefs)))
        derivative-coefs (map #(* %1 %2) (butlast coefs) exponents)]
    (polynomial derivative-coefs x)))

(defn- polynm [coefs x]
  (reduce #(+ (* x %1) %2) coefs))

(defn- derivt
  "computes value of deriviative of polynomial with given coefficients for given value x"
  [coefs x]
  (let [exponents (reverse (range (count coefs)))
        derivt-coefs (map #(* %1 %2) (butlast coefs) exponents)]
    (polynm derivt-coefs x)))


(def f (partial polynomial [2 1 3])) ; 2x^2 + x + 3
(def f-prime (partial derivative [2 1 3])) ; 4x + 1
(def fmn (partial polynm [2 1 3])) ; 2x^2 + x + 3
(def f-primemn (partial derivt [2 1 3])) ; 4x + 1

(println "Setting polynomial to partial: f(2) =" (time (f 2))) ; 13.0
(println "Setting derivative to partial: f'(2) =" (time (f-prime 2))) ; 9.0
(println "Setting polynm to partial: f(2) =" (time (fmn 2))) ; 13.0
(println "Setting derivt to partial: f'(2) =" (time (f-primemn 2))) ; 9.0

(println "Using polynomial function alone {[2 1 3] 2} = " (time (polynomial [2 1 3] 2)))
(println "Using derivative function alone {[2 1 3] 2} = " (time (derivative [2 1 3] 2)))
(println "Using polynm function alone {[2 1 3] 2} = " (time (polynm [2 1 3] 2)))
(println "Using derivt function alone {[2 1 3] 2} = " (time (derivt [2 1 3] 2)))

