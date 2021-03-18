package works.weave.socks.shipping.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

public class KafkaConfiguration {
	// @Bean
	// public SeekToCurrentErrorHandler errorHandler(KafkaTemplate<Object, Object> template) {
	// 	return new SeekToCurrentErrorHandler(
	// 			new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
	// }

	@Bean
	public RecordMessageConverter converter() {
		return new StringJsonMessageConverter();
    }
    
    @Bean
	public NewTopic topic() {
		return new NewTopic("shipping", 1, (short) 1);
	}
}
