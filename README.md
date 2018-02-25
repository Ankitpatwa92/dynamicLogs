# Log Level at Runtime

### Description
*This project shows how one can set log level dynamically at package level.In this app it is shown by main method same can be done in web 
application.
*In this app there are three packages **com.first,com.second,com.third** and in **log4j.properties** file log level is set at **WARN** for all three.
packages.
*At run time by providing package name and log level,log level for particular package can be changed.

#### Prerequisites
* Jdk 1.8
* Mavean

#### Installation
* Run mvn command **mvn clean compile** it will compile code and install all dependencies mentioned in **pom.xml**.

#### Execution
 * Run SampleApp class it will shows instructions. 

#### Key Methods
Methos **setLogLevelByPackage** is used to change log level based on package.
