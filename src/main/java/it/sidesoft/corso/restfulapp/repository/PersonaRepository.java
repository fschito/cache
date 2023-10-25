package it.sidesoft.corso.restfulapp.repository;

import it.sidesoft.corso.restfulapp.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    List<Persona> findByNome(String nome);

    List<Persona> findByCognomeContainingIgnoreCase(String cognome);

}
