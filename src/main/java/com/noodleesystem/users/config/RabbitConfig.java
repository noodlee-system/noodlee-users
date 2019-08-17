package com.noodleesystem.users.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    static final String queueName = "users_queue";

    @Bean
    public Queue testQueue() {
        return new Queue(queueName);
    }
}

