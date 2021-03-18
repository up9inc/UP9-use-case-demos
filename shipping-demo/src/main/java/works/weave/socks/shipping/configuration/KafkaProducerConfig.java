package works.weave.socks.shipping.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import works.weave.socks.shipping.entities.Shipment;

@Configuration
public class KafkaProducerConfig {
     @Value("${spring.kafka.bootstrap-servers}") // (1)
     private String brokerAsString;
 
     @Bean
     public ProducerFactory<Integer, String> producerFactory() {
          return new DefaultKafkaProducerFactory<>(producerConfigs());
     }

     @Bean
     public ProducerFactory<String, Shipment> greetingProducerFactory() {
         Map<String, Object> configProps = producerConfigs();
         configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
         configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
         return new DefaultKafkaProducerFactory<>(configProps);
     }
 
     @Bean
     public KafkaTemplate<String, Shipment> greetingKafkaTemplate() {
         return new KafkaTemplate<>(greetingProducerFactory());
     }

     @Bean
     public Map<String, Object> producerConfigs() {
          Map<String, Object> props = new HashMap<>();
          props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerAsString);
          props.put(ProducerConfig.RETRIES_CONFIG, 0);
          props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
          props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
          props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
          props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
          props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
          return props;
      }

     @Bean
     public KafkaTemplate<Integer, String> kafkaTemplate() {
          return new KafkaTemplate<Integer, String>(producerFactory());
     }
}