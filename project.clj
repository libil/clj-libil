(defproject clj-libil "0.1.1"
  :description "Clojure port of Libil, Processor of Bahasa Walikan"
  :url "http://github.com/lynxluna/clj-libil"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}
  
  :profiles {:dev 
             {:dependencies [[midje "1.6.3" :exclusions [org.clojure/clojure]]]
              :plugins [[lein-midje "3.1.1"]]}}
  
  :scm {:name "git"
        :url "https://github.com/lynxluna/clj-libil.git"}

  :dependencies [[org.clojure/clojure "1.6.0"]])
