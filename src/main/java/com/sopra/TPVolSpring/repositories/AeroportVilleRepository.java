package com.sopra.TPVolSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.TPVolSpring.model.AeroportVille;
import com.sopra.TPVolSpring.model.AeroportVillePK;

public interface AeroportVilleRepository extends JpaRepository<AeroportVille, AeroportVillePK> {
	
}
