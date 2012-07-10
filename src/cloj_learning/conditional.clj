(import '(java.util Calendar GregorianCalendar))

;(.toString Calendar/DAY_OF_WEEK)

;;;; if, do
(let [gc (GregorianCalendar.)
      day-of-week (.get gc Calendar/DAY_OF_WEEK)
      is-weekend? (or (= day-of-week Calendar/SATURDAY) (= day-of-week Calendar/SUNDAY))]
  (if is-weekend?
    (println (str "play... it is " day-of-week)
    (do (println "work")
      (println "sleep")))))

;;;; when, when-not
(let [gc (GregorianCalendar.)
      day-of-week (.get gc Calendar/DAY_OF_WEEK)
      is-weekend? (or (= day-of-week Calendar/SATURDAY) (= day-of-week Calendar/SUNDAY))]
  (when is-weekend?
    (println (str "play... it is " day-of-week))
  (when-not is-weekend?
    (println "work")
      (println "sleep"))))

;;;; if-let
(defn process-next [waiting-line]
  (if-let [name (first waiting-line)]
    (println name " is up...")
    (println " no waiting")))

(process-next '("Jade" "Bella" "Mindy" "Mary")) ; Jade is up...
(process-next '("")) ;  is uo...
(process-next '()) ;no waiting

;;;; when-let
(defn summarize
  [coll]
  (when-let [head (first coll)]
    (print head)
    (dotimes [ticker (dec (count coll))] (print (str (inc ticker) ", "))))
    (println))

(def embedvec [["1.1" "1.2" "1.3"]["2.1" "2.2" "2.3"]["3.1" "3.2" "3.3"]["4.1" "4.2" "4.3"]])
(summarize ["Moe" "Larry" "Curly"])
(summarize embedvec)

;;;; condp (like a case statement)
(print "Enter a number... ") (flush)
(let [reader (java.io.BufferedReader. *in*) ;standard input buffer set to local variable
      line (.readLine reader) ;set all lines from I/O to local variable
      value (try
              (Integer/parseInt line)
              (catch NumberFormatException e line))] ;catch exception when not a number
  (println 
    (condp = value
      1 "one"
      2 "two"
      3 "three"
      (str "unexpected value, \"" value \")))
  (println
    (condp instance? value
      Number (str value " multiplied by 2 is " (* value 2))
      String (str "String has " (count value) " characters, multiplied by 2 is " (* (count value) 2)))))

;;;; cond
(print "Enter water temp in Celsius: ") (flush)
(let [reader (java.io.BufferedReader. *in*) ;standard input buffer set to local variable
      line (.readLine reader) ;set all lines from I/O to local variable
      temperature (try
                    (Float/parseFloat line)
                    (catch NumberFormatException e line))] ;catch exception when not a number
  (println
    (cond
      (instance? String temperature) "invalid temperature, must be a number!"
      (<= temperature 0) "freezing"
      (>= temperature 100) "boiling"
      true "neither boiling or freezing")))
