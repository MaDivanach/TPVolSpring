package com.sopra.TPVolSpring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.TPVolSpring.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	@Query("select r from Reservation r left join fetch r.client c where c.id_client=:client")
	Optional<List<Reservation>> findAllCustomWithClient(@Param("client") Long client);

}
