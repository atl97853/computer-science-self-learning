class MyString
  attr_accessor :s
  def initialize s 
    @s = s 
  end 
  def add_values other 
    other.addStr self 
  end 
  # double dispatch methods 
  def addInt other # the other is a int and is going to add self, so a string
    MyString.new(other.i.to_s + s)
  end 
  def addStr other # the other is a str and is going to add self, so a string
    MyString.new(other.s + s) 
  end 
  # - new class 
  def addAtl other 
    MyString.new(other.atl + s)
  end 
  # print using simple dispatch
  def printR 
    puts s 
  end  
end 

class MyInt
  attr_accessor :i
  def initialize i 
    @i = i
  end 
  def add_values other 
    other.addInt self 
  end
  # double dispatch methods 
  def addInt other # the other is a int and is going to add self, so a int
    MyInt.new(other.i + i)
  end 
  def addStr other # the other is a str and is going to add self, so a int
    MyInt.new(other.s + i.to_s)  #doesn't add string numbers, just append the str and converts the int to string
  end 
  # - new class 
  def addAtl other 
    MyInt.new(other.atl + i.to_s)
  end 
  # print using simple dispatch
  def printR 
    puts i 
  end  
end 

class Atl 
  attr_accessor :atl 
  def initialize atl
    @atl = atl 
  end 
  def add_values other 
    other.addAtl self
  end 
  def addInt other
    Atl.new(other.i.to_s + atl)
  end 
  def addStr other 
    Atl.new(other.s + atl)
  end 
  def addAtl other 
    Atl.new('Hello World Atl')
  end 
  def printR 
    puts atl
  end 
end

def helper(objA, objB)
  result = objA.add_values(objB)
  result.printR
end 

# some1 = MyString.new('hello')
# some2 = MyInt.new(5)

# some3 = MyInt.new(10)
# some4 = MyString.new('Atl')

# helper(some1, some2) # mixed 
# helper(some2, some3) # int + int 
# helper(some1, some4) # str + str

x = MyString.new('word')
y = MyInt.new(3)
atl = Atl.new('Atl')

# helper(x, y)
# helper(y, x)

helper(atl,x)
helper(y,atl)
helper(atl,atl)

