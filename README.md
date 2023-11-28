# SearchEngingTests
Framework for testing Google search page https://www.google.com/webhp
Task is:

Search by: Name, full name. (valid search is based on the current output of your search query).
-When you hover the mouse over the input field, the corresponding tooltip is displayed (in google this is the word "Search").
-After clicking on the logo on the upper left side, an empty results area is displayed.

# Technology Stack
- Java17
- Gradle
- Selenide7.0.2
- TestNG
# Framework & Design Considerations
Framework based on PageObject pattern. It contains pages that are divided into modules with WebElements and Methods to work with Elements. Tests are located in the test folder and are inherited from the BaseTest.class. 

# project directory structure
-src
 -main/java/libertex 
  -modules 
  -pages
 -test
  -java/libertex/tests
  - resourses
 
# Installation and Test Execution
./gradle :test
# Test Report
 $buildDir/test-output
# Note :


 
