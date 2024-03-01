package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.repository.RestaurantRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantService implements IRestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantRepository> retrieveAllByChaineRestaurationDateCreationAndNbPlacesMax(LocalDate localDate, int nbPlacesMax) {
        return restaurantRepository.findAllByChaineRestaurationDateCreationLessThanAndNbPlacesMaxGreaterThan(localDate, nbPlacesMax);
    }
}
