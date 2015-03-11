# MyPacteraDemo
Pactera Test Automation

Short Description :
-------------------
I have used the following for implementing the solution
1. Selenium WebDriver
2. TestNg
3. Maven

Implemented two options to run the tests 
1.Using the testng.xml.Testng.xml defines the set of testcases to be run.
2.Tests in folder tests/java using surefire plugin of maven.

Ideally one is chosen in production environment.Implemented both just for demo purpose.

Settings to be made after source code download :
------------------------------------------------
1. Set Maven_Home = <rootfolder>\PacteraDemo\src\include\apache-maven-3.2.5 
2. Set path = <rootfolder>\PacteraDemo\src\include\apache-maven-3.2.5\bin
3. Ensure Java_Home is properly set 

How to Run :  
----------
Open the command prompt.Navigate to PacteraDemo folder.

1. mvn test    -- Run the tests in test/java folder
or 2. mvn test -DtestNG.file=/src/configuration/testng.xml -- run the tests specified in testng.xml


