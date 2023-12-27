package com.adiFirstProject.config;

import com.adiFirstProject.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<UserDto, UUID>{


}
