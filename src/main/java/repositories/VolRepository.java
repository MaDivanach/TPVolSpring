package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Vol;

public interface VolRepository extends JpaRepository<Vol, Long> {
	@Query("select v from Vol v left join fetch v.reservations where v.id = :id_vol")
	Optional<Vol> findCustomByIdWithReservation(@Param("id_vol") Long id);

	@Query("select v from Vol v left join fetch v.compagnieAeriennes where v.id = :id_vol")
	Optional<Vol> findCustomByIdWithCompagnieAerienne(@Param("id_vol") Long id);

	@Query("select v from Vol v left join fetch v.escales e left join fetch e.key.aeroport where v.id = :id_vol")
	Optional<Vol> findCustomByIdWithEscale(@Param("id_vol") Long id);
}
