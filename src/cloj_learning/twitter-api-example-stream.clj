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
