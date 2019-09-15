# Runing Spring Boot Application in EC2 and routing traffic through AWS-ELB Application Load Balancer

This article will cover following use cases.

 1. Run two Spring Boot applications in a single EC2 instances.

 2. Access Spring Boot applications in Web using EC2 IP address.

 3. Implement an AWS application Elastic Load Balancer and configure these two apps in ALB.

 4. Disable any direct public access to apps in EC2.
 

## 1. Run two Spring Boot applications in a single EC2 instances

To  application in AWS-EC2 follow steps given in 

https://github.com/techgiants19/aws/tree/master/EC2/SpringBoot/signup


Note you have to add port 8081 & 8082 in security-group if you want to use **singnup** and **signin** apps 
and existing security group.

Also to start two applications you have to open two putty sessions connecting to your EC2 instance 
and those two terminals must be open aslong as you want those two applications want to be in running status.


## 2. Access Spring Boot applications in Web using EC2 IP address

To access the two applications we must run two applications in two different putty session as like below.Also make sure your EC2 instance security gropu is updated with ports in which your going to access the applications.

In our case we are going to run applications in 8081 and 8082. So we have to have these ports added in EC2 isntance security group.

![Security-Group-Port](https://user-images.githubusercontent.com/54984988/64926851-a4d36e80-d7d0-11e9-9cb2-02f2335e7006.PNG)


Make sure applications are started successfully from startup logs.

![Two-App-session](https://user-images.githubusercontent.com/54984988/64926738-07c40600-d7cf-11e9-8bd3-8574d5536ba7.PNG)

You can hit the applications using EC2 instance URL.

For our signup and singnin apps below is URL when installing my EC2 instance.

http://54.191.163.208:8081/usersignup/signup?username=test

![signup-ec2](https://user-images.githubusercontent.com/54984988/64926877-fed43400-d7d0-11e9-8142-2232ca4d0ace.PNG)

http://54.191.163.208:8082/usersignin/signin?username=test

![signin-ec2](https://user-images.githubusercontent.com/54984988/64926878-04317e80-d7d1-11e9-8598-62b1c18979fd.PNG)

## 3. Implement an AWS application Elastic Load Balancer and configure these two apps in ALB.

Navigate to Load Balance section in your dashboard and click Load Balancer.


![Listerner-config](https://user-images.githubusercontent.com/54984988/64926950-152ebf80-d7d2-11e9-88b9-5412f7b17bdc.PNG)

Choose Application Load Balance

![ALB-Config-init](https://user-images.githubusercontent.com/54984988/64926954-2081eb00-d7d2-11e9-8a28-75f5a3edc704.PNG)

Have listener to point port 80 as we are going to expose our ALB in 80 port for all HTTP traffic.

![Listerner-config](https://user-images.githubusercontent.com/54984988/64926957-2a0b5300-d7d2-11e9-9b8f-801eb0f463d1.PNG)

Choose all Availability zone as its best practice.

![ALB-AZ](https://user-images.githubusercontent.com/54984988/64926968-46a78b00-d7d2-11e9-83b8-e0d9ccc31f9d.PNG)

Next section is for configuring secure ALB (HTTPS) for our case we will use HTTP so we can skip this section.

Create a security group for ALB to control/allow traffic to ALB. Alternatively you can re-use existing security group if that 
satisfy your config needs. In our case we create a new security group with HTTP protocal and port 80 as we are exposing our ALB in this PORT only.

![ALB-Sec-grp](https://user-images.githubusercontent.com/54984988/64927142-d0585800-d7d4-11e9-88d9-2c6bb72bd663.PNG)

Now create a target group in which we have to specify to which port and protocal ALB needs to route incoming traffic.
In our case we have to route traffic to port 8081 using HTTP as we have one of our app is runing in this port.

![signup-sec-grp](https://user-images.githubusercontent.com/54984988/64927180-4f4d9080-d7d5-11e9-89c6-3e12b56ab162.PNG)

Also we have to specify health check URL for our application. It should be valid URL.In our case it will be **/actuator/health**
As we are using Spring Boot 2.x this our health url.


![signup-target-grp-healthcheck](https://user-images.githubusercontent.com/54984988/64927207-bc612600-d7d5-11e9-8ca0-21aa2170d3a2.PNG)

Have remaining Advanced health setting as default values.

Next we have to register targets in our case we have single EC2 instance in which both our app is running. So we have to choose that instance and register it with port **8081** as our singnup app is running in this port.


![signup-targets-8081](https://user-images.githubusercontent.com/54984988/64927243-37c2d780-d7d6-11e9-876b-075eb32c21fe.PNG)

Review your configurations and create. Now our ALB is ready to route traffic to 8081 port app.

Now you can hit your **signup** appliction using ALB DNS name.

![ALB-DNS](https://user-images.githubusercontent.com/54984988/64927278-ac961180-d7d6-11e9-914e-5366b8a844fb.PNG)

http://spring-boot-alb-1212925296.us-west-2.elb.amazonaws.com/usersignup/signup?username=test

Similarly we can create another target group for our singnin app and register it to EC2 instance.

To create a Target Group click Traget Grop link in dash board.

![signin-target-grp](https://user-images.githubusercontent.com/54984988/64927318-3fcf4700-d7d7-11e9-8a00-f246290fae3e.PNG)

To register a target choose target group and click tragets and edit.


![signin-target](https://user-images.githubusercontent.com/54984988/64927335-87ee6980-d7d7-11e9-98b6-869daa0ae384.PNG)

Now we have to tag this target group to our ALB.Click your ALB and click HTTP Listner view/edit rules.

![RoutingRule](https://user-images.githubusercontent.com/54984988/64927420-a4d76c80-d7d8-11e9-90e7-080928dbcd1d.PNG)

![routing-rule-2](https://user-images.githubusercontent.com/54984988/64927429-c46e9500-d7d8-11e9-956b-329954c1a4f7.PNG)

Click + symbold to add new rules and click insert new rule. 

In the new rule Add condition choose path and give your application path **/usersignup/*** and choose add action as Forward and respective target group.


![RoutingRule](https://user-images.githubusercontent.com/54984988/64927552-3eebe480-d7da-11e9-8505-122f6e070c56.PNG)


![NewRule](https://user-images.githubusercontent.com/54984988/64927556-4f9c5a80-d7da-11e9-8850-a67a5eabce88.PNG)


![routing-rule-2](https://user-images.githubusercontent.com/54984988/64927559-56c36880-d7da-11e9-9636-f708d256e69d.PNG)

Below are sample ALB URL.

http://spring-boot-alb-1212925296.us-west-2.elb.amazonaws.com/usersignup/signup?username=test

http://spring-boot-alb-1212925296.us-west-2.elb.amazonaws.com/usersignin/signin?username=test

## 4. Disable any direct public access to apps in EC2

As per above configuration we can able to access our App using ALB as well as direct EC2 instance IP. We can disabe this by editing EC2 instance security group. Change EC2 instance security group source to ALB security group.

![alb-sec-grp-edit](https://user-images.githubusercontent.com/54984988/64927609-0bf62080-d7db-11e9-8d76-ae1632dfa63e.PNG)

After this configuration if you try to access direct EC2 URL it will fail.












