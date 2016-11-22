# zipcode-costumer-services
created by drsantos20 (Daniel Santos)

Technologies used:
- Maven (for management dependency)
- Spring Boot (container application)
- Junit (for tests)
- Java8
- Mock (for metadata information)
- Lombok (maybe you will be need to add an configuration to work on your ide development see the walkthrough guide forward)

This operation involves the following steps (1-create, and 2-get) and can be executed defined below:


#### Create

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{"id" : "00001", "street":"Rua 2","number":"02","zipCodeNumber":"01202001","city":"Abc","state":"RJ"}' http://localhost:8080/
```


#### Get

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{"zipCodeNumber":"09994144"}' http://localhost:8080/
```

Walkthrough
- Configure Lombok

```sh
Download the jar -> lombok-1.14.6.jar.
Using command prompt go to java installed directory and type

java -jar ${your_jar_path}\lombok-1.14.6.jar.
Here ${your_jar_path} is your lombok-1.14.6.jar jar store directory.
After this it will prompt for Eclipse already installed in your system and you need to select where you want to integrate.
After this you need to open eclipse.ini file and make entry below

-vmargs
as
-Xbootclasspath/a:lombok.jar
-javaagent:lombok.jar

see more in http://stackoverflow.com/questions/22310414/how-to-configure-lombok-in-eclipse-luna

```