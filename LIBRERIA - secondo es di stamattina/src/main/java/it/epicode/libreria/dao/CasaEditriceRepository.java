package it.epicode.libreria.dao;

import it.epicode.libreria.entita.CasaEditrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaEditriceRepository extends JpaRepository<CasaEditrice, Long> {
}
