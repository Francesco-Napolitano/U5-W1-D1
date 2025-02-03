package it.epicode.libreria.entita;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "casi_editrici")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CasaEditrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // crea una colonna nome di tipo varchar(100) dentro il db
    @Column(length = 100)
    private String nome;
    private String indirizzo;
    private String citta;
    private String provincia;
    private String cap;
}
