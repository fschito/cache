package it.sidesoft.corso.restfulapp.service;

import it.sidesoft.corso.restfulapp.dto.PersonaDto;
import it.sidesoft.corso.restfulapp.dto.ProgettoDto;
import it.sidesoft.corso.restfulapp.mapper.ProgettoDtoMapper;
import it.sidesoft.corso.restfulapp.model.Persona;
import it.sidesoft.corso.restfulapp.model.Progetto;
import it.sidesoft.corso.restfulapp.repository.ProgettoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProgettoService {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ProgettoRepository progettoRepository;

    @Autowired
    private ProgettoDtoMapper progettoDtoMapper;

    public List<ProgettoDto> findAll() {
        log.info("Recupero tutti i progetti");
        List<Progetto> progettoList = progettoRepository.findAll();
        return progettoDtoMapper.toDto(progettoList);
    }

    public ProgettoDto save(ProgettoDto dto) {
        log.info(String.format("Salvo il progetto: %s", dto.toString()));
        Progetto entity = progettoDtoMapper.toEntity(dto);
        entity = progettoRepository.save(entity);
        return progettoDtoMapper.toDto(entity);
    }

    public Optional<ProgettoDto> findById(Long id) {
        log.info(String.format("Recupero progetto con id:%s", id));
        Optional<Progetto> progetto = progettoRepository.findById(id);
        if (progetto.isPresent()) {
            ProgettoDto dto1 = progettoDtoMapper.toDto(progetto.get());
            return Optional.of(dto1);
        }
        return Optional.empty();
    }
}
