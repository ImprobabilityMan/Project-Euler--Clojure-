(defn parse-int [x]
  (.parseInt Integer  x))

(defn partition-sum [size spacing coll]
  (let [coll (partition size spacing coll)]
    (for [x coll] (reduce + (map int x)))))