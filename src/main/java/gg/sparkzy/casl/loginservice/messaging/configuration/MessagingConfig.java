package gg.sparkzy.casl.loginservice.messaging.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
	
	@Value("${messaging.queue}")
	public String USER_QUEUE;	
	
	@Value("${messaging.exchange}")
	public String USER_EXCHANGE;	
	
	@Value("${messaging.routing_key}")
	public String USER_ROUTINGKEY;

	@Bean
	public Queue userQueue() {
		return new Queue(USER_QUEUE);
	}
	
	@Bean
	public TopicExchange userExchange() {
		return new TopicExchange(USER_EXCHANGE);
	}
	
	@Bean
	public Binding userBinding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(USER_ROUTINGKEY);
	}
	
	@Bean
	public Jackson2JsonMessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}

}
