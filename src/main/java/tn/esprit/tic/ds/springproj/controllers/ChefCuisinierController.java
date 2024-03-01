package tn.esprit.tic.ds.springproj.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tic.ds.springproj.services.ChefCuisinierService;

@RestController
@AllArgsConstructor
@RequestMapping("/chef-cuisinier")
public class ChefCuisinierController {
    private final ChefCuisinierService chefCuisinierService;
}
