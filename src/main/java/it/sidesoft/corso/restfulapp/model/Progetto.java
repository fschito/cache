package it.sidesoft.corso.restfulapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "progetto")
public class Progetto {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String titolo;

    @Column
    private String descrizione;

    @OneToMany(mappedBy = "progetto", fetch = FetchType.LAZY)
    private List<Persona> persone;
}
