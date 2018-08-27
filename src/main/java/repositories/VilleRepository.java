package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long> {
	@Query("select v from Ville v left join fetch v.aeroportVille av left join fetch av.key.aeroport where v.id=:id_ville")
	Optional<Ville> findCustomAeroportByIdWithVille(@Param("id_ville") Long id); //custom quand tu cherches un de tes propres objets
}
