package tn.esprit.tic.ds.springproj.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tic.ds.springproj.repository.RestaurantRepository;
import tn.esprit.tic.ds.springproj.services.IRestaurantService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {
    private final IRestaurantService restaurantService;

    //    http://localhost:8089/restaurant/restaurant/find-all-restaurants
    @GetMapping("/find-all-restaurants/{localDate}/{nbPlacesMax}")
    public List<RestaurantRepository> findAllRestaurants(
            @PathVariable("localDate") LocalDate localDate,
            @PathVariable("nbPlacesMax") int nbPlacesMax) {
        List<RestaurantRepository> restaurants = restaurantService
                .retrieveAllByChaineRestaurationDateCreationAndNbPlacesMax(localDate, nbPlacesMax);
        return restaurants;
    }
}
