package tn.esprit.tic.ds.springproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproj.entities.Commande;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByClientIdClient(Long idClient);

    List<Commande> findByClientIdClientAndDateCommandeBetween(Long idClient, LocalDate dateFrom, LocalDate dateTo);

    List<Commande> findByClientIdClientAndDateCommandeBetweenOrderByNoteAsc(Long idClient, LocalDate dateFrom, LocalDate dateTo);
}
