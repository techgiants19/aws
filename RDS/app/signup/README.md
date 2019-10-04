# Connecting Oracle DB using Spring Boot Application

This article give overview of connecting a Oracle Data base using Spring Boot application.

**Prerequisite**

 - Java IDE of your choice.In this example we are using STS.
 - Maven
 - Oracle Data Base. In this example Oracle data base is created in AWS Cloud.To create a AWS-RDS DB refer below link.
   https://github.com/uthircloud/aws/tree/master/RDS
   
 
 ## Create a sample application named singnup
 
 To create sample maven application use spring initializr it will create quick template app as per our need with given
 dependencies.
 
 Click below link
 
 https://start.spring.io/
 
 Give Group and Artifact name as per your project name.
 
 ![Bootstrat](https://user-images.githubusercontent.com/50639924/65980809-de99ab80-e445-11e9-9ce9-3decb69e84ae.PNG)
 
 Choose dependencies for your project by typing your dependcy keyword. In this case as we creating a
 REST application with DB connection we need Web,JPA dependencies.Type these two dependencies individualy and add them one by one.
 Click Generate it will crate a sample templeate project and download to your local.
 
 ![Dependency](https://user-images.githubusercontent.com/50639924/65981012-3e905200-e446-11e9-9a68-59054e2ebb89.PNG)
 
 ![Generate](https://user-images.githubusercontent.com/50639924/65981241-b1013200-e446-11e9-9598-9a528fc40c78.PNG)
 
  ## Application configurations and DB connection Implementation.
  
  Extract download project zip file and import it into your local.Application pom.xml will have following dependencies.
  
  **spring-boot-starter-web** -> Will give REST specific libraries.
  **spring-boot-starter-data-jpa** -> Will give JPA specific libraries.
  
  We have to add **ojdbc8** jar manually as it provide driver to connect DB.

  Also add **spring-boot-starter-actuator** which gives some useful endpoints for application monitoring.
  
    <dependency>
			   <groupId>org.springframework.boot</groupId>
			   <artifactId>spring-boot-starter-web</artifactId>
	   </dependency>

	   <dependency>
			   <groupId>org.springframework.boot</groupId>
			   <artifactId>spring-boot-starter-data-jpa</artifactId>
	   </dependency>
   
    <dependency>
	     <groupId>com.oracle</groupId>
	     <artifactId>ojdbc8</artifactId>
	     <version>12.1.0.1</version>
	   </dependency>
 
    <dependency>
			   <groupId>org.springframework.boot</groupId>
			   <artifactId>spring-boot-starter-actuator</artifactId>
	   </dependency>

  Create a **application.properties** file with below  configuration

    server.port=8081
    server.servlet.context-path=/usersignup
    spring.datasource.url=jdbc:oracle:thin:@//<Your RDS DB HostName>:1521/<dbname>
    spring.datasource.username=<UserName>
    spring.datasource.password=<Password>

 
 Create a entity class name User
 
     @Entity
     @Table(name="USER_REG_INFO",schema="ORACLETESTADMIN")
     public class User {

	    @Id
	    @Column(name="EMAIL_ID",unique=true,length=50,nullable=false)
	    private String emailId;
	
    	@Column(name="USER_NAME",length=50,nullable=false)
	    private String userName;
	
	    @Column(name="PASSWORD",length=50,nullable=false)
	    private String password;

Create a repository **UserSignUpRepository** which extends CrudRepository<?,?>  interface from which inherit all default DB functions.
 
    @Repository
    public interface UserSignUpRepository extends CrudRepository<User,String> {

    }
    
Create a User model calss to receive input request domain object.

    @JsonIgnoreProperties(ignoreUnknown=true)
    @JsonInclude(value=Include.NON_NULL)
    public class User {
	    @JsonInclude(value=Include.NON_EMPTY)
	    private String emailId;
	    @JsonInclude(value=Include.NON_EMPTY)
     private String userName;
	    @JsonInclude(value=Include.NON_EMPTY)
	    private String password;
	    @JsonInclude(value=Include.NON_EMPTY)
	    private String lastLogInTime;
     
  Finally create respective Controller and Service classes and bind them properly with constructor injection.
  
  Also in main application class **SignupApplication** make sure respective classpath scanning and Jpa repositories are configured.
  
     @SpringBootApplication(scanBasePackages={"com.learntech.teamtracker"}) // To scan application beans.
     @EnableJpaRepositories(basePackages="com.learntech.teamtracker.repository") // To scan JPA repositories.
     public class SignupApplication {

	     public static void main(String[] args) {
		   SpringApplication.run(SignupApplication.class, args);
	  }}

To generate Sample request for this application refer **UserRequestGenerator.java**
