package tn.esprit.tic.ds.springproj.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ds.springproj.entities.Restaurant;
import tn.esprit.tic.ds.springproj.repository.RestaurantRepository;
import tn.esprit.tic.ds.springproj.services.IRestaurantService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {
    private final IRestaurantService restaurantService;

    //    http://localhost:8089/menu/restaurant/find-all-restaurants
    @GetMapping("/find-all-restaurants/{localDate}/{nbPlacesMax}")
    public List<RestaurantRepository> findAllRestaurants(
            @PathVariable("localDate") LocalDate localDate,
            @PathVariable("nbPlacesMax") int nbPlacesMax) {
        List<RestaurantRepository> restaurants = restaurantService
                .retrieveAllByChaineRestaurationDateCreationAndNbPlacesMax(localDate, nbPlacesMax);
        return restaurants;
    }

    // Affectations

    //   http://localhost:8089/menu/restaurant/affecter-restaurant-a-chaine-restauration
    @GetMapping("/affecter-restaurant-a-chaine-restauration/{nomRestaurant}/{libelleChaine}")
    public Restaurant affecterRestaurantAChaineRestauration(
            @PathVariable("nomRestaurant") String nomRestaurant,
            @PathVariable("libelleChaine") String libelleChaine) {
        return restaurantService.affecterRestaurantAChaineRestauration(nomRestaurant, libelleChaine);
    }

    //   http://localhost:8089/menu/restaurant/ajout-restaurant-et-menu-associes
    @PostMapping("/ajout-restaurant-et-menu-associes")
    public Restaurant ajoutRestaurantEtMenuAssocies(@RequestBody Restaurant restaurant) {
        return restaurantService.ajoutRestaurantEtMenuAssocies(restaurant);
    }
}
