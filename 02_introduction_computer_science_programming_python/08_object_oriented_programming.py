
class Coordinate(object):

	def __init__(self, x, y):
		self.x = x 
		self.y = y

	def distance(self):
		calculation = self.x - self.y
		print(calculation)
	
	# Defining your own print method 
	def __str__(self):
		return "<"+str(self.x)+", "+str(self.y)+">"
	
	# __str__, if you define this method in your class 
	# that tells python, every "print" statement that's on an
	# object of type coordinate, call this method
	# look what it does, and "print" everything that's inside it 
	
c = Coordinate(3, 4) 
print(c)


# -----------------------------------------------------------------------------
# Just playing around 
# Create a class and with a while loop create intances of the class, and stops it when the condition will be completed 

import random

class RandomClass(object):

    def __init__(self, random_num):
        self.random_num = random_num

    def check(self):
        if self.random_num == 55:
            return False
        else:
            return True
    
lst_object = []
program_running = True
while program_running:
    x = RandomClass(random.randint(0, 100))
    lst_object.append(x)
    program_running = x.check()

    print(len(lst_object))

print(x.random_num)
print(lst_object)

print('----------------------first part was finished-----------------------')

for item in lst_object:
    print(item.random_num, lst_object.index(item))

# https://ocw.mit.edu/courses/6-0001-introduction-to-computer-science-and-programming-in-python-fall-2016/resources/lecture-8-object-oriented-programming/