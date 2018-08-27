package com.sopra.TPVolSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.TPVolSpring.model.Escale;
import com.sopra.TPVolSpring.model.EscalePK;

public interface EscaleRepository extends JpaRepository<Escale, EscalePK>{

}
