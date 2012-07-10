;; MACRO NAMES CANNOT BE PASSED AND AS ARGUMENTS TO FUNCTIONS

(defmacro around-zero [number negative-expr zero-expr positive-expr]
  `(let [number# ~number]
     (cond
       (< (Math/abs number#) 1e-15) ~zero-expr
       (pos? number#) ~positive-expr
       true ~negative-expr)))

(macroexpand-1 '(around-zero 0.1 (println "-") (println "0") (println "+")))
(println (around-zero 0.1 "-" "0" "+"))

(defn number-category [number]
  (around-zero number "negative" "zero" "positive"))

(number-category 0)
(number-category 100)
(number-category -10)


(defmacro trig-y-category [fn degrees]
  `(let [radians# (Math/toRadians ~degrees)
         result# (~fn radians#)]
     (number-category result#)))

(doseq [angle (range 0 360 90)]
  (println (trig-y-category Math/sin angle)))

