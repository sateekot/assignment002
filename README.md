Technologies and Tools
======================
1. Java8
2. Spring, Spring JPA, SpringBoot
3. In-memory H2 database.
4. Maven
5. Intellij
6. JUnit


Implemented APIs
================
I have taken car domain with carId, model name, manufacturer year, and price.
    CarId - Primary Key.

1. /insert - POST - takes car details and insert into database.
2. /search - Get - takes car id and get the corresponding car details from database.
3. /list - Get - Gets the list of cars with the information.

Instructions to Run the application
===================================

1. Go to assignment002 directory.
2. Run below command
    mvn clean install
3. Run the application by using any of the process.
    a. mvn spring-boot:run
    b. Right click on Assignment002Application and Run as.
    c. java - jar assignment002-0.0.1-SNAPSHOT.jar from target directory.
4. Try below apis from Postman tool.
    a. Insert API
    
        POST /insert HTTP/1.1
        Host: localhost:8080
        Content-Type: application/json
        User-Agent: PostmanRuntime/7.19.0
        Accept: */*
        Cache-Control: no-cache
        Postman-Token: f6d36ff3-5c3c-48a5-9f33-f3b3f6bcefee,92cf0af5-1156-49f2-b4ee-d0838df0a2f6
        Host: localhost:8080
        Accept-Encoding: gzip, deflate
        Content-Length: 75
        Connection: keep-alive
        cache-control: no-cache

        {
        "carId":1,
        "modelName":"BMW",
        "manufactureYear":2020,
        "price":20000
        }

    b. Search API
    
        GET /search?Id=2 HTTP/1.1
        Host: localhost:8080
        User-Agent: PostmanRuntime/7.19.0
        Accept: */*
        Cache-Control: no-cache
        Postman-Token: 2f5106ae-274c-49c9-b0ea-8b500c2057ad,9e43ddb7-450e-4e33-8ac6-8882dc291a21
        Host: localhost:8080
        Accept-Encoding: gzip, deflate
        Connection: keep-alive
        cache-control: no-cache

    c. List API
    
        GET /search?Id=2 HTTP/1.1
        Host: localhost:8080
        User-Agent: PostmanRuntime/7.19.0
        Accept: */*
        Cache-Control: no-cache
        Postman-Token: 2f5106ae-274c-49c9-b0ea-8b500c2057ad,9e43ddb7-450e-4e33-8ac6-8882dc291a21
        Host: localhost:8080
        Accept-Encoding: gzip, deflate
        Connection: keep-alive
        cache-control: no-cache
