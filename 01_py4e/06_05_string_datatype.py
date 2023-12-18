# chapter 6 String Data Type
word = 'Hello World'
# for letter in word:
# 	print(letter)

# Slicing Stings
# 'up to but not including'
# print(word[0:4])

# String Concatenation 
a = 'Hello'
b = ' World'
# print(a + b)

# print(dir(word))
# return an alphabetized list of names comprising (some of) 
# the attributes of the given object, and of attributes reachable from it.

# Searching a String 
fruit = 'Banana'
pos = fruit.find('na')
# print(pos)
 
# Exercise 6.5 Parsing Strings
# Take the following Python code that stores a string:
str = 'X-DSPAM-Confidence: 0.8475'
# Use find and string slicing to extract the portion of the string after the colon character and then use the float
# function to convert the extracted string into a floating point number 

slicing_string = str[str.find(' '):]
convert_float = float(slicing_string)
print(type(convert_float))
print(convert_float)
