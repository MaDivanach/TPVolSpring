package repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Aeroport;

public interface AeroportRepository extends JpaRepository<Aeroport, Long> {
	
	  @Query("select a from Aeroport a left join fetch a.arrivees where a.id=:numeroAeroport") 
	  Optional<Aeroport> findCustomByIdWithVolArrive(@Param("numeroAeroport") Long id); 
	 
	  @Query("select a from Aeroport a left join fetch a.departs where a.id=:numeroAeroport") 
	  Optional<Aeroport> findCustomByIdWithVolDepart(@Param("numeroAeroport") Long id); 
	   
	  @Query("select a from Aeroport a left join fetch a.escales e left join fetch e.key.vol where a.id=:numeroAeroport") 
	  Optional<Aeroport> findCustomByIdWithVolEscale(@Param("numeroAeroport") Long id); 
	   
	  @Query("select a from Aeroport a left join fetch a.aeroportVille v left join fetch v.key.ville where a.id=:numeroAeroport") 
	  Optional<Aeroport> findCustomByIdWithVille(@Param("numeroAeroport") Long id); 

}
