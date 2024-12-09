package com.example.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerExample {

	public static void main(String[] args) {

		Properties properties = new Properties();
		try (FileInputStream fis = new FileInputStream("src/main/resources/kafka.properties")) {
			properties.load(fis);

			// Adiciona propriedades específicas para o consumidor
			properties.put("group.id", "meu-grupo-consumidor");
			properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		} catch (IOException e) {
			System.err.println("Erro ao carregar as propriedades: " + e.getMessage());
			return;
		}

		// Criar o consumidor Kafka
		try (Consumer<String, String> consumer = new KafkaConsumer<>(properties)) {
			String topic = "meu-topico";

			// Inscrever-se no tópico
			consumer.subscribe(Collections.singletonList(topic));
			System.out.println("Consumidor iniciado. Aguardando mensagens...");

			// Loop para consumir mensagens
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));

				for (ConsumerRecord<String, String> record : records) {
					System.out.printf("Recebida mensagem: chave = %s, valor = %s, tópico = %s, partição = %d, offset = %d%n",
							record.key(), record.value(), record.topic(), record.partition(), record.offset());
				}
			}
		} catch (Exception e) {
			System.err.println("Erro no consumidor Kafka: " + e.getMessage());
		}
	}
}
