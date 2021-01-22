## Prerequisites
```
   Java 8 or later
```

## Running the application using a generated executable jar
#### Generate executable jar

Use gradle to compile and create the executable jar

```
    > cd [root project directory]
    > gradlew bootJar
```

#### Location of the generated jar
```
    [root project directory]\build\libs
```

#### How to run

```
    - cd [root project directory]\build\libs
    - java -jar card-game-0.0.1-SNAPSHOT.jar

```
##### Note:

Default server port is 8080.

If you want to use a different port, add the server.port argument and specify the port you want to use

```
    - java -jar card-game-0.0.1-SNAPSHOT.jar --server.port=[your port number]

```

## Using gradle to run the application 

```
    > cd [root project directory]
    > gradlew bootRun
```

#### Note:

Default server port is 8080.

If you want to use a different port, just change the following line on "application.properties" file under [root project directory]\src\main\resources

from

```
    server.port=8080  
```
to 
	 
```	 	
    server.port=[your port number]
```

## Use Swagger UI to test the endpoints

```
    http://localhost:8080/swagger-ui/index.html
```

or if you ar using a different port number

```
    http://localhost:[your port number]/swagger-ui/index.html
```

Documentation on the endpoints and instructions can also be found there
