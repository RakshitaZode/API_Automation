API Automation with CI/CD Integration
--------------------------------------------------------------------------------------------------

This project is a custom-built API automation test suite developed using Java, RestAssured, Maven and JUnit. It targets the public API [https://jsonplaceholder.typicode.com] to perform CRUD operations and negative test cases. The suite is integrated with GitHub Actions for CI/CD, running tests automatically on every push, and publishing results in JUnit format.

Tools and Technologies:-
--------------------------------------------------------------------------------------------------

- Java 11+

- Maven: Dependency management and build tool

- RestAssured: API testing framework

- JSONPlaceholder: Public API for test data

- GitHub Actions

- JUnit Report Format: For CI test result publishing

Pre-Requisites:-
--------------------------------------------------------------------------------------------------
Before you run this project, make sure your system have following:

- Java JDK
- Maven installed
- Eclipse
- Git

Working:-
--------------------------------------------------------------------------------------------------

/base/APIBase.java: Sets up the base API configuration like the base URL and common headers.

/com.demo.api_automation/UsersAPI.java: Contains methods to call different API endpoints (GET, POST, PUT, DELETE). It handles both normal and negative test scenarios.

utils/TestDataGenerator.java: Generates sample JSON and Map objects used as request bodies for creating or updating posts.

tests/UsersAPITest.java: TestNG test class that uses methods from UsersAPI and data from TestDataGenerator to run tests covering all cases.

GitHub Actions Workflow:-
--------------------------------------------------------------------------------------------------

GitHub Actions workflow runs these tests automatically when code is pushed either via 

1. Push code to the repository

2. Open a pull request

The workflow file is located at:".github/workflows/api-tests.yml"

SetUp Instruction:-
-------------------------------------------------------------------------------------------------

1. Clone the repository
   -Command: git clone https://github.com/RakshitaZode/API_Automation.git
   
2.Open in Eclipse

-Go to Eclipse/File/Import
-Choose Existing Maven Projects → Select the cloned folder

3.Run the Tests

-Go to: src/test/java/tests/UsersAPITest.java
-Right-click on the file → Select Run As → JUnit Test



