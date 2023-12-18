# chapter 09 Dictionaries
# Exercise 

try:
	fname = input('Enter File: ')
	fhand = open(fname)
except FileNotFoundError:
	fname = './py4e.com_code3_intro.txt'
	fhand = open(fname)

count = 0
di = dict()
for line in fhand:
	line = line.rstrip()
	wds = line.split()
	count += 1 

	for w in wds:
		di[w] = di.get(w,0) + 1 
		

print(count)
largest = -1
theword = None
search_w = input('Which word are you looking for: ')
for key,value in di.items():
	if key == search_w:
		if value > largest:
			largest = value
			theword = key

print(theword, largest)
