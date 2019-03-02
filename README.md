# Currency Conversion Service
[![Build Status](https://travis-ci.com/samair/conversionService.svg?branch=master)](https://travis-ci.com/samair/conversionService)

A simple currency conversion service. 

### Architecture

![AltText](https://github.com/samair/TheMicroservicesJourney/blob/master/First_Microservice.png)


### Participating microservices

[Forex Exchange] : A basic microservice (Spring-boot) , which registers to Erureka and provides endpoints to get exchange rates of various types of currencies.

[Conversion Serivce] : A basic microservice (Spring-boot) , which registers to Erureka and provides endpoints used by UI to convert a particular currency to another using [Forex Exchange] service.

[Eureka Server]:It is service registry and loadbalancer.

Multiple instances of [Forex Exchange] micro service are started and [Conversion Serivce] asks [Eureka Server] to redirect it to relavant instance of [Forex Exchange] micro service


### User Interface


![AltText](https://github.com/samair/conversionService/blob/master/Screenshot%202019-03-02%20at%2012.01.26%20AM.png)

[Forex Exchange]: <https://github.com/samair/Forex-Exchange-service.git>

[Conversion Serivce]: <https://github.com/samair/conversionService.git>

[Eureka Server]: <https://github.com/samair/eurekaServer>
