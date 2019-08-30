package com.noodleesystem.users.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    static final String userRegistrationQueueName = "user_registration_queue";

    @Bean
    public Queue userRegistrationQueue() {
        return new Queue(userRegistrationQueueName);
    }
}

