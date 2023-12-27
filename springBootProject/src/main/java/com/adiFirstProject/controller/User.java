package com.adiFirstProject.controller;

import com.adiFirstProject.config.CustomerRepository;
import com.adiFirstProject.model.UserDto;
import com.adiFirstProject.model.UserDtoEnvelope;
import com.adiFirstProject.model.UserPutDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/users")
public class User {

    private final CustomerRepository customerRepository;

    public User(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public UserDtoEnvelope getCustomers() {

        List<UserDto> allUsers = customerRepository.findAll();
        return new UserDtoEnvelope(allUsers, "OK", LocalDateTime.now().toString(),  allUsers.size());
    }

    @GetMapping("{userId}")
    public UserDto getCustomer(@PathVariable("userId") UUID id) {
        return customerRepository.getReferenceById(id);
    }

    @PostMapping
    public UserDto addCustomer(@RequestBody UserPutDto request) {

        UserDto customer = new UserDto();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);

        return customer;
    }

    @DeleteMapping("{userId}")
    public void deleteCustomer(@PathVariable("userId") UUID id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("{userId}")
    public UserDto editCustomer(@PathVariable("userId") UUID id, @RequestBody UserPutDto request) {
        UserDto userDto = customerRepository.findAllById(List.of(id)).get(0);
        userDto.setName(request.name());
        userDto.setEmail(request.email());
        userDto.setAge(request.age());

        return userDto;
    }
}
