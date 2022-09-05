# AutomationWebPage

# Project Setup
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one).
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse
- File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
- Select the right project
- Right Click on the file and select Maven insall
- You are all Set
  
 # About Project
 
 -  This Page Object Module Framework is implemented based on the JavaConcepts+Selenium+TestNG
 -  src/main/java - All those content is common all the testclass - Driver Initialization, Utils class to read properties file, Constants class contain the all the   config file path.
 -  Page object package will contain the objects methods of wiki and IMDB page and call those object methods in your testcase
 -  Inside the resources package, keeped the properties and object repro file common to use in all page class and testcase
 -  src/main/test - All those content in baseSetup will be use in testcase - It will initialization the browser , close the browser and it will also contains the Extend reports to generate a test report for each test
 - testcases package - CountryandReleaseDateTest class will contains testcases.
 - Inside testcase we call a methods from the wiki page and imdb page.
 - for both IMDB and Wiki -Validating the country name and release date using assertion in the testcases, if country name and release date for both Imdb and Wiki page is not matched, then assertion will throw an expection and testcase will fail.
 - You can see the report in the reports folder of the project, based on testcase execution.
 
