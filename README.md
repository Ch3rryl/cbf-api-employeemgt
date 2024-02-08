
<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/Ch3rryl/cbf-api-employeemgt">
    <img src="src/Images/HRLogo.jpeg" alt="Logo" width="80" height="80">

  </a>

<h3 align="center">Employee Management API</h3>

  <p align="center">
    Employee management API using Java and Spring boot to handle full CRUD operations.
    <br />
    <a href="https://app.swaggerhub.com/apis/CHERRYL/employee-mgt-api/v0"><strong>Explore the docs »</strong></a>
    <br />

  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li>Java</li>
        <li>Spring boot</li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <p>Ensure you have the following installed:</p>   

            1. [JDK 17](https://learn.microsoft.com/en-gb/java/openjdk/download#openjdk-17) (or higher)
            2. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
            3. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

  

        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

The Employee Management API is a Java/Spring Boot application designed to facilitate the management of employee data. This project provides a robust backend infrastructure for handling CRUD (Create, Read, Update, Delete) operations on employee records stored in a JSON file. It leverages the Spring framework for dependency injection and RESTful web service development.

###  Features

<li><b>JSON Repository:</b> Implements an employee repository using JSON file storage, allowing for seamless data persistence.</li>
<li><b>CRUD Operations:</b> Supports Create, Read, Update, and Delete operations on employee records, providing flexibility in managing employee data.</li>
<li><b>Search Functionality:</b> Enables searching for employees by name or job title, enhancing usability and efficiency in retrieving relevant employee information.</li>
<li><b>Exception Handling:</b> Incorporates exception handling to gracefully manage errors and ensure the reliability of the application, enhancing its robustness.</li>





<div align="center">
  <a href="https://github.com/Ch3rryl/cbf-api-employeemgt">
    <img src="src/Images/swagger-view.png"  alt="swagger-board" min-width="700">

  </a>
</div>

<!-- Here's a blank template to get started: To avoid retyping too much info. Do a search and replace with your text editor for the following: `github_username`, `repo_name`, `twitter_handle`, `linkedin_username`, `email_client`, `email`, `project_title`, `project_description` -->

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [Java](https://img.shields.io/badge/Java-<VERSION>-blue)
* [Spring Boot](https://img.shields.io/badge/Spring%20Boot-<VERSION>-green)
* [Jackson](https://img.shields.io/badge/Jackson-<VERSION>-orange)
* [Maven](https://img.shields.io/badge/Maven-<VERSION>-blue)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

Ensure you have the following installed:

1. [JDK 17](https://learn.microsoft.com/en-gb/java/openjdk/download#openjdk-17) (or higher)
2. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
3. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

### Installation / Setup

1. Clone the Repository

```sh
git clone git@github.com:Ch3rryl/cbf-api-employeemgt.git
cd cbf-api-employeemgt
```


<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Usage

To start the Employee Management API in VS Code, press `F5` or tap the 'Play' icon for the `cbf-api-employeemgt` app in the Spring Boot Dashboard.

Alternatively, to start the Employee Management API from the terminal, run the following command:

```sh
./mvnw spring-boot:run
```

Or on Windows:

```cmd
mvnw spring-boot:run
```

You should see console output similar to the following (press `Ctrl + C` to exit):

```sh

[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot:3.1.4:run (default-cli) > test-compile @ api-assessment >>>
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ api-assessment ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 2 resources from src/main/resources to target/classes
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ api-assessment ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ api-assessment ---
[INFO] skip non existing resourceDirectory /Users/cherryl/Documents/coding/cbf_java/cbf-api-employeemgt/src/test/resources
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ api-assessment ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] <<< spring-boot:3.1.4:run (default-cli) < test-compile @ api-assessment <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot:3.1.4:run (default-cli) @ api-assessment ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.4)

2024-02-08T12:15:42.559Z  INFO 63995 --- [  restartedMain] com.cbfacademy.apiassessment.App         : Starting App using Java 21.0.1 with PID 63995 (/Users/cherryl/Documents/coding/cbf_java/cbf-api-employeemgt/target/classes started by cherryl in /Users/cherryl/Documents/coding/cbf_java/cbf-api-employeemgt)
2024-02-08T12:15:42.562Z  INFO 63995 --- [  restartedMain] com.cbfacademy.apiassessment.App         : No active profile set, falling back to 1 default profile: "default"
2024-02-08T12:15:42.623Z  INFO 63995 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2024-02-08T12:15:42.623Z  INFO 63995 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2024-02-08T12:15:43.549Z  INFO 63995 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2024-02-08T12:15:43.559Z  INFO 63995 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-02-08T12:15:43.560Z  INFO 63995 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.13]
2024-02-08T12:15:43.607Z  INFO 63995 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-02-08T12:15:43.608Z  INFO 63995 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 984 ms
src/main/resources/data/data.json
2024-02-08T12:15:44.179Z  INFO 63995 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2024-02-08T12:15:44.204Z  INFO 63995 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2024-02-08T12:15:44.216Z  INFO 63995 --- [  restartedMain] com.cbfacademy.apiassessment.App         : Started App in 1.913 seconds (process running for 2.353)

```

Open your browser and navigate to `http://localhost:8080`.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Author

👤 **Cherryl Sinclair**

* Github: [@ch3rryl](https://github.com/ch3rryl)

## Show your support

Give a ⭐️ if this project helped you!

***