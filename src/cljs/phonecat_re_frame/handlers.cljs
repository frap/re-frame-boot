(ns phonecat-re-frame.handlers
  (:require [re-frame.core :refer [register-handler]]
            [phonecat-re-frame.db :as db]))

(register-handler
  :initialise-db
  (fn  [_ _]
    db/default-db))

(register-handler
  :route
  (fn [db [_ {:keys [current-page route-params]}]]
    (merge db {:current-page current-page :route-params route-params})))
