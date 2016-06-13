(defn prime? [x]
  (if (= x 2)
    true
    (if (or (< x 2) (even? x))
      false
      (loop [i 3]
        (if (= i x)
          true
          (if (= 0 (mod x i))
            false
            (recur (inc i))))))))

(defn pal? [x]
  (= (str x) (reduce str (reverse (str x)))))
