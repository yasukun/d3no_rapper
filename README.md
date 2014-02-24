d3no_rapper
===========

A ClojureScript wrapper for d3js


## Installation

Add the following to your `project.clj`

```clojure
[d3no_rapper "0.1.0-SNAPSHOT"]
```

## Usage

### d3no_rapper.core [Source](https://github.com/yasukun/d3no_rapper/blob/master/src/cljs/d3no_rapper/core.cljs)


```clojure
(ns myapp
  (:use [d3no_rapper.core :only [d3 select append csv json extent
                                 domain nice axis orient call attr category10
                                 selectAll enter style linear scale]])
  (:require  [d3no_rapper.core :as dr]))

(def margin {:top 20 :right 20 :bottom 30 :left 40})
(def width (- 960 (:left margin) (:right margin)))
(def height (- 500 (:top margin) (:bottom margin)))

(def x (-> d3 scale linear (dr/range [0 width])))
(def y (-> d3 scale linear (dr/range [height 0])))
(def z (-> d3 scale category10))

(defn draw []
  (let [svg (-> d3
                (select "#spa") (append "svg")
                (attr "width" (+ width (:left margin) (:right margin)))
                (attr "height" (+ height (:top margin) (:bottom margin)))
                (append "g")
                (attr "transform" (str "translate(" (:left margin) ","
                                         (:top margin) ")")))]
    (-> d3
        (csv "/data.csv"
             (fn [data]
               (let [cljdata (js->clj data)
                     seriesNames (sort
                                  (filter #(not= "x" %)
                                          (keys (first cljdata))))
                     series (clj->js
                             (for [d (seq cljdata) s seriesNames]
                               [{:x (int (get d "x")) :y (int (get d s))}]))
                     d3_extent #(-> d3 (extent %1 %2))
                     d3_merge #(-> d3 (dr/merge %))]

                 (-> x
                     (domain (d3_extent (d3_merge series) (fn [d] (.-x d))))
                     nice)
                 (-> y
                     (domain (d3_extent (d3_merge series) (fn [d] (.-y d))))
                     nice)
                 (-> svg (append "g")
                     (attr "class" "x axis")
                     (attr "transform" (str "translate(0," height ")"))
                     (call (-> d3 dr/svg axis (scale x) (orient "bottom"))))
                 (-> svg (append "g")
                     (attr "class" "y axis")
                     (call (-> d3 dr/svg axis (scale y) (orient "left"))))

                 (-> svg (selectAll ".series")
                     (dr/data series)
                     enter (append "g")
                     (attr "class" "series")
                     (style "fill" (fn [d i] (z i)))
                     (selectAll ".point")
                     (dr/data (fn [d] d))
                     enter (append "circle")
                     (attr "class" "point")
                     (attr "r" 4.5)
                     (attr "cx" (fn [d] (x (.-x d))))
                     (attr "cy" (fn [d] (y (.-y d)))))))))))

```
