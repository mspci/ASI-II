package tn.esprit.tic.ds.springproj.services;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.ChefCuisinier;
import tn.esprit.tic.ds.springproj.entities.TypeChef;

import java.util.List;

@Service
public interface IChefCuisinierService {
    List<ChefCuisinier> listChefCuisinierByTypeChefAndRestaurant(TypeChef typeChef, String nomRestaurant);
}
