package com.sopra.TPVolSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.TPVolSpring.model.User;

public interface UsersRepository extends JpaRepository<User, String>{

	
}
