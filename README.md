# UI Automation Framework

This Framework is designed for UI Testing of Web Applications using Java with Selenium WebDriver and TestNG utilizing Maven as dependency management tool. Data Driven Test strategy is used to design and execute tests utilizing TestNG Data Providers.

## Technology Stack

- Java
- Selenium WebDriver
- TestNG
- Maven

## Prerequisites

* [Java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java Dev Kit
* [Maven](https://maven.apache.org/download.cgi) - Dependency Manager
* [IntelliJ IDEA](https://www.jetbrains.com/idea/download) - IDE

## Project Structure

>base: This package base test class

>data: This package contains TestNG Data Provider Classes

>page: This package contains all the web elements and methods of each individual page using Page Factory Design Pattern

>util: This package contains Utility Classes

>config: This package contains application configurations

>testcase: This directory contains test cases of each individual web page

## Getting Started

Following instructions will help you running the project. First of all, checkout/clone this project from master branch on your local machine.

### Installation

Open the project in IntelliJ. Run the following command in Terminal and build the project. It will automatically download all the required dependencies.

```sh
$ mvn clean install
```

If the build is successful. All the required dependencies are installed successfully. But if the build fails, make sure to to resolve all the issues in order to execute tests successfully. Make sure that config.properties path in Test Base Class is set according to your Operating System Environment.

### Execute Tests

Run the following command in Terminal to execute tests.

```sh
$ mvn clean test
```

Or Run the following command in Terminal to execute tests with testng.xml

```sh
$ mvn clean test -DsuiteXmlFile=testng.xml
```

### Test Report

You can find the Surefire HTML reports in the following directory of the Project.

```sh
\target\surefire-reports\index.html
```

Under the surefire-reports directory, open ‘index.html’ file to view reports.
