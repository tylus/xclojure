(ns rna-transcription.test (:require [clojure.test :refer :all]))
(load-file "dna.clj")

(deftest transcribes-cytidine-unchanged
  (is (= "G" (dna/to-rna "C"))))

(deftest transcribes-guanosine-unchanged
  (is (= "C" (dna/to-rna "G"))))

(deftest transcribes-adenosine-unchanged
  (is (= "U" (dna/to-rna "A"))))

(deftest it-transcribes-thymidine-to-uracil
  (is (= "A" (dna/to-rna "T"))))

(deftest it-transcribes-all-occurrences-of-thymidine-to-uracil
  (is (= "UGCACCAGAAUU" (dna/to-rna "ACGTGGTCTTAA"))))

(deftest it-validates-dna-strands
  (is (thrown? AssertionError (dna/to-rna "XCGFGGTDTTAA"))))

(run-tests)
