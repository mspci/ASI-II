package tn.esprit.tic.ds.springproj.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tic.ds.springproj.entities.ChefCuisinier;
import tn.esprit.tic.ds.springproj.entities.TypeChef;
import tn.esprit.tic.ds.springproj.services.ChefCuisinierService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chef-cuisinier")
public class ChefCuisinierController {
    private final ChefCuisinierService chefCuisinierService;

    @GetMapping("/list-chef-cuisinier-by-type-chef-and-restaurant/{typeChef}/{nomRestaurant}")
    public List<ChefCuisinier> listChefCuisinierByTypeChefAndRestaurant(TypeChef typeChef, String nomRestaurant) {
        return chefCuisinierService.listChefCuisinierByTypeChefAndRestaurant(typeChef, nomRestaurant);
    }
}
