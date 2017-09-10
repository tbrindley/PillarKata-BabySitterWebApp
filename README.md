# PillarKata-BabySitterWebApp
##Overview
This program is a web application that will calculate the rate for a babysitter based on hourly salary constraints.  The web app will pay the babysitter $12hr from start till bedtime, $8hr from bedtime until midnight, and $16hr from midnight until quitting time.  This application uses Spring MVC, Java, HTML, CSS3, and javascript.
##Prerequisites
There are a few dependencies needed to run this application.  All dependencies are managed through [Maven](https://maven.apache.org/).  In order to both run and test this application, you will need to have the following dependencies added:
* JDK8
* Spring - for the web application
* JUnit - for testing
* Hamcrest - also for testing
* Tomcat - to run your application locally

All dependencies are available in the include pom.xml file.

##Building
*  Clone this project from the github repository [github.com/tbrindley/PillarKata-BabySitterWebApp.git](https://github.com/tbrindley/PillarKata-BabySitterWebApp.git)
*  Ensure all dependencies have been added to your package.  Once again, these can be viewed in the pom.xml file
    * Don't forget to reimport from Maven after adding the dependencies.
*  Add the Spring facet to your project
*  In Intellij, edit your run configurations to use tomcat locally
    * The default http port is 8080 and the default JMX port is 1099 
    * Add your War exploded artifact to your new run configuration.
*  Run locally using tomcat

