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
; -----------------------------------------
; List
; Sum all the number in a list 
(define (sum xs)
    (if (null? xs)
        0
        (+ (car xs) (sum (cdr xs)))))
(sum (list 1 2 3))

; Append 
(define (my-append xs ys)
    (if (null? xs)
    ys
    (cons (car xs) (my-append (cdr xs) ys))))

(my-append (list 1 2) (list 3 4))
my-append
