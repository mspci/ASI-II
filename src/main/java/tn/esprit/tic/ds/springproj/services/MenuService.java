package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.*;
import tn.esprit.tic.ds.springproj.repository.ChefCuisinierRepository;
import tn.esprit.tic.ds.springproj.repository.MenuRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MenuService implements IMenuService {
    private final MenuRepository menuRepository;
    private final ChefCuisinierRepository chefCuisinierRepository;

    @Override
    public List<String> getMenuLabelByMenuTypeOrderedByPrice(TypeMenu typeMenu) {
        return menuRepository.retrieveMenuLabelByMenuTypeOrderedByPrice(typeMenu);
    }

    @Override
    public List<Menu> getMenuByTypeComposant(TypeComposant typeComposant) {
        return menuRepository.retrieveMenuByTypeComposant(typeComposant);
    }

    @Override
    public List<Menu> retrieveMenusByTypeAndPrice(TypeMenu typeMenu, Float PrixTotal) {
        return menuRepository.findAllByTypeMenuAndPrixTotalGreaterThan(typeMenu, PrixTotal);
    }

    @Override
    public Menu retrieveMenu(Long idMenu) {
        return menuRepository.findById(idMenu).orElse(null);
    }

    @Override
    public List<Menu> retrieveAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu addMenu(Menu m) {
        return menuRepository.save(m);
    }

    @Override
    public List<Menu> addMenus(List<Menu> Menus) {
        return menuRepository.saveAll(Menus);
    }

    @Override
    public Menu updateMenu(Menu m) {
        return menuRepository.save(m);
    }

    @Override
    public void removeMenu(Long idMenu) {
        menuRepository.deleteById(idMenu);
    }

    @Override
    public ChefCuisinier affecterChefCuisinierAMenu(Long idChefCuisinier, Long idMenu) {
        Menu menu = menuRepository.findById(idMenu).orElse(null);
        ChefCuisinier chefCuisinier = chefCuisinierRepository.findById(idChefCuisinier).orElse(null);
        if (menu == null || chefCuisinier == null) {
            return null;
        }

        menu.getChefCuisinier().add(chefCuisinier);
        menuRepository.save(menu);

        return chefCuisinier;
    }

    @Override
    public ChefCuisinier desaffecterChefCuisinierDuMenu(Long idMenu, Long idChef) {
        Menu menu = menuRepository.findById(idMenu).orElse(null);
        if (menu == null
                || menu.getChefCuisinier() == null
                || menu.getChefCuisinier().isEmpty()) {
            return null;
        }

        ChefCuisinier chefCuisinier = chefCuisinierRepository.findById(idChef).orElse(null);
        if (chefCuisinier == null) {
            return null;
        }

        menu.getChefCuisinier().remove(chefCuisinier);
        menuRepository.save(menu);

        return chefCuisinier;
    }

    @Override
    public List<String> nomMenuparTypeMenuOrdonneParTprixTotal(TypeMenu typeMenu) {
        return menuRepository.retrieveMenuLabelByTypeMenuOrderedByPrice(typeMenu);
    }

    @Override
    public List<Menu> listeMenuSelonTypeMenuEtprixComposantsSuperieurAUnMontant(TypeMenu typeMenu, Float prixTotal) {
        return menuRepository.findAllByTypeMenuAndPrixTotalGreaterThan(typeMenu, prixTotal);
    }
}
