package com.example.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class KafkaProducerExample {

	public static void main(String[] args) {

		Properties properties = new Properties();
		try (FileInputStream fis = new FileInputStream("src/main/resources/kafka.properties")) {
			properties.load(fis);
		} catch (IOException e) {
			System.err.println("Erro ao carregar as propriedades: " + e.getMessage());
			return;
		}

		// Criar um produtor Kafka
		try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
			String topic = "meu-topico";
			String key = "chave";
			String value = "Olá, Kafka!";

			// Enviar mensagem
			ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
			producer.send(record, (metadata, exception) -> {
				if (exception == null) {
					System.out.printf("Mensagem enviada com sucesso para o tópico %s, partição %d, offset %d%n",
							metadata.topic(), metadata.partition(), metadata.offset());
				} else {
					System.err.println("Erro ao enviar mensagem: " + exception.getMessage());
				}
			});

			System.out.println("Mensagem enviada. Aguardando callback...");
		} catch (Exception e) {
			System.err.println("Erro no produtor Kafka: " + e.getMessage());
		}
	}
}
