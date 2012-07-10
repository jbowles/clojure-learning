(import
  '(java.util Calendar GregorianCalendar)
  '(javax.swing JFrame JLabel))

(. java.util.Calendar APRIL)
(. Calendar APRIL)
java.util.Calendar/APRIL
Calendar/APRIL

(. Math pow 2 4)

(def calend-one (new GregorianCalendar 2008 Calendar/APRIL 16))
(def calend-two (GregorianCalendar. 2008 Calendar/APRIL 16))

;(println calend-one)

(. calend-one add Calendar/MONTH 2)
(. calend-one get Calendar/MONTH)
(.add calend-one Calendar/MONTH 2)
(.get calend-one Calendar/MONTH)

;;;; chaining
(. (. calend-two getTimeZone) getDisplayName)
(.. calend-two getTimeZone getDisplayName)

;;;; using
(doto calend-two
  (.set Calendar/YEAR 1981 )
  (.set Calendar/MONTH Calendar/AUGUST )
  (.set Calendar/DATE 1 ))
(def formatter (java.text.DateFormat/getDateInstance))
(.format formatter (.getTime calend-two))

;;;; memfn
(println (map #(.substring %1 %2)
              ["Moe" "Larry" "Curly"] [1 2 3]))
(println (map (memfn substring beginIndex)
              ["Moe" "Larry" "Curly"] [1 2 3]))
