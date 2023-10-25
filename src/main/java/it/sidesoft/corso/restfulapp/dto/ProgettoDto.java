package it.sidesoft.corso.restfulapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProgettoDto {

    private Long id;
    private String titolo;
    private String descrizione;
    private List<PersonaDto> persone;

    @Override
    public String toString() {
        return "ProgettoDto{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
