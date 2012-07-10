(def dreams "Don't ignore your dreams")
(def work "Don't work too much")
(def think "Say what you think")
(def friendship "Cultivate friendships")
(def happiness "Be happy")

(def ^:dynamic life
  (list dreams  work  think  friendship happiness)
)

(def look_back () (print *life*))

(look_back)
