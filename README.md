# ReadMe Help File 1

## REQUIREMENT FOR THIS PROJECT :

- Tomcat : 9.0
- Java : 17
- Postgres : Latest

## STEP BY STEP GUIDE FOR CREATING THIS PROJECT

### 0. File formate should look like this :  

````
ServletProject1/
├── Deployment Descriptor: ServletProject1
├── JAX-WS Web Services
├── Java Resources/
│   ├── Referenced Libraries/
│   │   ├── jstl-1.2.jar
│   │   └── postgresql-42.7.7.jar
│   └── src/
│       └── main/
│           └── java/
│               └── com/
│                   └── example/
│                       ├── AddServlet.java
│                       ├── DBUtil.java
│                       ├── HelloServlet.java
│                       ├── HelloWorldServlet.java
│                       ├── JspServlet.java
│                       ├── Laptop.java
│                       └── LaptopServlet.java
└── webapp/
    ├── META-INF/
    ├── WEB-INF/
    │   ├── lib/
    │   └── web.xml
    ├── index.html
    ├── laptops.jsp
    ├── newjsp/
    └── README.md
````



### 1. CREATE WEB.XML

1. Location : src/main/webapp/WEB-INF/web.xml

2. base data of web.xml
````xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" version="3.1">
    <servlet>
        <servlet-name>AddServlet</servlet-name>
        <servlet-class>com.example.AddServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>AddServlet</servlet-name>
        <url-pattern>/add</url-pattern>
    </servlet-mapping>
</web-app>
````
### 2. Create a index.html
Location : src/main/webapp/index.html


````html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Number Input Form</title>
</head>
<body>

    <h2>Add Two Numbers</h2>

    <form action="add" method="post">
        <label for="num1">Number 1:</label>
        <input type="number" id="num1" name="num1" required><br><br>

        <label for="num2">Number 2:</label>
        <input type="number" id="num2" name="num2" required><br><br>

        <input type="submit" value="Add Numbers">
    </form>

</body>
</html>
````

### 3. AddServlet
Location : src/main/java/{pakage}/AddServlet

````java
package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        // Correct method names (case-sensitive)
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));
        int k = i + j;

        // Set content type before writing response
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Sum is: " + k + "</h2>");
    }
}
````

### 4. Adding .jar file to project

✅ For Java Project
- Open Eclipse and go to your Java Project.

- Right-click on your project in the Package Explorer
		→ Click on Build Path
		→ Select Configure Build Path...

- In the Properties window, go to the Libraries tab.

- Click on Add External JARs...
		→ Navigate to the location of your .jar file
		→ Select it and click Open.

- Click Apply and Close.


### 5. Download Jar from : 
````
	- 1. postgresql-42.7.7.jar : https://drive.google.com/drive/folders/1yGpnuBw-n_LWRfOTesecj8CbY7Ruk9zX?usp=sharing
	- 2. jstl-1.2.jar : https://drive.google.com/drive/folders/1yGpnuBw-n_LWRfOTesecj8CbY7Ruk9zX?usp=sharing
````







