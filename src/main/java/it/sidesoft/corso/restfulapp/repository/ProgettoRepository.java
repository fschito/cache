package it.sidesoft.corso.restfulapp.repository;

import it.sidesoft.corso.restfulapp.model.Progetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgettoRepository extends JpaRepository<Progetto, Long> {
}
