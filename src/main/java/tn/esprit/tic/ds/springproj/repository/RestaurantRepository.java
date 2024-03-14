package tn.esprit.tic.ds.springproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproj.entities.Restaurant;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<RestaurantRepository> findAllByChaineRestaurationDateCreationLessThanAndNbPlacesMaxGreaterThan(LocalDate localDate, int nbPlacesMax);

    Restaurant findByNom(String nom);
}
