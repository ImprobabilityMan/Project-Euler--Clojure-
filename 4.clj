(defn palindrome? [num]
  (if (= num (reverse-digits num))
    true
    false))

(defn reverse-digits [num]
  (loop [pool num val 0]
    (if (zero? pool)
      val
      (recur (int (/ pool 10)) (+ (* val 10) (mod pool 10))))))

(defn min-number [digits]
  (loop [num 1 ct (dec digits)]
    (if (zero? ct)
      num
      (recur (* 10 num) (dec ct)))))

(defn max-number [digits]
  (loop [num 9 ct (dec digits)]
    (if (zero? ct)
      num
      (recur (+ (* 10 num) 9) (dec ct)))))

(defn largest-product-palindrome [digits]
  (let [min (min-number digits) max (max-number digits)]
    (let [vals (set (for [x (reverse (range min (inc max))) y (reverse (range min (inc max)))] (* x y)))]
      (take 1 (sort > (filter #(palindrome? %) vals))))))
  