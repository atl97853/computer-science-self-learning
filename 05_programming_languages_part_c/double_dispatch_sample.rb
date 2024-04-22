class MyNumber # --------------- class
  attr_accessor :num 
  def initialize(num) 
    @num = num
  end
  # double dispatch 
  def add(other)
    other.add_number(self)
  end
  # other is a number, so do a numeric addition 
  def add_number(other)
    MyNumber.new(num + other.num)
  end
  # MyNumber is being added to MyString
  def add_string(other)
    MyString.new(other.str + num.to_s)
  end 
  def print 
    puts num 
  end 
end

class MyString # --------------- class
  attr_accessor :str
  def initialize(str)
    @str = str
  end
  # double dispatch 
  def add(other)
    other.add_string(self)
  end
  # case: MyString + MyNumber 
  def add_number(other)
    MyString.new(other.num.to_s + str)
  end 
  # case: MyString + MyString
  def add_string(other)
    MyString.new(str + other.str)
  end
  def print
    puts str
  end
end

# helper function 
def add_values(a, b)
  result = a.add(b)
  result.print
end

number = MyNumber.new(123)
string = MyString.new("123")

add_values(number, string) # bug? 
# add_values(string, string)

