package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Escale;
import model.EscalePK;

public interface EscaleRepository extends JpaRepository<Escale, EscalePK>{

}
