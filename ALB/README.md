# Runing Spring Boot Application in EC2 and routing traffic through AWS-ELB Application Load Balancer

This article will cover following use cases.

 1. Run two Spring Boot applications in a single EC2 instances.

 2. Access Spring Boot applications in Web using EC2 IP address.

 3. Implement an AWS application Elastic Load Balancer and configure these two apps in ALB.

 4. Disable any direct public access to apps in EC2.
 

## Run two Spring Boot applications in a single EC2 instances

To  application in AWS-EC2 follow steps given in 

https://github.com/techgiants19/aws/tree/master/EC2/SpringBoot/signup


Note you have to add port 8081 & 8082 in security-group if you want to use **singnup** and **signin** apps 
and existing security group.

Also to start two applications you have to open two putty sessions connecting to your EC2 instance 
and those two terminals must be open aslong as you want those two applications want to be in running status.


