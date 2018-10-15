[![Build Status](https://travis-ci.org/rkonovalov/advancedlogger.svg?branch=master)](https://travis-ci.org/rkonovalov/jsonignore)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.rkonovalov/advancedlogger/badge.svg?style=blue)](https://maven-badges.herokuapp.com/maven-central/com.github.rkonovalov/advancedlogger/)
[![Javadocs](http://www.javadoc.io/badge/com.github.rkonovalov/advancedlogger.svg)](http://www.javadoc.io/doc/com.github.rkonovalov/advancedlogger)

# Advanced logger
Advanced logger expands features of standard Log4J logger

# Getting started
For using this module you need to follow for next steps

## Importing dependency
If you are using Maven you need add next dependency
```xml
<dependency>
  <groupId>com.github.rkonovalov</groupId>
  <artifactId>advancedlogger</artifactId>
  <version>1.0</version>
</dependency>
```
If you are using another build automation tool, you can find configuration string by this URL:
https://search.maven.org/artifact/com.github.rkonovalov/advancedlogger/1.0.0/jar

# Description
Usually when are you using Log4J logging you should to use next code
```java
public class Example {
    private static final Logger logger = Logger.getLogger(Example.class);

    public static void main(String[] args) {
        
        logger.info("Application started");
        //Do some stuff....
        logger.info("Application ended");
    }
}
```

But sometimes, specifically in high load applications, we should to use next code
```java
public class Example {
    private static final Logger logger = Logger.getLogger(Example.class);

    public static void main(String[] args) {
        
         if(logger.isInfoEnabled())
             logger.info("Application started");
                
         //Do some stuff....
         if(logger.isDebugEnabled())
             logger.debug("Some debug message");
        
         
         try {            
             //Do some stuff
             //...
              } catch (Exception e) {
                if(logger.isErrorEnabled())
                    logger.error("Some error", e);
              }  
              
        
         //Do some stuff....
         //Logging multiple messages
           if(logger.isInfoEnabled()) {
               logger.info("First message"); 
               logger.info("Second message"); 
               logger.info("Third message");                
           }
           
           //Or logging multiple messages as one
           if(logger.isInfoEnabled()) {
               logger.info("First message" + "Second message" + "Third message"); 
           }
    }
}
```
Every time we need to check that some log level is enabled. And we are forced to write some excessive code.

AdvancedLogger Intended to solve this problems. It auto checks log level before call log function. If log level is not enabled AdvancedLogger won't to call log function.

## Examples
In the next example you can see typical initialization and usage of AdvancedLogger

### Initialization
```java
public class Example {
    private static final AdvancedLogger logger = new AdvancedLogger(Example.class);

    public static void main(String[] args) {
        
        logger.info(() -> "Application started");//No need to check log level anymore
        //Do some stuff....
        logger.info(() -> "Application ended");
    }
}
```

### Log simple messages
```java
public class Example {
    private static final AdvancedLogger logger = new AdvancedLogger(Example.class);

    public static void main(String[] args) {
        
        //Log info string
        logger.info(() -> "Hello");
        
        //Log info strings
        logger.info(() -> "First message", () -> "Second message", () -> "Third message");
        
        //Or
        logger.info(() -> "First message")
              .info(() -> "Second message")
              .info(() -> "Third message");
        
        //Log in different log levels
        logger.info(() -> "Info message") //calls info log if INFO level is enabled
                .debug(() -> "Debug message") //calls debug log if DEBUG level is enabled
                .error(() -> "Error message"); //calls error log if ERROR level is enabled
       
    }
}
```

### Log throwable messages
```java
public class Example {
    private static final AdvancedLogger logger = new AdvancedLogger(Example.class);

    public static void main(String[] args) {
        
        //Log error message
        logger.error(() -> new ThrowableObject("Some error", new RuntimeException())); 
        
    }
}
```

### Log static events
```java
public class Example {
    private static final AdvancedLogger logger = new AdvancedLogger(Example.class);
    private static final LoggerEvent currentTime = () -> "Current time: " + new Date().toString();

    public static void main(String[] args) {
        
        //Log info current time
        logger.info(currentTime);
        
        //Do some stuff
        
        //Log info current time
        logger.info(currentTime);
    }
}
```

#### Result
```text
2018-10-15 12:09:31.271 INFO [main] Example Current time: Mon Oct 15 12:09:31 EDT 2018
...
...
2018-10-15 12:09:31.271 INFO [main] Example Current time: Mon Oct 15 12:09:32 EDT 2018
```

## Version 1.0.0
Initial release
