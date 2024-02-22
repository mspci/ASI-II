package tn.esprit.tic.ds.springproj.repository;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantRepository {
    List<RestaurantRepository> findAllByChaineRestaurantDateCreationlessThanAndNbPlacesMaxGreaterThan(LocalDate localDate, int nbPlacesMax);
}
