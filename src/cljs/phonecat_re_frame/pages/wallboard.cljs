(ns app.pages.wallboard
  (:require [ajax.core as ajx]))


(defn load-queues! "fetches the queues from wallboard"
  [state]
  (ajx/GET "queues/queue.json"
      {:handler (fn [queues] (swap! state assoc :queues queues))
       :error-handler (fn [details] (.warn js/console (str "Failed to refresh queues from server: " details)))
       :response-format :json, :keywords? true}
    ))
