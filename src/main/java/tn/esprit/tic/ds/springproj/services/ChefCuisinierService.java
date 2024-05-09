package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.ChefCuisinier;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.entities.Restaurant;
import tn.esprit.tic.ds.springproj.entities.TypeChef;
import tn.esprit.tic.ds.springproj.repository.ChefCuisinierRepository;
import tn.esprit.tic.ds.springproj.repository.MenuRepository;
import tn.esprit.tic.ds.springproj.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ChefCuisinierService implements IChefCuisinierService {
    private final MenuRepository menuRepository;
    private final ChefCuisinierRepository chefCuisinierRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<ChefCuisinier> listChefCuisinierByTypeChefAndRestaurant(TypeChef typeChef, String nomRestaurant) {
        List<Restaurant> restaurants = restaurantRepository.findRestaurantByNom(nomRestaurant);

        List<Menu> menus = restaurants.stream()
                .flatMap(restaurant -> restaurant.getMenus().stream())
                .toList();

        return menus.stream()
                .flatMap(menu -> menu.getChefCuisinier().stream())
                .filter(chefCuisinier -> chefCuisinier.getTypeChef().equals(typeChef))
                .toList();
    }
}
