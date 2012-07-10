(comment
  SEE: clojure/java/io.clj

  *in*, *out*, *err* are set to
  stdin, stdout, stderr

  use (flush) to flush buffered output
  same as (.flush *out*)
comment)

;;;; redirect stdout to file
;;;; with no directory specified in FileWriter the file will be created
;;;; in the root of the project
(binding [*out* (java.io.FileWriter. "log/redirect_stdout.log")]
  (println "Redirected output to logfile in the log directory")
  (flush))

(let [obj1 "foo"
      obj2 {:letter \a :number (Math/PI)}]
  (println "Output from print:")
  (print obj1 obj2"\n")

  (println "\nOutput from println:")
  (println obj1 obj2"\n")

  (println "Output from pr:")
  (pr obj1 obj2)

  (println "\nOutput from prn:")
  (prn obj1 obj2))

(use '[clojure.java.io :only (reader)])
(defn print-if-contains [line word]
  (when (.contains line word) (println line)))

;;;; use 'slurp' and 'spit' for read and write strings
(let [file "story.txt" 
      word "fur"]
  ;with-open will close th ereader after evaluating all expressions
  ;in its body
  (with-open [rdr (reader file)]
    (doseq [line (line-seq rdr)] (print-if-contains line word))))

