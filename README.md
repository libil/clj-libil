# clj-libil

[![Build Status](https://travis-ci.org/lynxluna/clj-libil.svg?branch=master)](https://travis-ci.org/lynxluna/clj-libil)

[![Clojars Project](http://clojars.org/clj-libil/latest-version.svg)](http://clojars.org/clj-libil)

This is the counterparts of [libil](https://github.com/lynxluna/libil) library written in Clojure

## Installation

Unlike its Ruby Counterparts, `clj-libil` is only implemented as library.
Just include this to fetch it from Clojars

```clojure
[clj-libil "0.1.1"]
```

## Usage

In your namespace declaration

```clojure
(:require [libil.core :refer :all])
```

In REPL

```clojure
(use 'libil.core)
```

### Functions

There are 4 functions to convert word and sentences using `clj-libil`

```clojure
(convert-sentence-yk "Dagadu, Dab!") ;; Matamu, Mas!
(convert-sentence-ngalam "Ngalup Ayabarus") ;; Pulang Surabaya
```

## Release Notes

### Version 0.1.1

- Using `StringReader` to process token.
- Using transient collection for optimisation.

### Version 0.1.0

- Initial Version

## License

The MIT License (MIT)

Copyright (c) 2014 Didiet Noor

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
