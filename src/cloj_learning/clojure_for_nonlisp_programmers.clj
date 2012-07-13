;; doesn't work
;(defn sysinfo []
;  println((str "File system:" *file* "Compile Path:" *compile-path* "Version:" *clojure-version* )))
;
;(sysinfo)

;; Some built-in keywords
;*file*
;*compile-path*
;*clojure-version*
;*command-line-args*
;+


(defn
  ^{:limited true
    :description "collect system information"
    :test (fn []
            (assert (or
                      (= 
                        (= *file* "REPL") 
                        (= *compile-path* "classes") 
                        (= *clojure-version* {:major 1, :minor 3, :incremental 0, :qualifier nil})) 
                      (= (string? *file*) (string? *compile-path*) (map? *clojure-version*)))))
    :todo "figure out how to run the test from meta-data"
    }
  sys-info
  "vector containing limited core symbols"
  []
  [*file* *compile-path* *clojure-version*])

(sys-info)
(.invoke sys-info) ; IFn interface uses this to get type checks to the JVM:: all arguments to .invoke are defined by IFn to be type Object. (http://kotka.de/blog/2012/06/Did_you_know_IX.html). 
(source sys-info)
(meta #'sys-info)
;(meta (var sys-info))
(get (meta #'sys-info) :todo)
(get (meta #'sys-info) :type)
(if (:todo (meta #'sys-info)) (get (meta (var sys-info)) :todo))
(first (sys-info))
(rest (sys-info))
(last (sys-info))
((sys-info) 2)


;; Code as data
(defn mixed-maps
  "simple function to display two kinds of clojure maps"
  []
;; Imagine this: I have a set of data with consistent keys (colors) but I have two types of values: 
;; fruit and miscellaneous objects., and then I have two other hashes with mixed strings, keywords, numbers
  {:colors-misc {:blue "blueberry" :green :car :red "apple" :orange :flower}
  "string-key" {"one" 1 "two" 2 "three" 3}
  :keyword-key {:one 1 :two 2 :three 3}})

(class (mixed-maps))
(mixed-maps)
;; we can treat our function that returns a persistent hash map AS the hash map itself (CaD)
(get (mixed-maps) "string-key")
;; OR, instead of a function that returns a map we'll just pass in map and the behavior is the same!!
;; Maps can be used as functions of their keys.
(:a {:a "alpha" :b "beta" :g "gamma"})
(get (mixed-maps) :keyword-key)
((mixed-maps) :keyword-key)
(:keyword-key (mixed-maps))
((mixed-maps) "string-key")
;; get keys or values, they are a function operator and need to come before the data type
(vals (mixed-maps))
(count (mixed-maps))
(keys (mixed-maps))
;("string-key" (mixed-maps))
(println (str "Notice with a string key that this does not work " `("string-key" (mixed-maps))))
;; Notice in the above print line function that takes the string funciton as an argument: the backtick is a syntax quote
;; and tells REPL not to evaluate... it just reads it; but also notice that it returns the value of the namespace that teh function is operating in.. which is 'user'
(println (str "Notice with a string key that this does not work " '("string-key" "one" 1 "two" 2 "three" 3)))
;; I can also get the same effect with creating a list using the speial form for quote. That is, the list not evaluated because there is no function it is the eargument of, so I can doubly create the list and document it (CaD).
(println (str "Notice with a string key that this does not work " '(println '("string-key" "one" 1 "two" 2 "three" 3))))
;; But that's not all, I can also pass it to an function! But notice that I get some REPL feedback ("'" is evaluated as "quote")
;; And if you still don't believe me that CaD is for real, we'll pass through the REPL to be compeltely evaluated:
(println '("string-key" "one" 1 "two" 2 "three" 3))
;; No more REPL feedback because I'm not skipping evaluation, this time we get the evlauated list.
;; Don't forget that we started out with this:
((mixed-maps) "string-key")
;; and we cna get the class name with the special-form
(class '(mixed-maps))
;; but why stop there, we can do more:
(source mixed-maps)
(source sys-info)
(source defn)
;(meta-data defn)
;; And remember the special forms for syntax-quote and quote
;(type (quote))
;;
;;
;; perhaps we want to see this:
(source class)
;; we can only peek in so far...
(println (str "This will error out " '(source ((mixed-maps) "string-key"))))

(fn? ((mixed-maps) "string-key"))

;; let's get back to querying our data
(vals ((mixed-maps) "string-key"))
(filter #(even? %) (vals ((mixed-maps) "string-key")))

(vals ((mixed-maps) :keyword-key))
(filter #(even? %) (vals ((mixed-maps) :keyword-key)))


(class (filter #(even? %) (vals ((mixed-maps) :keyword-key))))

;; the tick evaluates differently than the function for list.
;; That is, it actually evaluates list elements
'(class (filter #(even? %) (vals ((mixed-maps) :keyword-key))))
(list (class (filter #(even? %) (vals ((mixed-maps) :keyword-key)))))

(println '(class (filter #(even? %) (vals ((mixed-maps) :keyword-key)))))
(println (list (class (filter #(even? %) (vals ((mixed-maps) :keyword-key))))))

(macroexpand-1 (println '(class (filter #(even? %) (vals ((mixed-maps) :keyword-key))))))
(macroexpand-1 (println (list (class (filter #(even? %) (vals ((mixed-maps) :keyword-key)))))))
;; Since the last function creates an evaluated list, it too, being a list, is now a data type! CaD!!
(count (macroexpand-1 (println (list (class (filter #(even? %) (vals ((mixed-maps) :keyword-key))))))))
;; Remember these? We can count collections just like we can count evaluated code: CaD.
(count {:blue "blueberry" :green :car :red "apple" :orange :flower})
(count (mixed-maps))


;; Remember that first function that had a test written in its metadata? Well, because of CaD we can do this:
(test (var sys-info))





;; SPECIAL SAUCE!
;; Last, a macro that displays the CaD; using syntax comment to allow an expansion of the macro:
;; In other words, we want to see the code that will be created (and evaluated) by the macro

(defmacro around-zero [number negative-expr zero-expr positive-expr]
  `(let [number# ~number]
     (cond
       (< (Math/abs number#) 1e-15) ~zero-expr
       (pos? number#) ~positive-expr
       true ~negative-expr)))

(macroexpand-1 '(around-zero 0.1 (println "-") (println "0") (println "+")))
(println (around-zero 0.1 "-" "0" "+"))

(around-zero 1.1 "negative" "zero" "positive")
(macroexpand-1 '(around-zero 1.1 "negative" "zero" "positive"))

