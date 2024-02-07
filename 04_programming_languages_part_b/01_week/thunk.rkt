#lang racket
(provide (all-defined-out))

(define (delayed-add thunk)
    (lambda () (thunk)))

(define (compute) (+ 2 5))

(define delayed-computation(delayed-add compute))

;(display "Before\n")
;(display (delayed-computation))

;(define x 3)
;x

(delayed-computation)