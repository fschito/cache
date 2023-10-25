package it.sidesoft.corso.restfulapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.sidesoft.corso.restfulapp.dto.PersonaDto;
import it.sidesoft.corso.restfulapp.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;


    @Operation(description = "Restituisce tutte le persone")
    @GetMapping("/persone")
    public List<PersonaDto> recuperaTutti() {
        log.info("Chiamato endpoint /persone");
        List<PersonaDto> personaDtoList = personaService.findAll();
        log.info(String.format("Recuperate %s persone", personaDtoList.size()));
        return personaDtoList;
    }

    @Operation(description = "Salva una persona")
    @PostMapping("/persone")
    PersonaDto nuovaPersona(@RequestBody PersonaDto persona) {
        return personaService.save(persona);
    }

    @GetMapping("/persone/{id}")
    PersonaDto recuperaPersona(@PathVariable Long id) {
        return personaService.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Impossibile trovare la persona con id:%s", id)));
    }

    @GetMapping("/persone/nome/{nome}")
    public List<PersonaDto> recuperaPersonaDaNome(@PathVariable String nome) {
        log.info("Chiamato endpoint /persone/nome");
        List<PersonaDto> personaDtoList = personaService.findByNome(nome);
        log.info(String.format("Recuperate %s persone", personaDtoList.size()));
        return personaDtoList;
    }

    @GetMapping("/persone/cognome/{cognome}")
    public List<PersonaDto> recuperaPersonaDaCognome(@PathVariable String cognome) {
        return personaService.findByCognomeContainingIgnoreCase(cognome);
    }
}
