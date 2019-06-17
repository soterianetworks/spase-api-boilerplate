# Overview

A simple Spring application to showcase a standalone service provider.

# Show Case

Endpoint | Feature  | Description
---|---|---
/health | Spring Application Health | by Spring Actuator  
/info | Spring Application Info | by Spring Actuator 
/health | show 'world' | Under Spase Security Protection
/foo | show 'bar' | Under Spase Security Protection
/my-profile | show current user's profile | Under Spase Security Protection

# Get Started

> Before start, please make sure the following are installed on your local machine. 
> * docker & docker-compose
> * java 
> * gradle 

1. Start Redis

```
cd src/test/env
docker-compose up -d
```

2. Start the Application

```
gradle clean bootRun -PjvmArgs="-Dspring.profiles.active=development"
```

3. Examine it 

In a browser, such as Chrome, enter the following urls and check the responses.

* http://127.0.0.1:8080/health
* http://127.0.0.1:8080/info

When you enter the following url, it shows 401 error.

* http://127.0.0.1:8080/hello

# Appendix - Spring Configuration

> src/main/resources/application-development.yml

```
spase.client:
  gatewayHost: ask-provider-for-gateway-host
```
