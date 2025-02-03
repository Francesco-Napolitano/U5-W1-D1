package it.epicode.libreria.runners;

import it.epicode.libreria.entita.CasaEditrice;
import it.epicode.libreria.servizi.CasaEditriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreaDbRunner implements CommandLineRunner {
    @Autowired
    private CasaEditriceService casaEditriceService;

    @Override
    public void run(String... args) throws Exception {
        CasaEditrice casaEditrice = new CasaEditrice();
        casaEditrice.setNome("Mondadori");
        casaEditrice.setIndirizzo("via Roma 1");
        casaEditrice.setCitta("Roma");

        // equivalente del casaEditriceDao.save(casaEditrice)
        casaEditriceService.saveCasaEditrice(casaEditrice);
        System.out.println("Casa editrice creata con successo");

    }
}
