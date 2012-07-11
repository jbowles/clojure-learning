;; doesn't work
;(defn sysinfo []
;  println((str "File system:" *file* "Compile Path:" *compile-path* "Version:" *clojure-version* )))
;
;(sysinfo)

;; Some built-in keywords
*file*
*compile-path*
*clojure-version*
*command-line-args*
+

(defn sys-info []
  [*file* *compile-path* *clojure-version*])

(first (sys-info))
(rest (sys-info))
(last (sys-info))
((sys-info) 2)


;; Code as data
(defn some_maps []
  {"string-key" {"one" 1 "two" 2 "three" 3}
  :keyword-key {:one 1 :two 2 :three 3}})

(some_maps)
(class (some_maps))
;; we can treat our function that returns a persistent hash map AS the hash map itself (CaD)
(get (some_maps) "string-key")
;; OR, instead of a function that returns a map we'll just pass in map and the behavior is the same!!
;; Maps can be used as functions of their keys.
(:a {:a "alpha" :b "beta" :g "gamma"})
(get (some_maps) :keyword-key)
((some_maps) :keyword-key)
(:keyword-key (some_maps))
((some_maps) "string-key")
;("string-key" (some_maps))
(println (str "Notice with a string key that this does not work " `("string-key" (some_maps))))
;; Notice in the above print line function that takes the string funciton as an argument: the backtick is a syntax comment
;; and tells REPL not to evaluate... it just reads it; but also notice that it returns the value of the namespace that teh function is operating in.. which is 'user'
(println (str "Notice with a string key that this does not work " '("string-key" "one" 1 "two" 2 "three" 3)))
;; I can also get the same effect with creating a list. That is, the list not evaluated because there is no function it is the eargument of, so I can doubly create the list and document it (CaD).
(println (str "Notice with a string key that this does not work " '(println '("string-key" "one" 1 "two" 2 "three" 3))))
;; But that's not all, I can also pass it to an function! But notice that I get some REPL feedback ("'" is evaluated as "quote")
;; And if you still don't believe me that CaD is for real, we'll pass through the REPL to be compeltely evaluated:
(println '("string-key" "one" 1 "two" 2 "three" 3))
;; No more REPL feedback because I'm not skipping evaluation, this time we get the evlauated list.
