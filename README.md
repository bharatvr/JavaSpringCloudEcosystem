Project Title : Java Spring Cloud Ecosystem


 
Getting Started:

 Java Spring Cloud Ecosystem has four module as given below and we can easly test locally. These appliaction are about how spring config server, load balacing with Zuul and eureka work.
  
  1. spring-config-server
  2. eureka-server
  3. career-guide-service
  4. zuul-server
They are running at separate port and communicating to each other internally. 

* In order to test appliaction you first need to start spring-config-server > eureka-server > carrer-guide-service > zuul-server.
* Everthing should run fine, you can check eureka server where career-guide-service and zuul-server must registed on eureka server. 

 * Concept of spring config server : Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system.” The default implementation of the server storage backend uses git.  Client application can get required application.properties based on environment from git location.
 
http://localhost:8081/

Under Instances currently registered with Eureka: Like below. If, yes that mean everything is running fine.

Application	AMIs	Availability Zones	Status
CAREER-GUIDE 	n/a (1) 	(1) 	UP (1) - 192.168.0.12:career-guide:8089
ZUUL-SERVER 	n/a (1) 	(1) 	UP (1) - 192.168.0.12:zuul-server:8762

In order to test career-guide-service : We are not suppose to hit this server directly but request should be route through zuul server and let hit appliaction through zuul port.

http://localhost:8762/career-guide/healthCheck ( As zuul server runnign at 8762 , once he get a request for 
 appliaction career-guide "appliaction name define in  career-guide-service config file" he will get all running instance list of this appliaction from eureka server and then route the request to actual appliaction.
 You should be able to see the response as :
 {
    "value": "Great!, your service running through zuul serve",
    "success": true
}

 In order to test zuul divert traffic. Let create multiple instance of career-guide-service but make sure each instance have diffrent port and appliaction name should be same as "career-guide". For more calrity if you are using eclipse let create aseperate work space for each instance of career-guide.

Let, again check eureka server http://localhost:8081/ and this time you should be able to multple running instance under CAREER-GUIDE.

It’s time to test application again. Let do multiple concurrent hit on http://localhost:8762/career-guide/healthCheck AND this time request will routed to all running instance randomly. This is ZUUL load balancing concept here.


Built and Environment
 
 Maven - Dependency Management
 Java - JDK 1.8 
 Spring Boot 2.0.4
 Eclipse
 Github plugin in eclipse
 

Authors
 @ Bharat Singh

