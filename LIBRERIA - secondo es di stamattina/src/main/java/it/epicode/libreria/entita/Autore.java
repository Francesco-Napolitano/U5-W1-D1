package it.epicode.libreria.entita;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "autori")
@AllArgsConstructor
@NoArgsConstructor
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String nazionalita;
    private String dataNascita;
    private String dataMorte;
    private String biografia;
}
