
Expertise in client-side coding is not required, but a basic knowledge will help you work better with the developers creating your client-side web "front end".

https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Web_mechanics/What_is_a_web_server :
## What is a web server? 

- what web servers are 
- how web servers work 
- why they are important 

**On the hardware side**, a web server **is a computer that stores web server software and a website's component files** (for example, HTML documents, images, CSS stylesheets, and JavaScript files). A web server connects to the Internet and supports physical data interchange with other devices connected to the web.

On the software side, a web server includes several parts that control how web users access hosted files. At a minimum, this is an HTTP server. An HTTP server is software that understands URLs (web addresses) and HTTP (the protocol your browser uses to view webpages). **An HTTP server can be accessed through the domain names of the websites it stores, and it delivers the content of these hosted websites to the end user's device.**

At the most basic level, whenever a browser needs a file that is hosted on a web server, **the browser requests the file via HTTP**. When the request reaches the correct (hardware) web server, the (software) HTTP server accepts the request, finds the requested document, and sends it back to the browser, also through HTTP. (If the server doesn't find the requested document, it returns a 404 response instead.)

<!-- ![alt text](https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Web_mechanics/What_is_a_web_server/web-server.svg) -->

Static website vs Dynamic website. 


**A static web server**, or stack, consists of a computer (hardware) with an HTTP server (software). We call it "static" because the server sends its hosted files as-is to your browser.

**A dynamic web server** consists of a static web server plus extra software, most commonly an application server and a database. We call it "dynamic" because the application server updates the hosted files before sending content to your browser via the HTTP server.

For example, to produce the final webpages you see in the browser, the application server might fill an HTML template with content from a database. Sites like MDN or Wikipedia have thousands of webpages. **Typically, these kinds of sites are composed of only a few HTML templates and a giant database, rather than thousands of static HTML documents. This setup makes it easier to maintain and deliver the content.**

https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Tools_and_setup/What_software_do_I_need

## What software do I need to build a website?

You'll need tools to:

- Create and edit webpages
- Upload files to your web server
- View your website

https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Tools_and_setup/Upload_files_to_a_web_server

## How do you upload your files to a web server?

- Learn how to push files to a server using the various file transfer tools available.

How to put a web page online, on a web server. In this article we'll discuss how to do that, using various avaible options such as SFTP clients, RSync and GitHub. 

- FTP is inherently insecure, and you shouldn't use it.

https://docs.github.com/en/pages/setting-up-a-github-pages-site-with-jekyll/about-github-pages-and-jekyll
GitHub: Jekyll is a static site generator with built-in support for GitHub Pages and a simplified build process. Jekyll takes Markdown and HTML files and creates a complete static website based on your choice of layouts. Jekyll supports Markdown and Liquid, a templating language that loads dynamic content on your site. 


https://developer.mozilla.org/en-US/docs/Learn/Server-side
## Server-side website programming

The Dynamic Websites – Server-side programming topic is a series of modules that show how to create dynamic websites; websites that deliver customized information in response to HTTP requests. The modules provide a general introduction to server-side programming, along with specific beginner-level guides on how to use the Django (Python) and Express (Node.js/JavaScript) web frameworks to create basic applications.

next: first steps 

https://developer.mozilla.org/en-US/docs/Web/HTTP/Cookies

## What cookies are used for
Cookies are mainly used for three purposes:

- Session management: User sign-in status, shopping cart contents, game scores, or any other user session-related details that the server needs to remember.
- Personalization: User preferences such as display language and UI theme.
- Tracking: Recording and analyzing user behavior.

https://developer.mozilla.org/en-US/docs/Learn/Server-side/First_steps/Introduction
## Introduction to the server side