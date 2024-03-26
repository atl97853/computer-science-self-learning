# class Hello 
#     def my_first_metod
#         puts 'Hello, World!'
#     end
# end

# instance = Hello.new
# instance.my_first_metod


class A 
    def initialize(f=100)
        @foo = f 
    end 
    def someghing 
        @foo = 500
    end 
    def saySomething 
        @foo
    end 
end

class B 
    def declareV 
        @x = 500
    end
    def getV 
        @x
    end
end

def mxnToUsd(x)
    total = x / 16.70
    total
end

puts mxnToUsd(1000)


