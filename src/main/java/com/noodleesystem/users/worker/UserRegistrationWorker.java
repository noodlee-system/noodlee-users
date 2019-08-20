package com.noodleesystem.users.worker;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noodleesystem.users.model.UserApiModel;
import com.noodleesystem.users.model.UserRegistrationCommand;
import com.noodleesystem.users.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
class UserRegistrationWorker {
    private ObjectMapper mapper;

    @Autowired
    private UserRepository usersRepository;

    public UserRegistrationWorker() {
        this.mapper = new ObjectMapper();
    }

    @RabbitListener(queues = "user_registration_queue")
    public void receive(String userJsonString) throws InterruptedException {
        try {
            UserRegistrationCommand registeredUser = mapper.readValue(userJsonString, UserRegistrationCommand.class);

            registerNewUser(registeredUser);
        } catch (JsonParseException ex) {
            System.err.println("JSON Parsing error!");
        } catch (JsonMappingException ex) {
            System.err.println("JSON Mapping error!");
        } catch (IOException ex) {
            System.err.println("IOException exception!");
        }
    }

    private void registerNewUser(UserRegistrationCommand registeredUser) throws InterruptedException {
        UserApiModel newUser = new UserApiModel();

        newUser.setUserName(registeredUser.getUsername());
        newUser.setFirstName(registeredUser.getFirstname());
        newUser.setLastName(registeredUser.getLastname());
        newUser.setEmail(registeredUser.getEmail());
        newUser.setCountry(registeredUser.getCountry());

        usersRepository.save(newUser);
    }
}
