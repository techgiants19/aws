# Running a Spring Boot Application in EC2.

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

## Install Java in EC2.

Always update your EC2 AMI if you are creating for first time.

**sudo yum update -y**

![Ec2-Update](https://user-images.githubusercontent.com/54984988/64639884-cc909400-d3d6-11e9-8c6c-7d1e2785ea12.PNG)

This will update the EC2 AMI image.

Depending on type of EC2 instance AMI java will be available or not available by default. If you choose most recent AMI when launching your EC2 java won't be available by default. In this case first we need to install Java 1.8 in EC2.

To check does EC2 instance have java installed type **java --version** from your EC2 home directory in putty.

![JavaCheck](https://user-images.githubusercontent.com/54984988/64639471-e8476a80-d3d5-11e9-96d2-8346678c6621.PNG)

In this case as Java is not available its giving error.

To install java execute below command.

**sudo yum install java-1.8.0 -y**

This install openJDK for java-1.8 in your EC2 instance.


## Moving application to EC2 and Running.

To run a Spring Boot application in EC2 we have to move the application jar (**signup-1.0.0-SNAPSHOT.jar**) inside EC2. This can be achieved in different ways.
We will use Git-bash to move this file to EC2.


If you don't have Git-bash already in your machine download it from below site.

https://git-scm.com/downloads

Open your Git-bash terminal. To open in windows start search type **Git Bash**

From this terminal we will do a secure copy to our EC2 instance which is running on AWS.

To connect our EC2 instance from bash we need to use below command.

scp -i <Path/of/your/pemfile> <Path/of/your/appfile> ec2-user@ec2-54-185-61-202.us-west-2.compute.amazonaws.com:~

In this 

**Path/of/your/pemfile ->**  Path in your local machine where .pem file of your security-keypair. Either you can give complete path or in bash shell navigate to that path and give the file name here when executing this command.

**Path/of/your/appfile ->** Path of your application in your local machine.signup-1.0.0-SNAPSHOT.jar complete path.

ec2-user@**ec2-54-185-61-202.us-west-2.compute.amazonaws.com ->** ec2-54-185-61-202.us-west-2.compute.amazonaws.com is your instance **Public DNS (IPv4)** name

When we execute this command it will move the file to EC2 user home directory from our local machince.

Before moving this file to EC2 just login to EC2 in putty as following above given steps and execute command **ls -ltr**
This will list existing files in the user home directory.

![EC2-Home-ls](https://user-images.githubusercontent.com/54984988/64637548-08752a80-d3d2-11e9-8865-7bc8fb0f00ba.PNG)

In this case we don't have any file in home directory.

Now lets move the **signup-1.0.0-SNAPSHOT.jar** from local to EC2 using **Git Bash**

I have my security-keypair file in my **C:\Users\UthirNew\Desktop\AWS_Learning\EC2** so in my Git bash shell I have naviate to this folder.

**Tip:** In bash shell folder navigation should be represented using forward slash.

Type from your current directory to your .pem file directory and hit enter. 

**cd C:/Users/UthirNew/Desktop/AWS_Learning/EC2**

![GitBash-pemnavig](https://user-images.githubusercontent.com/54984988/64638174-4c1c6400-d3d3-11e9-81ec-88f6623fa0e0.PNG)

Now execute below command. Make sure you change this command path as per your local machine.

**scp -i http-server-ec2-keypair.pem C:/TechGiants/springbootapps/signup/target/signup-1.0.0-SNAPSHOT.jar ec2-user@ec2-54-191-163-208.us-west-2.compute.amazonaws.com:~**

After executing this command it will prompt for confirmation to connect.  Type yes to get connect and move the file.

**Are you sure you want to continue connecting (yes/no/[fingerprint])?**

![Bash-FileMove](https://user-images.githubusercontent.com/54984988/64638543-f3999680-d3d3-11e9-8084-8cbdf1bd8a17.PNG)

If everything is ok you can see successful transfer of  your jar or file to EC2 instance. To confirm the same login to EC2 instance and execute **ls -ltr** command from user home directory. Now you can see **signup-1.0.0-SNAPSHOT.jar**

![JarInEC2](https://user-images.githubusercontent.com/54984988/64638925-c4375980-d3d4-11e9-8ca8-c1eeb17b5470.PNG)

Now we are all set to run this application in EC2.

To Run this applocation run below command from the directory in which application jar file is placed. In this case **/home/ec2-user**

**java -jar signup-1.0.0-SNAPSHOT.jar**

![AppLaunch-EC2](https://user-images.githubusercontent.com/54984988/64640406-e7afd380-d3d7-11e9-9bf3-c3f95288e776.PNG)

You can see successful launch of the application. As we configured port 8081 in **application.properties** in the application code this app will be started in 8081. 


Also we have created a Custom TCP rule in EC2 security-group with port 8081 with this we can access this app using below URL.

http://54.191.163.208:8081/usersignup/signup?username=test

**http ->**  Protocal

**54.191.163.208 ->** EC2 instance public IPv4

**8081 ->** Application port defined in **application.properties**

**/usersignup ->** Application Contect Root defined in **application.properties**

**/signup?username=test** Resource path with Query param defined in application code.

![App-Page](https://user-images.githubusercontent.com/54984988/64641020-46298180-d3d9-11e9-8227-92172a5dec41.PNG)


**Note:** If you want this application to be in running state you have to make sure not closing your Putty also should not user Cntrl+C.

























