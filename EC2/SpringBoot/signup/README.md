# Running a Sprning Boot Application in EC2.

In this article we can see how to run a Spring Boot application in AWS-EC2.

**signup** is a simple spring boot application. It will expose a REST GET endpoint when hitting this end point it will return a simple String as output.  

First download this code into your local and build and run it in eclipse and command line and make sure its running.

**Tip:** signup-1.0.0-SNAPSHOT.jar will be available in your applocation target folder after successful build.

To run execute **SignupApplication.java** this app will start in port 8081 with context root **/usersignup**

To run this application as standalone jare execute **java -jar signup-1.0.0-SNAPSHOT.jar**

Onec application is started in local you can access this app using **http://localhost:8081/usersignup/signup?username=test**
This will give output as **Welcome to SignUp Page**

## Setting up AWS-EC2

