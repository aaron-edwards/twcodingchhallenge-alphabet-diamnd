(ns alphabet-diamond.core-test
  (:require [clojure.test :refer :all]
            [alphabet-diamond.core :refer :all]))

(defn ->vec [string]
  (into [] (char-array string)))

(deftest mirror-should-mirror-input
  (is (= [1 2 3 2 1] (mirror [1 2 3]))))

(deftest gen-pyrimid-line-should-create-line-correctly
  (is (= (->vec "C   C")
         (gen-pyrimid-line 2))))

(deftest gen-pyrimid-should-generate-pyrimid
  (is (= (map ->vec `("A" "B B"))
         (gen-pyrimid \B))))

(deftest center-align-should-pad-with-space
  (is (= (map ->vec `(  " ."
                        "..."))
         (center-align [[\.] [\.\.\.]]))))

(deftest should-return-A
  (is (= [[\A]] (gen-diamond \A))))

(deftest should-return-diamond
  (is (= (map ->vec `(  "  A"
                        " B B"
                        "C   C"
                        " B B"
                        "  A"))
         (gen-diamond \C))))

(deftest validator
  (testing "should accept letters"
    (is (valid? "a"))
    (is (valid? "Z")))
  (testing "should reject numbers"
    (is (not (valid? "1"))))
  (testing "should reject symbols"
    (is (not (valid? "?"))))
  (testing "should reject multiple characters"
    (is (not (valid? "abc")))))
