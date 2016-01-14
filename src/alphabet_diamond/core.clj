(ns alphabet-diamond.core
  (:gen-class))

(defn valid? [arg]
  (and (= (count arg) 1)
       (Character/isLetter (first arg))))

(defn char->int [c]
  (- (int (Character/toUpperCase c))
     (int \A)))

(defn int->char [i]
  (char (+ i
           (int \A))))

(defn mirror [col]
  (concat col
          (rest (reverse col))))

(defn gen-pyrimid-line [line-no]
  (mirror (conj (repeat line-no \ )
                (int->char line-no))))

(defn gen-pyrimid [letter]
  (map gen-pyrimid-line (range (inc (char->int letter)))))

(defn center-align [lines]
  (let [m (apply max (map count lines))]
    (map #(concat (repeat (/ (- m (count %)) 2) \ ) %)
         lines)))

(defn gen-diamond [letter]
  (center-align (mirror (gen-pyrimid letter))))

(defn print-all [lines]
  (doseq [l (map #(apply str %) lines) ]
    (println l)))

(defn read-input [validator]
  (first (filter some?
                 (repeatedly #(do
                                (print ">")
                                (flush)
                                (let [line (read-line)]
                                  (if-not (validator line)
                                    (println "INVALID INPUT")
                                    line)))))))

(defn -main [& args]
  (let [input (first (read-input valid?))]
    (print-all (gen-diamond input))))
