package it.sidesoft.corso.restfulapp.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDto {

    private Long id;
    private String nome;
    private String cognome;
    private ProgettoDto progetto;

    @Override
    public String toString() {
        return "PersonaDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
