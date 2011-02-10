(ns Euler12
  (:use clojure.contrib.lazy-seqs))

(def triangle-numbers  
     ((fn trn [a b]
	(let [new-val (+ (inc (- b a)) b)] 
	  (lazy-seq (cons a (trn b new-val))))) 1 3))

(defn one? [n] (= n 1))

(defn count-factors [f]
  (let [counts (group-by identity f)]
    (reduce * (map #(inc (count %)) (map val counts)))))

(defn count-divisors [num]
  (loop [factors '()
         n num
         prime primes]
    (let [p (first prime)]
      (cond
       (one? n) (count-factors factors)
       (zero? (mod n p)) (recur (conj factors p) (/ n p) primes)
       :default (recur factors n (next prime))))))

(defn euler-12 [count]
  (loop [tri triangle-numbers]
    (let [t (first tri)]
      (if (> (count-divisors t) count)
        t
        (recur (next tri))))))