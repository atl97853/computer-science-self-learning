# class Hello 
#     def my_first_metod
#         puts 'Hello, World!'
#     end
# end

# instance = Hello.new
# instance.my_first_metod

class Hello
    def initialize(yourName)
        @name = yourName
        @x = 10
    end
    def hi 
        puts @name
        puts @x
    end
end

class HelloWorld < Hello
end

# me = Hello.new('Atl')
# me.hi
# you = HelloWorld.new('you')
# puts me.class
# puts you.class.superclass


