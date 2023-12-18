class op:

	name = ""
	def __init__(self):
		self.name = 'empy name'
	
	def changename(self, username):
		self.name = username

x = op()
print(x.name)
x.changename('Atl')
print(x.name)
