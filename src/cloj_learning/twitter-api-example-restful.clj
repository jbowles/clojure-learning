(ns mynamespace
  (:use
   [twitter.oauth]
   [twitter.callbacks]
   [twitter.callbacks.handlers]
   [twitter.api.restful])
  (:import
   (twitter.callbacks.protocols SyncSingleCallback)))

(def *creds* (make-oauth-creds ""
                               ""
                               ""
                               ""))

; simply retrieves the user, authenticating with the above credentials
; note that anything in the :params map gets the -'s converted to _'s
;(show-user :oauth-creds *creds* :params {:screen-name "bowleslingjw"})
;
;; supplying a custom header
;(show-user :oauth-creds *creds* :params {:screen-name "bowleslingjw"} :headers {:x-blah-blah "value"})
;
;; shows the users friends, without using authentication
;(show-friends :params {:screen-name "bowleslingjw"})
;
;; use a custom callback function that only returns the body of the response
;(show-friends :callbacks (SyncSingleCallback. response-return-body response-error-throw exception-rethrow)
;          :params {:screen-name "bowleslingjw"})
;;
;; upload a picture tweet with a text status attached, using the default sync-single callback
;(update-with-media :oauth-creds *creds*
;                   :body [(file-body-part "/Users/jbowles/Pictures/brainalien.jpg")
;                          (status-body-part "testing")])



