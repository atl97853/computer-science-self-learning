# HTTP Web Scraping   

import urllib.request, urllib.parse, urllib.error
import requests
from bs4 import BeautifulSoup

url = 'https://en.wikipedia.org/wiki/List_of_TCP_and_UDP_port_numbers'
html = requests.get(url).text
soup = BeautifulSoup(html, 'html.parser')

# Retrive all of the anchor tags 
tags = soup('a')
for tag in tags:
	print(tag.get('href', None))

	
