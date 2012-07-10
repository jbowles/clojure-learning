(defn msec []
  "Use java lib to capture sytem time in milliseconds"
  (System/currentTimeMillis))

(defn import_date []
  "import java libs for convenience functions on Date"
  (import java.util.Date)
  (import java.text.SimpleDateFormat))

(defn date
  "get the system time"
  ([](Date.))
  ([systime](Date. systime)))

(defn format_date
  "formats Date to string; accepts millisecond or string format as args.
  EX: (format-date (date 404534000000)); (format-date 'yyyy/MM/dd HH:mm:ss')"
  ([](format_date (date) "yyyy-MM-dd HH:mm:ss"))
  ([x](if (string? x)
        (format_date (date) x)
        (format_date x "yyyy-MM-dd HH:mm:ss")))
  ([dt fmt](.format (SimpleDateFormat. fmt) dt)))

;; load string utilities from Clojure contrib. Get the java.util.regex.Pattern class
;(use 'clojure.contrib.str-utils)
;(re-split #":|-" (format_date))

;; Split date using regex;
(defn date_list
  "Regex date; system by default, will accept arg"
  ([](re-split #"\W+" (format_date)))
  ([systime](re-split #"\W+" (format_date systime))))

;; bind date_list to local variable to print time a report was run
(defn run_report []
  (let [date (date_list)]
    (str "report ran at = " (nth date 3) ":" (nth date 4))))
