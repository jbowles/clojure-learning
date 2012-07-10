(defn select-random
  "Returns a random item from a list of items."
  {:added "1.2"}
  [options]
  (nth options (rand-int (count options)))
)

(def approaches (list "ferocious" "whimpy" "precarious" "subtle"))
(def actions (list "growl" "lick" "jump"))
(def conjoin "... and ...\n")

;;;; Variable Arity
;; Function defined with optional set of args
(defn greeting [greeter whom & options]
  (str greeter " greeted " whom " with a "
       (if (first options)
         (first options)
         (select-random approaches)) " "
       (if (> (count options) 1)
         (second options)
         (select-random actions)) "!\n"))

;;;; Pattern Matching
;;; Function defined with pattern matching for optional 'approach' and 'action' arguments
;(defn greeting
;  ;match first pattern
;  ([greeter whom]
;   (greeting greeter whom nil nil))
;  ;match second pattern
;  ([greeter whom approach]
;   (greeting greeter whom approach nil))
;  ;match third pattern
;  ([greeter whom approach action]
;   (str greeter " greeted " whom " with a "
;        (if approach
;          approach
;          (select-random approaches)) " "
;        (if action
;          action
;          (select-random actions)) "!\n")))

(print (greeting "John" "Thaddeus"))

(print conjoin (greeting "Lisa" "Thaddeus"))

(print conjoin (greeting "Thaddeus" "Leela" "happy" "smack"))

(print conjoin (greeting "Leela" "Mickey" "sullen"))



;;;; Refactored version
;; Function expecting 4 arguments -- must provide nil/false for missing args or else
;; an ArityException is thrown
;(defn greeting [greeter whom approach action]
;  (str greeter " greeted " whom " with a "
;       (if approach
;         approach
;         (select-random approaches)) " "
;       (if action
;         action
;         (select-random actions)) "!\n"))
;(print (greeting "John" "Thaddeus" false false))
;
;(print conjoin (greeting "Lisa" "Thaddeus" false false))
;
;(print conjoin (greeting "Thaddeus" "Leela" "happy" "smack"))
;
;(print conjoin (greeting "Leela" "Mickey" "sullen" false))

