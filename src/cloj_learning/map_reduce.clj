;(map #(.trim %)
;    (re-split #"[\:\,]" "Juice: 1.15, Sandwich: 4.65, Banana: 0.99"))

(defn trim [s]
  (.trim s))

(trim " strim  ")
;(fn? trim)

(map trim
    (re-split #"[\:\,]" "Juice: 1.15, Sandwich: 4.65, Banana: 0.99"))

(def lunch
  (partition 2
             (map trim
                  (re-split #"[\:\,]" "Juice: 1.15, Sandwich: 4.65, Banana: 0.99")
                  )
             )
  )

(for [[item cost] lunch] item)
(for [[item cost] lunch] cost)

(map first lunch)
(map last lunch)

(map #(Float. (last %)) lunch)
(reduce + (map #(Float. (last %)) lunch))

(defn total_spent [x]
  (if (string? x)
    (reduce +
            (map #(Float. (last %))
                 (partition 2 (re-split #"[\:\,]" x))))
            (reduce + (map total_spent x))))

(total_spent "Juice: 1.15, Sandwich: 4.65, Banana: 0.9")
