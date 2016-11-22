# zipcode-costumer-services
created by drsantos20 (Daniel Santos)

Technologies used:
- Maven (for management dependency)
- Spring Boot (container application)
- Junit (for tests)
- Java8
- Mock (for metadata information)

This operation involves the following steps (1-create, and 2-get) and can be executed defined below:


#### Create

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{"id" : "00001", "street":"Rua 2","number":"02","zipCodeNumber":"01202001","city":"Abc","state":"RJ"}' http://localhost:8080/
```


#### Get

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{"zipCodeNumber":"09994144"}' http://localhost:8080/
```
