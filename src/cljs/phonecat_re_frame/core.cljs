i(ns phonecat-re-frame.core
  (:require [reagent.dom :refer [render]]
            [re-frame.core :refer [dispatch-sync]]
            [phonecat-re-frame.routes :as routes]
            [phonecat-re-frame.views :as views]
            [phonecat-re-frame.handlers]
            [phonecat-re-frame.subs]))


(defn mount-root []
  (render [views/main] (.getElementById js/document "app")))

(defn ^:export init []
  (routes/start!)
  (dispatch-sync [:initialise-db])
  (mount-root))
