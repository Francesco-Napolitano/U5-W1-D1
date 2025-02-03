package it.epicode.libreria.servizi;

import it.epicode.libreria.dao.CasaEditriceRepository;
import it.epicode.libreria.entita.CasaEditrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasaEditriceService {
    @Autowired
    private CasaEditriceRepository casaEditriceRepository;

    public CasaEditrice saveCasaEditrice(CasaEditrice casaEditrice) {
        if(casaEditrice.getNome()==null || casaEditrice.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome non valido");
        }

        // il repository ha a dispozione il metodo save che salva il record nel db
        return casaEditriceRepository.save(casaEditrice);
    }

    public CasaEditrice findById(long id) {
        // il repository ha un metodo findById che cerca un record per chiave primaria e se non lo trova lancia un eccezione

        return casaEditriceRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Casa editrice non trovata"));
    }

    public void deleteCasaEditrice(long id) {
        // il repository ha un metodo deleteById che cancella un record per chiave primaria
        casaEditriceRepository.deleteById(id);
    }

}
