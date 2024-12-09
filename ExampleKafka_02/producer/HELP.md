# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Official Apache Kafka](https://kafka.apache.org/)
* [Official Apache Kafka Quickstart](https://kafka.apache.org/quickstart)
* [Official Apache Zookeeper Getting Started](https://zookeeper.apache.org/doc/r3.9.3/zookeeperStarted.html)

# Executando o Projeto   
### Este projeto utiliza apenas a lib kafka-clients v3.8.1

1. Certifique-se de que o Apache Kafka está e em execução na porta padrão 9092, crie um tópico.   
> kafka-topics.sh --create --topic meu-topico --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

2. Build do Projeto
> mvn clean package

3. Envie mensagens usando o produtor (KafkaProducerExample)  
> java -cp target/producer-0.1.jar com.example.producer.KafkaProducerExample


