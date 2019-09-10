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

To run this application in 8081 port in EC2 we need to open that port in EC2. This can be achieved adding a custom TCP rule with port 8081 in EC2 security group.

Create/Update a security group by adding a new Custom TCP rule with port 8081. In this case a new security group **spring-boot-app-sec-group** is created with port 8081.

![Security-Grp](https://user-images.githubusercontent.com/54984988/64633163-aebc3280-d3c8-11e9-985e-387555edc7b9.PNG)

With this security group configuration launch your EC2.

![spring-boot-EC2](https://user-images.githubusercontent.com/54984988/64633787-df509c00-d3c9-11e9-8faf-2b6e92472eb2.PNG)

After launching EC2 connect to it using putty by using **security-keypair** in Windows. And navigate to ec2-user home page.

To Connect EC2 open putty and give your EC2 instance public ipv4 address as ec2-iser@54.191.163.208

![EC2-Putty](https://user-images.githubusercontent.com/54984988/64634588-939ef200-d3cb-11e9-9d75-eb0e422efe93.PNG)

Then configure your IAM user **security-keypair** which you have downloaded when createing account or user in putty as like bleow.

![EC2-KeyPair](https://user-images.githubusercontent.com/54984988/64634811-1a53cf00-d3cc-11e9-9083-58364857d9f4.PNG)

After configuring this keypair click open you can see EC2 instance home if all your configuration is fine.

![EC2-LogIn](https://user-images.githubusercontent.com/54984988/64634900-4f602180-d3cc-11e9-8c91-b1f77a29faaf.PNG)

Now navigate to user home by giving command **pwd**

![EC2-User-Home](https://user-images.githubusercontent.com/54984988/64635008-a1a14280-d3cc-11e9-88a2-dafa8709a2ac.PNG)

## Moving application to EC2 and Running.








