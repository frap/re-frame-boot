(ns phinecat-re-frame.views
    (:require [re-frame.core :as re-frame]
              [phonecat-re-frame.components.nav :as nav]
              [phonecat-re-frame.pages.home :as home]
              [phonecat-re-frame.pages.about :as about]))

(defmulti pages identity)
(defmethod pages :home [] [home/main])
(defmethod pages :about [] [about/main])
(defmethod pages :default [] [:div.tc "Nada ici, pendejo."])

(defn main []
  (let [current-page (re-frame/subscribe [:current-page])]
    (fn []
      [:main
        [nav/main]
        (pages @current-page)
        ])))
