package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Passager;

public interface PassagerRepository extends JpaRepository<Passager, Long> {

	@Query("select p from Passager p left join fetch p.reservations where p.idPassager=:idpassager")
	Optional<Passager> findCustomByIdWithReservation(@Param("idpassager") Long idPassager);

}