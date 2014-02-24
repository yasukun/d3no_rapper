(ns d3no_rapper.core
    (:refer-clojure :exclude [range keys filter sort map merge])
    ;; (:require [clojure.browser.repl])
    )

(def d3 js/d3)

;; d3 core

;; Selection

(defn select [elem sel]
  (.select elem sel))

(defn selectAll [elem target]
  (.selectAll elem target))

(defn append [elem tag]
  (.append elem tag))

(defn filter [elem func]
  (.filter elem func))

(defn sort [elem]
  (.sort elem))

(defn call [elem func]
  (.call elem func))

(defn data [elem data]
  (.data elem data))

(defn enter [elem]
  (.enter elem))

(defn style [elem target func]
  (.style elem target func))

;; Transition

(defn attr [elem key val]
  (.attr elem key val))

(defn interpolate
  ([elem t]
     (.interpolate elem t))
  ([elem a b]
     (.interpolate elem a b)))

;; Working with Arrays

(defn keys [elem data]
  (.keys elem data))

(defn map [elem func]
  (.map elem func))

(defn extent [elem coll func]
  (.extent elem coll  func))

(defn merge [elem coll]
  (.merge elem coll))

;; Math

;; Loading External Resources

(defn csv [elem target func]
  (.csv elem target func))

(defn json [elem target func]
  (.json elem target func))

;; String Formatting

;; CSV Formatting (d3.csv)

;; Localization

;; Colors

;; Namespaces

;; Internals

;; d3.scale (Scales)

(defn scale
  ([elem v]
     (.scale elem v))
  ([elem]
     (.-scale elem)))

;; Quantitative

(defn linear [elem]
  (.linear elem))

(defn range [elem props]
  (.range elem (clj->js props)))

(defn domain [elem func]
  (.domain elem func))

(defn nice [elem]
  (.nice elem))

;; Ordinal

(defn category10 [elem]
  (.category10 elem))

(defn category20 [elem]
  (.category20 elem))

(defn category20b [elem]
  (.category20b elem))

(defn category20c [elem]
  (.category20c elem))

;; d3.svg (SVG)

(defn svg [elem]
  (.-svg elem))

;; Shapes

(defn area [elem]
  (.area elem))

;; Axes

(defn axis [elem]
  (.axis elem))

(defn orient [elem target]
  (.orient elem target))


;; d3.time (Time)

(defn time [elem]
  (.-time elem))

(defn format [elem f]
  (.format elem f))

(defn parse [elem target]
  (.parse elem target))
