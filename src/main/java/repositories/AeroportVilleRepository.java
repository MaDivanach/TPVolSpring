package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.AeroportVille;
import model.AeroportVillePK;

public interface AeroportVilleRepository extends JpaRepository<AeroportVille, AeroportVillePK> {
	
}
