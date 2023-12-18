# chapter 12 Network Programming

# A TCP/IP socket 
# is used for communications 
# between two computers. The socket includes 
# the Internet protocol (IP) address, as well as 
# the host or port that the computers are using to 
# transmit the data. All applications that take part in the 
# transmission use the socket to send and receive information.

# TCP Port Number 
# Ports are numbered and used as global standards to identify specific processes or types of network services.

# Exercise Sockets, simulating what's happening in a web browser 
import socket
mysock = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # file handle that doesn't have any data associated with it yet
x = mysock.connect(('data.pr4e.org', 80))
cmd = 'GET http://data.pr4e.org/romeo.txt HTTP/1.0\r\n\r\n'.encode() # command line http protocol| reach put and connect that socket to a destination across the internet
mysock.send(cmd)

# telnet data.pr4e.org 80 | command line 

while True:
    print('the code is running...')
    data = mysock.recv(512)
    if (len(data) < 1):
        break
    print(data.decode())
mysock.close()
print('the code stopped')

# import requests

# r = requests.get('http://data.pr4e.org/romeo.txt')
# print(r.text)