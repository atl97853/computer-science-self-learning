#lang racket
(provide (all-defined-out))

; define a pair, cons just makes a pair 
(define pr (cons 1 (cons"a" "helloWolrd")))

; define a thunk, used to delayed computation
(define (delayed-comp thunk) 
    (lambda () 
        (thunk)))

; 1 - infinite sequence
(define ones (lambda () (cons 1 ones)))
;ones
(ones)
;(car (ones))
;(car ((cdr (ones))))

; 2 - natural numbers 
(define (f x) (cons x (lambda () f (+ x 1))))
(define nats (lambda () (f 1)))

;(f 2) 
;(nats)
;natsLet