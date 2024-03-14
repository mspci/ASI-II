package tn.esprit.tic.ds.springproj.services;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.Restaurant;
import tn.esprit.tic.ds.springproj.repository.RestaurantRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public interface IRestaurantService {
    List<RestaurantRepository> retrieveAllByChaineRestaurationDateCreationAndNbPlacesMax(LocalDate localDate, int nbPlacesMax);

    Restaurant affecterRestaurantAChaineRestauration(String nomRestaurant, String libelleChaine);

    Restaurant ajoutRestaurantEtMenuAssocies(Restaurant restaurant);
}
