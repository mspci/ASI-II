package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.repository.ChefCuisinierRepository;

@Service
@AllArgsConstructor
public class ChefCuisinierService implements IChefCuisinierService {
    private final ChefCuisinierRepository chefCuisinierRepository;
}
