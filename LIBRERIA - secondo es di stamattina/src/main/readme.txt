Il progetto conterrà le informazioni riguardanti una libreria con l'elenco dei libri e degli autori e delle case editrici

creeremo le entità per savare i dati nel database
creeremo i dao per gestire le operazioni crud
creeremo i servizi per fare tutte le operazioni di collegamento con il db.

a questo punto comincio a creare le classi di gestione mettndole in package appositi


Per quanto riguarda spring le Entità sono le stesse viste con JPA classi annotate con @Entity

I dao sono delle classi Denominate Repository che contengono i metodi per fare le operazioni CRUD
i dao sono annotati con annotazione @Repository
il Dao estende un interfaccia spring chiamata JpaRepository

I servizi invece sono classi annotate co @Service e che contengono i metodi per fare le operazioni di business

I controller sono classi annotate con @RestController e contengono i metodi per fare le operazioni di gestione delle richieste http


Nella scrittura dell'entity uso lomboc ed in particolare le annotazioni

Annotazioni di Lombok
@NoArgsConstructor (genera un costruttore senza argomenti)
@AllArgsConstructor (genera un costruttore con tutti gli argomenti)
@Data (genera i metodi getter e setter toString equals e hashcode)

@Entity
@Table(name = "casi_editrici")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CasaEditrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String indirizzo;
    private String citta;
    private String provincia;
    private String cap;
}

un dao è un repositori definito come interfaccia, bisogna estendere un interfaccia di spring chiamata JpaRepository
essa ha due parametri il tipo di entità e il tipo di chiave primaria

package it.epicode.libreria.dao;

import it.epicode.libreria.entita.CasaEditrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasaEditriceRepository extends JpaRepository<CasaEditrice, Long> {
}


Fatto l'entity e creato il repository posso creare le classi di tipo service le quali utilizeranno il repository
per fare le operazioni di CRUD, in esse verranno aggiunte tutte le logiche per controllare la validità dei dati


Metodi utili del repository
findAll() ritorna tutti gli elementi
findById() ritorna un singolo elemento
save() salva un elemento, nel caso in cui l'oggetto da salvare ha la chiave primaria valorizzata
        allora fa un update (modifica il record) altrimenti fa un insert (crea un nuovo record
deleteById() cancella un record dato l'id
delete() cancella tutti gli elementi


per testare il codice invece di creare delle classi contenenti il metodo statico main si usa una classe denominarta runner

il runner ha queste caratteristiche

1. è annotato con @Component
2. Deve implementare l'interfaccia CommandLineRunner
3. deve implementare il metodo run ( è un override dell'interfaccia ComandLineRunner)


all'interno del metodo run potete inserire tutto il codice che volete far eseguire all'avvio dell'applicazione


per collegarsi a db bisogna aggiungere dei parametri che consentono il collegamento
per far questo esiste un file definito
application.properties dentro la cartella resources in cui inserire questi parametri
esso è l'equivalente del file persistence.xml

esempio
spring.jpa.hibernate.ddl-auto=create-drop
spring.sql.init.mode=always
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_URL}
spring.datasource.password=${DB_PWD}

dove bisogna sostituire ${DB_URL} ${DB_URL} {DB_PWD} con quelli relativi al proprio database

nel caso della proprietà spring.jpa.hibernate.ddl-auto

avete a disposizione 3 valori

create-drop ad ogni lancio del main viene ricreato da zero il db, le vecchie tabelle vengono eliminate e vengono ricreate
create se il db non esiste viene creato ma ad ogni lancio azzera tutti i dati
update se il db non esiste viene creato ma non azzera i dati

in ogni caso tutte e 3 i valori vi creano il db se non esiste e aggorna le tabelle se
avete fatto delle modifiche ai campi di un entity


per eseguire l'applicativo spring cerco la classe Application generata da initializer e la mando in esecuzione

per testare il funzionamento possiamo creare una classe runner che va a sostituire il Main

