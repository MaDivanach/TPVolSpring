package com.sopra.TPVolSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.TPVolSpring.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	

}
