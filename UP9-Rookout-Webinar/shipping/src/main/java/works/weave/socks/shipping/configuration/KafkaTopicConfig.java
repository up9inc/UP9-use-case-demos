package works.weave.socks.shipping.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {
 
 @Value("${spring.kafka.bootstrap-servers}")
 private String brokerAsString;
 
 @Bean
 public KafkaAdmin admin() {
   Map<String, Object> configs = new HashMap<>();
   configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, brokerAsString);
   return new KafkaAdmin(configs);
 }

 @Bean
 public NewTopic topic1() {
   return new NewTopic("foo", 10, (short) 2);
 }
}