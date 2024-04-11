package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.Composant;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.repository.ComposantRepository;
import tn.esprit.tic.ds.springproj.repository.MenuRepository;

import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ComposantService implements IComposantService {
    private final ComposantRepository composantRepository;
    private final MenuRepository menuRepository;

    @Override
    public Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu) {
        Menu menu = menuRepository.findById(idMenu)
                .orElseThrow(() -> new IllegalArgumentException("Menu not found with id: " + idMenu));

        composants.forEach(c -> c.setMenu(menu));

        Float prixTotal = composants.stream()
                .map(Composant::getPrix)
                .reduce(0f, Float::sum);

        if (prixTotal > 20f) {
            String errorMessage = "Le prix total du menu ne doit pas dépasser 20 dinars";
            log.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }

        menu.setPrixTotal(prixTotal);

        composantRepository.saveAll(composants);
        menuRepository.save(menu);

        return menu;
    }
}
