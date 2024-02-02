#lang racket
(provide (all-defined-out))

(define x 10)

(define (something) 
    (lambda (y)
        (* x y)))

(define multiByTen (something))

multiByTen
(multiByTen 5)

