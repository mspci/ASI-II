package tn.esprit.tic.ds.springproj.services;

import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.entities.TypeMenu;

import java.util.List;

@Service
public interface IMenuService {
    List<Menu> retrieveMenusByTypeAndPrice(TypeMenu typeMenu, Float PrixTotal);

    List<Menu> retrieveAllMenus();

    Menu addMenu(Menu e);

    Menu updateMenu(Menu e);

    Menu retrieveMenu(Long idMenu);

    void removeMenu(Long idMenu);

    List<Menu> addMenus(List<Menu> Menus);
}
