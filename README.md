SPRING BOOT REST 2

Getting Started

Pre requisites 
-JDK 1.8.0_191
-Clone the repository/download from 'https://github.com/Tayyba23/LMS.git'


Compiling and test running and packaging 
-Open command prompt
-Navigate to root directory of repository 'spring-boot-rest-2'
-run command 'mvnw clean package
-You can see log for test as well. 
-After success message, you can run the server.
-run command 'java -jar target\spring-boot-rest-2-0.0.1-SNAPSHOT.jar'


Tasks Completed 

Entity : User 
Operations Completed : 

1. CRUD Operation
	a. GET :
		 endpoint : /user/alluser
	b. PUT : 
		endpoint : /user
	           with json object in payload

	c. DELETE : 
		endpoint : /delete/user/{userId}
	d. UPDATE : 
		endpoint : /update/user 
				with json object in payload
JSON Object Format: 
	{
	"id" :"1",
	"name" : "FirstName LastName",
	"cnic" :  "456",
	"mobile" : "1234-567",
	"address" : "xyz City"
	}

2. File System as database and give option to configure storage format via onfiguration file ( json or yaml ) - Concept of DI
		-default format is json 
		-you can change by setting value of storage.format either set it to json or yaml in application.properties file
 In case of json, it will create json file on put request
 In case of Yaml, It will create yaml file on put request

 Note : File handling is not added for every CRUD operation except POST method beause of long power failures at home by Govt.

3. All API Requests should be logged to file 
	- API Requests logged to file in \logs\Application.log
	- used log4j2 for logging

UNIT Tests 

-Write Unit Test for Create Function i.e. post request - done

Note:
-Eclipse ( Oxygen used to develop)


