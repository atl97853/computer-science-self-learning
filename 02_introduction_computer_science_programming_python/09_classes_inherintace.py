# Why use object oriented programming and classes of objects? 

# Creating a class 
class Animal(object):
    def __init__(self, age):
        self.age = age
        self.name = None

    # Getters and setters should be used outside of class to access data attributes, to prevent bugs and make it easier to mantaing code 
    # -----------------getter/getters
    def get_age(self):
        return self.age
    def get_name(self):
        return self.name
     
    # ------------------setter/setters 
    def set_age(self, newage):
        self.age = newage
    def set_name(self, newname=""):
        self.name = newname

    # Defining your own print method 
    # def __str__(self):

# ---------------------------------------------------------------------
# Creating a instance of a class 

# myanimal = Animal()

# Python allows you to create data attributes for an instance from outside class definition / not recommended to do
# myanimal.color = 'red'
# print(myanimal.color)

# myanimal.set_age(100)
# print(myanimal.get_age())

# -------------------------------------------------------------------------
# Hierarchies and Inheritance Subclass / Instance Variables
class Cat(Animal):
    def speak(self):
        print('meow')

class Person(Animal):
    def __init__(self, name, age):
        Animal.__init__(self, age) 
        self.set_name(name)
        self.friends = []
    
    def get_friends(self): # getter
        return self.friends
    def set_friends(self,fname): # setter
        if fname not in self.friends:
            self.friends.append(fname)
        
    # ------------------------- new methods 
    def speak(self):
        print('hello')
    def age_diff(self, other):
        diff = self.age - other.age
        print(abs(diff), 'year difference')
    
# p1 = Person('Ragnar', 5)
# p2 = Person('Tohru', 2)
# print(p1.get_age())
# p2.speak()
# p1.age_diff(p2)

# -------------------------------------------------------------------------
import random

class Student(Person):
    def __init__(self, name, age, major=None):
        Person.__init__(name, age) # calling __init__ method that we already created for the parent class 
        self.major = major
    
    def change_major(self, major):
        self.major = major
    
    def speak(self):
        rnum = random.random()
        if rnum < 0.25:
            print('i have homework')
        elif 0.25 <= rnum < 0.5:
            print('i need sleep')
        else:
            print('i should eat')

# -------------------------------------------------------------------------
# Class Variables 
# Variables whose values are shared between all instances of a class

class Rabbit(Animal):
    tag = 0 # class variables are typically define inside the class definition 

    def __init__(self, age, parent1=None, parent2=None):
        Animal.__init__(self, age)  # /super().__init__(age) or Animal.__init__(self, age), for now using these two piece of code work the same/
        self.parent1 = parent1
        self.parent2 = parent2
        self.rid = Rabbit.tag
        Rabbit.tag += 1 
    
    # Working with your own types 
    def __add__(self, other):
        # returning object of same type as this class 
        return Rabbit(0, self, other) 

r1 = Rabbit(10)
print(r1.tag)

# https://ocw.mit.edu/courses/6-0001-introduction-to-computer-science-and-programming-in-python-fall-2016/resources/lecture-9-python-classes-and-inheritance/