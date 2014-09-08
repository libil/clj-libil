(ns libil.core
  (:use [clojure.string :only [split lower-case upper-case capitalize join]])
  (:import [java.io Reader StringReader]))

(def first-pair
  ["h" "n" "c" "r" "k" "d" "t" "s" "w" "l"])

(def sec-pair
  ["p" "dh" "j" "y" "ny" "m" "g" "b" "th" "ng"])

(def all-con
  (into [] (concat first-pair sec-pair)))

(defn- within? [coll item]
  ((complement nil?) (some (set [item]) coll)))

(defn- rdr-peek
  [^Reader rdr]
  (.mark rdr 1)
  (let [c (.read rdr)]
    (.reset rdr)
    c))

(defn tokenize-rdr
  "Tokenize a reader" 
  [^Reader rdr]
  (loop [tokens (transient [])
         current (.read rdr)
         ahead (rdr-peek rdr)]
    (let [cc (-> current char str)]
      (cond (== -1 ahead) (persistent! (conj! tokens cc))
            (within? all-con (lower-case (str cc (char ahead))))
              (let [pair (str (char current) (char ahead))]
                (.skip rdr 1)
                (if (== -1 (rdr-peek rdr)) (persistent! (conj! tokens pair))
                    (recur (conj! tokens pair) (.read rdr) (rdr-peek rdr))))
            :else (recur (conj! tokens cc) (.read rdr) (rdr-peek rdr))))))

(defn tokenize-word
  "Tokenizing the word, to be able to be mapped"
  [^String w]
  (tokenize-rdr (StringReader. w)))

(defn- inv-cap 
  "Inverse Capitalize"
  [word]
  (let [f (str (first word))
        r (str (rest word))]
    (str f (upper-case r))))

(defn- fix-case [torg tmap]
  "Fixing Case"
  (cond (= (capitalize torg) torg) (capitalize tmap)
        (= (lower-case torg) torg) (lower-case tmap)
        (= (upper-case torg) torg) (upper-case tmap)
        :else (inv-cap tmap)))

(defn- fix-vocal
  "Fixing Vocal Prefix"
  [w]
  (let [v ["a" "i" "u" "e" "o"]
        f (str (first w))
        fh (fix-case f "h")]
    (if (within? v (lower-case f)) (join [fh (lower-case w)]) w))) 

(defn convert-word-yk
  "Converting Word to Bahasa Walikan"
  [word]
  (let [f->s (zipmap first-pair sec-pair)
        s->f (zipmap sec-pair first-pair)
        hw (fix-vocal word)]
    (apply str (map (fn [t] 
               (let [tl (lower-case t)]
               (cond  (within? first-pair tl) (fix-case t (f->s tl)) 
                      (within? sec-pair  tl) (fix-case t (s->f tl))
                      :else t)))
          (tokenize-word hw)))))

(defn convert-word-ngalam
  "Converting Word ala Malang"
  [word]
  (fix-case word (apply str (reverse (tokenize-word word)))))


(defn- convert-sentence
  "Coonverting Sentence"
  [convert-fn sentence]
  (join " " (map convert-fn (split sentence #" "))))

(def convert-sentence-yk (partial convert-sentence convert-word-yk))
(def convert-sentence-ngalam (partial convert-sentence convert-word-ngalam))
