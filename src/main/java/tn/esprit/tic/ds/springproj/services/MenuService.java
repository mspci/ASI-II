package tn.esprit.tic.ds.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.entities.TypeMenu;
import tn.esprit.tic.ds.springproj.repository.MenuRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuService implements IMenuService {
    MenuRepository menuRepository;

    @Override
    public List<Menu> retrieveMenusByTypeAndPrice(TypeMenu typeMenu, Float PrixTotal) {
        return menuRepository.findAllByTypeMenuAndPrixTotalGreaterThan(typeMenu, PrixTotal);
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
    public Menu updateMenu(Menu m) {
        return menuRepository.save(m);
    }

    @Override
    public Menu retrieveMenu(Long idMenu) {
        return menuRepository.findById(idMenu).orElse(null);
    }

    @Override
    public void removeMenu(Long idMenu) {
        menuRepository.deleteById(idMenu);
    }

    @Override
    public List<Menu> addMenus(List<Menu> Menus) {
        return menuRepository.saveAll(Menus);
    }
}
