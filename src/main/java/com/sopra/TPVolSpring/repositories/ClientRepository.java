package com.sopra.TPVolSpring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.TPVolSpring.model.Client;
import com.sopra.TPVolSpring.model.Passager;

public interface ClientRepository extends JpaRepository<Client, Long> {
	

	@Query("select c from Client c left join fetch c.reservations where c.id_client=:idClient")
	Optional<Client> findCustomByIdWithReservation(@Param("idClient") Long a);
	

}