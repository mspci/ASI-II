package tn.esprit.tic.ds.springproj.services;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.Composant;
import tn.esprit.tic.ds.springproj.entities.Menu;

import java.util.Set;

@Service
public interface IComposantService {
    Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu);
}
