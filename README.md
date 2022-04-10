TEAMWAY SHIFT API
--------------------
[comment]: <> (Minimal [Spring Boot]&#40;http://projects.spring.io/spring-boot/&#41; sample app.)

Build a REST application from scratch that could serve as a work planning service.



## Business requirements:

A worker has shifts
A shift is 8 hours long
A worker never has two shifts on the same day
It is a 24 hour timetable 0-8, 8-16, 16-24


Preferably write a couple of units tests.




## Requirements

For building and running the application you need:

- [JDK 11](https://download.oracle.com/otn/java/jdk/11.0.13%2B10/bdde8881e2e3437baa70044f884d2d67/jdk-11.0.13_windows-x64_bin.exe)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.teamway.app.WorkPlanningServiceApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

### License

Apache License, Version 2.0
