(require 'twitter
         ['oauth.client :as 'oauth])

(def oauth-consumer (oauth/make-consumer "E4XIMeoxvEXlmqlOnLt5QQ"
                                         "UOdbYIlt2nyyIEz2D0bytouaGYk7nIcATrcHvfR8W4o"
                                         "https://api.twitter.com/oauth/request_token"
                                         "https://api.twitter.com/oauth/access_token"
                                         "https://api.twitter.com/oauth/authorize"
                                         :hmac-sha1))

(twitter/followers-of-name "bowleslingjw")
