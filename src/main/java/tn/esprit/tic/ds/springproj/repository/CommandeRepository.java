package tn.esprit.tic.ds.springproj.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tic.ds.springproj.entities.Commande;

import java.time.LocalDate;
import java.util.List;

public interface CommandeRepository extends CrudRepository<Commande, Long> {
    List<Commande> findByClientIdClient(Long idClient);

    List<Commande> findByClientIdClientAndDateCommandeBetween(Long idClient, LocalDate dateFrom, LocalDate dateTo);

    List<Commande> findByClientIdClientAndDateCommandeBetweenOrderByNoteAsc(Long idClient, LocalDate dateFrom, LocalDate dateTo);
}
