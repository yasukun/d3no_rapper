(ns d3no_rapper.core
    (:refer-clojure :exclude [range keys filter sort map merge]))

(def d3 js/d3)

(defn scale
  ([elem v]
     (.scale elem v))
  ([elem]
     (.-scale elem)))

(defn linear [elem]
  (.linear elem))

(defn range [elem props]
  (.range elem (clj->js props)))

(defn category10 [elem]
  (.category10 elem))

(defn select [elem sel]
  (.select elem sel))

(defn append [elem tag]
  (.append elem tag))

(defn attr [elem key val]
  (.attr elem key val))

(defn csv [elem target func]
  (.csv elem target func))

(defn json [elem target func]
  (.json elem func))

(defn keys [elem data]
  (.keys elem data))

(defn filter [elem func]
  (.filter elem func))

(defn sort [elem]
  (.sort elem))

(defn map [elem func]
  (.map elem func))

(defn extent [elem coll func]
  (.extent elem coll  func))

(defn domain [elem func]
  (.domain elem func))

(defn nice [elem]
  (.nice elem))

(defn axis [elem]
  (.axis elem))

(defn orient [elem target]
  (.orient elem target))

(defn call [elem func]
  (.call elem func))

(defn selectAll [elem target]
  (.selectAll elem target))

(defn data [elem data]
  (.data elem data))

(defn enter [elem]
  (.enter elem))

(defn merge [elem coll]
  (.merge elem coll))

(defn style [elem target func]
  (.style elem target func))

(defn hello
  []
  (js/alert "hello"))

(defn whoami
  []
  (.-userAgent js/navigator))
