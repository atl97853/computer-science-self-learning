def outer(something):
    def inner():
        return something

    return inner

test = outer('hello world')
print(type(test()))
print(test())

# https://www.youtube.com/watch?v=vKJpN5FAeF4