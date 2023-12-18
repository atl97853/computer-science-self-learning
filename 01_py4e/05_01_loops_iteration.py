# chapter 5 Loops and Iteration

# -- while loops --

# -- infinite loop --
# n = 1
# while (n > 0):
#     print(n)
#     n += 1 

# -- normal while loop --
# n = 10
# while (n > 0):
#     print(n)
#     n -= 1
    
# -- Finishing an Iteration with continue -- 
# while True:
#     word = input('>')
#     if word == 'done':
#         break
#     elif word == '#':  # <- this ends the current iteration
#         continue       # <- and jumps to the top of the loop and starts the next iteration
#     print('hello world -> continue ')

# -- for loops --

# -- Largest Number So Far --
# numbers = [9, 41, 12, 3, 74, 15]
# largest_num = -1
# for num in numbers:
# 	if num > largest_num:
# 		largest_num = num
# 	print(largest_num, num)
# print('finish')

# -- Counting in a Loop --
# import random
# zork = 0
# sum = 0
# for num in range(0,6):
#     zork += 1
#     random_number = random.randint(0,100)
#     sum += random_number
#     print(f'z{zork}, s{sum}, a{sum/zork}')

# -- Smallest Number So Far --
# smallest = None
# numbers = [9, 41, 12, 3, 74, 15]
# for num in numbers:
#     if smallest is None:
#         smallest = num
#         print('starting point', smallest)
#     if num < smallest:
#         smallest = num
#     print(smallest, num)
    
# Exercise 01 
# Write a program which repeatedly reads numbers until the user enters "done".
# One "done" is entered, print out the toal, count, and average of the numbers.
# If the user enters anything other than a number, detect their mistake using try and except and print an error 
# message abd skip to the next number.

num = 0
tot = 0.0
while True:
	sval = input('Enter a number: ')
	if sval == 'done':
		break
	try:
		fval = float(sval)
	except:
		print('Invalid input')
		continue
	num += 1 
	tot += fval
	print(tot,num,tot/num)


