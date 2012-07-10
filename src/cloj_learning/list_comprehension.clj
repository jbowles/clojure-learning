(def cols "ABCDEFGHI")
(def rows (range 1 9))

(println "'for demo")
(dorun
  (for [col cols :when (not= col \B)
        row rows :while (< row 7)]
    (println (str col row))))

(println "\n 'doseq demo")
(doseq [col cols :when (not= col \C)
        row rows :while (< row 3)]
  (println (str col row)))
