(defn select-random
  "Returns a random item from a list of items."
  {:added "1.2"}
  [options]
  (nth options (rand-int (count options)))
)

(def vlist [1,2,3,4,5,6,7,8,10,12,13,14,16,34,22,33,334,556,4443,222,6453,544,24342,4342,43,2432,242,64,876,9,4754,8765,354,87679,464])

(print (select-random vlist))
(print (select-random (list "growl" "lick" "jump")))
