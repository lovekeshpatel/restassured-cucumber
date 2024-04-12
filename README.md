
# SDET Assessment

This is gherkin project based on Maven, Cucumber, JUnit and REST Assured API automation test.

* Here is the project structure

```bash

├── config.properties
├── pom.xml
├── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── sdet
    │   │               ├── stepdefinition
    │   │               └── utils
    │   └── resources
    └── test
        ├── java
        │   └── com
        │       └── sdet
        │               └── TestRunner.java
        └── resources
            ├── features
            └── schemas

```


## Key features of framework
* Generates execution logs, with detailed request and response details.
* This also has an example to validate response body using json schema.
* Test execution can be triggered form command line.
* Easy integration to CI/CD pipeline.
* Allure Reporting

## Required steps
* Java should be installed and configured, java version "1.8.0_401" or greater.
* Maven should be installed and configured.
* Allure should be installed and configured

## Runining test
* Open the command prompt and navigate to the folder in which pom.xml file is present. Run the below Maven command.
```mvn clean test```
* Once the execution completes log will be generated in below folder.
Log: target/logs

## Allure Report
* Open Terminal: allure serve target/allure-results


