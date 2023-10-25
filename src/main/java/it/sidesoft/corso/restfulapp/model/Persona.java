package it.sidesoft.corso.restfulapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "progetto_id", foreignKey = @ForeignKey(name = "FK_persona_progetto"))
    private Progetto progetto;
}
