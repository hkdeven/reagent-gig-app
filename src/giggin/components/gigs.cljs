(ns giggin.components.gigs
  (:require [giggin.state :as state]))

(defn gigs
  []
  [:main
   [:div.gigs
    (for [{:keys [id img title price desc]} (vals @state/gigs)]
      [:div.gig {:key id}
       [:img.gig__artwork {:src img :alt title}]
       [:div.gig__body
        [:div.gig__title
         [:div.btn.btn--primary.float--right.tooltip {:data-tooltip "Add to order"}
          [:i.icon.icon--plus]] title]
        [:p.gig__price price]
        [:p.gig__desc desc]]])]])

   ; same method using map
   ; [:div.gigs (map (fn [gig]
   ;                   [:div.gig {:key (:id gig)}
   ;                    [:img.gig__artwork {:src (:img gig) :alt (:title gig)}]
   ;                    [:div.gig__body
   ;                     [:div.gig__title
   ;                      [:div.btn.btn--primary.float--right.tooltip {:data-tooltip "Add to order"}
   ;                       [:i.icon.icon--plus]] (:title gig)]
   ;                     [:p.gig__price (:price gig)]
   ;                     [:p.gig__desc (:desc gig)]]])(vals @state/gigs))]])
