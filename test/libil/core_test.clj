(ns libil.core-test
  (:require [clojure.test :refer :all]
            [libil.core :refer :all])
  (:use midje.sweet))

(facts "In Yogyakarta, you should spaeak Yogyakarta Style"
   (fact "The encoding of \"asu\" is pabu not abu"
         (convert-word-yk "asu") => "pabu")
   (fact "The encoding of \"Dhahar\" is \"Napay\""
         (convert-word-yk "Dhahar") => "Napay")
   (fact "\"Pabu Saciladh\" is \"Hasu Bajingan\""
         (convert-sentence-yk "Pabu Saciladh") => "Hasu Bajingan"))

(facts "In Malang, Speak Malang"
   (fact "Malang becomes Ngalam"
         (convert-word-ngalam "Malang") => "Ngalam")
   (fact "Pulang Surabaya becomes Ngalup Ayabarus"
         (convert-sentence-ngalam "Pulang Surabaya") => "Ngalup Ayabarus"))


