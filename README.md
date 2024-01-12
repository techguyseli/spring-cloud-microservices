# Spring Cloud Microservices
This project is an overview over microservices using Spring Cloud and Netflix Open Source software.
Done by <strong>Selaiman Kassou</strong> and <strong>Yassin Cherchem</strong>.
# Quick notes
- There are multiple projects with multiple versions of Java and Spring, so you'll have to configure the <strong>JAVA_HOME</strong> environment variable for some projects.
- The main idea with these microservices is Product and Order management.
- There exist 2 business microservices (the products microservice and the order microservice) and 3 technical microservices (reverse proxy, config server and a registration server).
- This project is IDE agnostic, meaning it's not designed for an IDE but rather for a server, so you need to install the proper dependencies to run it well.
- The commands used in this repo are unix-based.
# Projects
- **config.server:** Spring Cloud Config Server.
- **eurekaserver:** Netflix Eureka Server.
- **zuul-server:** Netflix Zuul API Gateway.
- **mproduits:** The products microservice.
- **mcommandes:** The orders microservice. 
- **spring-config-server-repo:** The repository that the config server uses to fetch the configs of every microservice, [access the repo.](https://github.com/techguyseli/spring-config-server-repo)
# Dependencies
- Maven CLI
- JDK 17
- JDK 8 / 1.8
- curl tool
# Launching the microservices
- First clone and **cd** into the repo.
- cd into the config server project, set the JAVA_HOME to JDK 17, and then run the project:
```bash
export JAVA_HOME=/your/java/17/home/path
mvn spring-boot:run
```
- cd into eureka server project, set the JAVA_HOME to JDK 8, and then run the project:
```bash
export JAVA_HOME=/your/java/8/home/path
mvn spring-boot:run
```
- cd into zuul api gateway project, set the JAVA_HOME to JDK 8, and then run the project:
```bash
export JAVA_HOME=/your/java/8/home/path
mvn spring-boot:run
```
- cd into the products microservice, set the JAVA_HOME to JDK 17, and then run the project at port 9001:
```bash
export JAVA_HOME=/your/java/17/home/path
mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=9001'
```
- cd into the orders microservice, set the JAVA_HOME to JDK 17, and then run the project at port 9002:
```bash
export JAVA_HOME=/your/java/17/home/path
mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=9002'
```
And that's it, you're ready to start testing the microservices.
# Testing the microservices
## Products microservice demonstration
- Post example (id is 9):
```bash
curl -v -X POST --json '{"titre":"new product", "description":"this is a newly added product", "image":"/sample/image/image.png", "prix": 200.0}' http://localhost:9103/microservice-produits/products
```
- Put example (changed titre of id 9):
```bash
curl -v -X PUT --json '{"titre":"updated product", "description":"this is a newly added product", "image":"/sample/image/image.png", "prix": 200.0}' http://localhost:9103/microservice-produits/products/9
```
- Get id 9:
```bash
curl -v -X GET http://localhost:9103/microservice-produits/products/9
```
- Delete id 9:
```bash
curl -v -X DELETE http://localhost:9103/microservice-produits/products/9
```
- Get deleted id 9:
```bash
curl -v -X GET http://localhost:9103/microservice-produits/products/9
```
## Orders microservice demonstration
- Post example (id is 1) in the last 10 days:
```bash
curl -v -X POST --json '{"description":"new order", "quantite":3, "date":"2024-01-08", "montant": 200.0, "idProduct":3}' http://localhost:9103/microservice-commandes/commandes
```
- Post example, error: product doesn't exist:
```bash
curl -v -X POST --json '{"description":"new order", "quantite":3, "date":"2024-01-08", "montant": 200.0, "idProduct":66}' http://localhost:9103/microservice-commandes/commandes
```
- Get the orders and it should be there since it fits the time frame which is 10:
```bash
curl -v -X GET http://localhost:9103/microservice-commandes/commandes
```
- Put example (changed date to before 10 days):
```bash
curl -v -X PUT --json '{"description":"new order", "quantite":3, "date":"2023-12-08", "montant": 200.0, "idProduct":3}' http://localhost:9103/microservice-commandes/commandes/1
```
- Get the orders and it should not be there:
```bash
curl -v -X GET http://localhost:9103/microservice-commandes/commandes
```
- Check that the order actually exists:
```bash
curl -v -X GET http://localhost:9103/microservice-commandes/commandes/1
```
- Change the property of days to show 60 days before, then execute the following:
```bash
git add . ; git commit -m "changed commandes properties" ; git push
```
- Refresh the microservice config:
```bash
curl -v -X POST http://localhost:9002/actuator/refresh
```
- It shows the order again:
```bash
curl -v -X GET http://localhost:9103/microservice-commandes/commandes
```
- Delete id 1:
```bash
curl -v -X DELETE http://localhost:9103/microservice-commandes/commandes/1
```
- Get deleted id 1:
```bash
curl -v -X GET http://localhost:9103/microservice-commandes/commandes/1
```
