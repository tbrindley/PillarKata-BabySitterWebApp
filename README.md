# PillarKata-BabySitterWebApp
## Overview
This kata simulates a babysitter working and getting paid for one night.  The rules are pretty straight forward.

The babysitter:
- starts no earlier than 5:00PM
- leaves no later than 4:00AM
- gets paid $12/hour from start-time to bedtime
- gets paid $8/hour from bedtime to midnight
- gets paid $16/hour from midnight to end of job
- gets paid for full hours (no fractional hours)

## Dependencies
There are a few dependencies needed to run this application.  All dependencies are managed through [Maven](https://maven.apache.org/).  In order to both run and test this application, you will need to have the following dependencies added:
* JDK8
* Spring - for the web application
* JUnit - for testing
* Hamcrest - also for testing
* Tomcat - to run your application locally

All dependencies are available in the include pom.xml file.
## Building Tests
* The easiest way to run the tests is to go to the parent directory of this project and run through Maven.
    * Open command Prompt and navigate to the parent directory.
    * From the parent directory, run
    ```
    mvn clean test
    ```
    * This will automatically compile all tests, add any necessary packages, and run them.

## Building and Running
*  Clone this project from the github repository [github.com/tbrindley/PillarKata-BabySitterWebApp.git](https://github.com/tbrindley/PillarKata-BabySitterWebApp.git)
*  Ensure all dependencies have been added to your package.  Once again, these can be viewed in the pom.xml file
    * Don't forget to reimport from Maven after adding the dependencies.
*  Add the Spring facet to your project
*  In Intellij, edit your run configurations to use tomcat locally
    * The default http port is 8080 and the default JMX port is 1099 
    * Add your War exploded artifact to your new run configuration.
*  Run locally using tomcat

