(ns Euler12
  (:use clojure.contrib.lazy-seqs))

(def triangle-numbers  
     ((fn trn [a b]
	(let [new-val (+ (inc (- b a)) b)] 
	  (lazy-seq (cons a (trn b new-val))))) 1 3))

(defn largest-prime-divisor [num]
  (