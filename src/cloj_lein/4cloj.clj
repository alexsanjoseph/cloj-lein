;; 18. Filter

(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;; 19. Last but not last

(= (#(nth % (dec (count %))) [1 2 3 4 5]) 5)

;; 20. Penultimate element
(= (#(nth % (- (count %) 2)) [1 2 3 4 5]) 4)

;; 21. Nth element
(= (#(nth % (- (count %) 2)) [1 2 3 4 5]) 4)
(= ((fn [x y] (first(drop y x))) '([1 2] [3 4] [5 6]) 2) [5 6])
; (fn [x y] (first(drop y x)))

;; 22. Count a sequence
(= (__ "Hello World") 11)

((fn [x]
  (loop [i 0]
    (if (= nil (get (vec x) i))
      i
      (recur (inc i))))) "Hello World")

;; 23. Reverse a sequence
((fn [x]
  (loop [i (dec (count x)) rev []]
    (if (= nil (get (vec x) i))
      rev
      (recur (dec i) (conj rev (get (vec x) i)))))) '(1 3 6 2))

;; 24. Sum a sequence
(apply + '(1 2 3 4))

;; 25. Find odd
(filter odd? [4 2 1 6])

;; 26. Fibonnacci
(= ((fn [n]
     (lazy-seq
      (loop [i 2 fib [1 1]]
        (if (= i n)
          fib
          (recur (inc i) (conj fib (+ (nth fib (dec i)) (nth fib (dec (dec i)))))))))) 6) '(1 1 2 3 5 8))

;; 27. Palindrome
(#(= (seq %) (reverse %)) "racecar")

;; 28. Flatten
;(= (__ ["a" ["b"] "c"]) '("a" "b" "c"))

((fn [coll]
  (seq
   (reduce
    (fn my-flatten [v e]
      (if (coll? e)
        (reduce my-flatten v e)
        (conj v e)))
    [] coll))))

;; 29. Get the caps
(#(apply str (filter (contains? (set (map char (range 65 91))) %))) "HEL")

((fn [x]
  (apply str
    (filter
      #(contains?
        (set (map char (range 65 91))) %) x))) "HELLO Alex")

;; 30. Remove duplicates
; (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))


((fn [x]
   (loop [i 1 cmp [(first x)]]
     (if (= i (count x))
       cmp
       (if (= (nth x i) (nth x (dec i)))
         (recur (inc i) cmp)
         (recur (inc i) (conj cmp (nth x i))))))) [1 1 2 3 3 4 4])

;; 31. Pack a sequence
(#(map seq (partition-by identity %)) [1 1 2 1 1 1 3 3])

;; 32. duplicates
(#(reduce concat (map (fn [x] (list x x)) %)) '(1 2 3))

;; 33. Replicate
(#(reduce concat ((fn [x] (repeat %2 x)) %1)) '(1 2 3) 3)

(#(mapcat (fn [x] (repeat %2 x)) %1) '(1 2 3) 3)

;; 34. Implement Range
(#(take (- %2 %1) (iterate inc %1)) 4 10)

;; 35. Local Bindings
7

;; 36. Let it be
[z 1 y 3 x 7]

;; 37. Regular Expressions
"ABC"

;; 38. Maximum value
((fn [& args] (reduce #(if (> %1 %2) %1 %2) args)) 1 20 3 4)
((comp last sort list) 1 20 3 4)
(#(->> % sort last) '(1 20 3 4))

;; 39. Interleave
(#(loop [i (dec(min (count %1) (count %2))) lst '()]
    (if (= i -1)
      lst
      (recur (dec i) (conj lst (nth %2 i) (nth %1 i))))) [1 2 3 4] [5 10])

(mapcat list [1 2 3 4] [5 10] [3 10])

;; 40. Interpose
(#(rest (interleave (repeat %1) %2)) 0 [1 2 3 4])

;; 41. Drop nth
((fn [x y]
  (loop [i 0 lst []]
      (if (= i (count x))
        lst
        (if (not= 0 (mod (inc i) y))
          (recur (inc i) (conj lst (nth x i)))
          (recur (inc i) lst))))) [:a :b :c :d :e :f] 3)

;; 42. factorial
(#(reduce * (range 1 (inc %))) 8)

;; 43. Reverse interleave
;(= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

((fn [x y]
    (loop [i (dec y) lst '()]
      (if (< i 0)
        lst
        (recur (dec i)
          (conj lst (reduce concat (partition 1 y (drop i x)))))))) (range 10) 5)


;; 44. Rotate
((fn [y x]
   (let [ymod (mod y (count x))]
    (concat (drop ymod x) (take ymod x)))) 6 [1 2 3 4 5])

;; 45. Iterate Intro
(take 5 (iterate #(+ 3 %) 1))
'(1 4 7 10 13)

;; 46. Flipping out
((defn flip-out [f]
  (fn [& args] (apply f (reverse args)))) 7 8)

;; 47. contains
(contains? #{4 5 6} 4)

(contains? [1 1 1 1 1] 2)

;; 48. Some

(some #{2 7 6} [5 6 7 8])
(some #(when (even? %) %) [5 6 7 8])

;; 49. Split a sequence
((fn [y x]
   (let [ymod (mod y (count x))]
    (list (take ymod x) (drop ymod x)))) 6 [1 2 3 4 5])

;; 50. Split by type
(#(vals (group-by type %)) [1 :a 2 :b 3 :c])

;; 51. Advanced destructuring
[1 2 3 4 5]

;; 52. Intro to destructuring
[c e]

;; 53. Longest increasing subsequence
(def x [5 6 1 3 2 7])
(def x [1 2 2 3 4 5])

(fn [x]
  (map > ()))
(identity x)

(partition-by identity (map > (drop 1 x) (drop-last 1 x)))


;; 54.

;; 58. Recursion
((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5)
