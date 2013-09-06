(ns benchmark-tool,data.data-generation)

(defn rand-integer
  []
  (rand-int 4000000))

(defn rand-float
  []
  (rand 4000000))

;small blob size: 32,768; large blob size: 5,241,346
(defn rand-blob
  [size]
  (repeatedly size #(-> (char (+ 97 (rand-int (- 122 97)))) str (.getBytes "UTF-32"))))

(defn rand-string
  [size]
  (apply str 
    (take size 
      (repeatedly #(rand-nth "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ")))))
