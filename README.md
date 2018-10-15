[![Build Status](https://travis-ci.org/rkonovalov/advancedlogger.svg?branch=master)](https://travis-ci.org/rkonovalov/jsonignore)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.rkonovalov/advancedlogger/badge.svg?style=blue)](https://maven-badges.herokuapp.com/maven-central/com.github.rkonovalov/advancedlogger/)
[![Javadocs](http://www.javadoc.io/badge/com.github.rkonovalov/advancedlogger.svg)](http://www.javadoc.io/doc/com.github.rkonovalov/advancedlogger)

# Advanced logger
Advanced logger expands opportunities of standard Log4J logger

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

## Examples
In next example you can see typical initialization and usage of AdvancedLogger

### Initialization
```java
public class Example {
    public static final AdvancedLogger logger = new AdvancedLogger(Example.class);

    public static void main(String[] args) {
        logger.info(() -> "Application started");
        //Do some stuff....
        logger.info(() -> "Application ended");
    }
}
```

### Log simple messages
```java
public class Example {
    public static final AdvancedLogger logger = new AdvancedLogger(Example.class);

    public static void main(String[] args) {
        
        //Log info string
        logger.info(() -> "Hello");
        
        //Log info strings
        logger.info(() -> "Hello", () -> "World");
        
        //Or
        logger.info(() -> "Hello")
              .info(() -> "World");
        
        //Log in different log levels
        logger.info(() -> "Info message")
                .debug(() -> "Debug message")
                .error(() -> "Error message");
       
    }
}
```

### Log throwable messages
```java
public class Example {
    public static final AdvancedLogger logger = new AdvancedLogger(Example.class);

    public static void main(String[] args) {
        
        //Log error message
        logger.error(() -> new ThrowableObject("Some error", new RuntimeException())); 
        
    }
}
```

## Version 1.0.0
Initial release
