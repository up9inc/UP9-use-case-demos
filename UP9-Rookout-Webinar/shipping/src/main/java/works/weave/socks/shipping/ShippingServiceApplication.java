package works.weave.socks.shipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import works.weave.socks.shipping.entities.Shipment;

@SpringBootApplication
public class ShippingServiceApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ShippingServiceApplication.class, args);
    }

	@KafkaListener(topics = "shipping-task")
	public void listen(Shipment foo) {
        System.out.println("Received: " + foo);
        
		if (foo.getName().startsWith("fail")) {
			throw new RuntimeException("failed");
		}
	}
}
