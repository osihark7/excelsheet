1. Create A spring Maven project using Spring spring initializr and select the java version 1.8.
2. Select the dependency like MYSQL, Spring Web, Spring Dev Tools, Spring JPA and

3. Add this Dependency for the excel sheet download
4.  <dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>4.1.2</version>
		</dependency>

5. Connect Data base like as per you use the data base like mysql , oracle, Postgress Sql.
6. Configuration the database details in side of the application.properties file in side of the Resource folder.
7. After that you can make the package in side the project like   model, repository, controller, service and  helper.
8. Inside of the model package make a entity class like UsersDetails and give the all column details
9. indside of the repositoty interface you can make a UsersDetailsRepository interface
10. Inside of the servce package you can create a service class UsersDetailsService class.
11. Inside of the  Helper Package you can make a ExcelHelper Class and metion the all details
12. Inside of the controller package you can make a UsersDetailsController class.
13. These all are implemented successfully you can check you api in browser or postmain
14. http://localhost:9092/sheet/api/createUser     // create user 
15. http://localhost:9092/sheet/api/users  // get user list
16. http://localhost:9092/sheet/api/users/18 // get user by userid
17. http://localhost:9092/sheet/api/download  // download the excel sheet data to hit this api in browser
