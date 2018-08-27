package com.sopra.TPVolSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.TPVolSpring.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
