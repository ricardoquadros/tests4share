# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.0/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.0/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.0/reference/web/servlet.html)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/3.4.0/reference/messaging/kafka.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/3.4.0/reference/actuator/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.


# Executando o Projeto

1. Certifique-se de que o Kafka está rodando localmente e o tópico example_topic foi criado.

* Para criar o tópico, use o comando:   
> kafka-topics --create --topic example_topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1   

2. Execute o projeto Spring Boot.

3. Envie uma mensagem para o tópico usando o comando Kafka CLI:   
> kafka-console-producer --topic example_topic --bootstrap-server localhost:9092

Digite uma mensagem e pressione Enter.

4. Observe no console do Spring Boot a mensagem recebida.   

# Expansão

* Adicionar tratamento de erros com @KafkaHandler.   
* Integrar com um banco de dados para persistir as mensagens.   
* Configurar autenticação SASL/SSL caso o Kafka seja seguro.   

