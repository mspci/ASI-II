package tn.esprit.tic.ds.springproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproj.entities.ChaineRestauration;

@Repository
public interface ChaineRestaurationRepository extends JpaRepository<ChaineRestauration, Long> {
    ChaineRestauration findByLibelle(String libelle);
}
