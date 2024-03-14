package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.ChaineRestauration;
import tn.esprit.tic.ds.springproj.entities.Restaurant;
import tn.esprit.tic.ds.springproj.repository.ChaineRestaurationRepository;
import tn.esprit.tic.ds.springproj.repository.RestaurantRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantService implements IRestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ChaineRestaurationRepository chaineRestaurationRepository;

    @Override
    public List<RestaurantRepository> retrieveAllByChaineRestaurationDateCreationAndNbPlacesMax(LocalDate localDate, int nbPlacesMax) {
        return restaurantRepository.findAllByChaineRestaurationDateCreationLessThanAndNbPlacesMaxGreaterThan(localDate, nbPlacesMax);
    }

    @Override
    public Restaurant affecterRestaurantAChaineRestauration(String nomRestaurant, String libelleChaine) {
        Restaurant restaurant = restaurantRepository.findByNom(nomRestaurant);
        ChaineRestauration chaineRestauration = chaineRestaurationRepository.findByLibelle(libelleChaine);
        restaurant.setChaineRestauration(chaineRestauration);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant ajoutRestaurantEtMenuAssocies(Restaurant restaurant) {
        restaurant.getMenus().forEach(menu -> menu.setPrixTotal(0.0f));
        return restaurantRepository.save(restaurant);
    }
}
