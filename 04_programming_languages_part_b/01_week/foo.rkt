#lang racket 
(provide (all-defined-out)) 

; Basic definitions 
(define s "hello")

; Recursive functions 
(define (pow1 x y)
    (if (= y 0)
    1
    (* x (pow1 x (- y 1)))))

(pow1 3 2)