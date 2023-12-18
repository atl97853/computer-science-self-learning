def calculate_sum(input):
    sum = 0
    for num in range(0, int(input) + 1, 1):
        print(num)
        sum += num
    return sum

# Big O n log n bime Complexity Examples: 
# ---- Constant Time: O(1)
def first_array_element(array):
    return array[0]

given_array = [12, 234, 43, 53455, 23, 64]
# print(first_array_element(given_array) )

# ---- Quadratic time and Cube (nested loop)n**3
def cube_iteration_counter():
    n = int(input(': '))
    a = 0
    b = 0
    c = 0
    for i in range(0, n):  # -------------- O(n)
        a += 1 
        for i in range(0, n): # -------------- O(n**2)
            b += 1
            for i in range(0, n):  # -------------- O(n**3)
                c += 1 
                print(c, 'c')
            print(b, 'b')
        print(a, 'a')

# ---- Logarithms O(log n)
import math
def log_function(n):
    if n == 0: return 'Done'
    n = math.floor(n/2)
    print('hey there')
    return log_function(n)

# print(log_function(8))

def logn(n):
    while n > 1:
        n = math.floor(n/2)
    return n

# ---- Logarithms O(n log n)
def n_log_n_func(n):
    y = n
    while n > 1:
        n = math.floor(n/2)
        for i in range(0, y): # iterates 1, y + 1 times
            print(i)
        print('rep', n)

# n_log_n_func(4)

def count_down(n):
    if n == 0:
        return
    print(n)
    return count_down(n - 1)

count_down(10)