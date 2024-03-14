package tn.esprit.tic.ds.springproj.services;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.esprit.tic.ds.springproj.entities.ChefCuisinier;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.entities.TypeComposant;
import tn.esprit.tic.ds.springproj.entities.TypeMenu;

import java.util.List;

@Service
public interface IMenuService {
    List<String> getMenuLabelByMenuTypeOrderedByPrice(@Param("typeMenu") TypeMenu typeMenu);

    List<Menu> getMenuByTypeComposant(@Param("typeComposant") TypeComposant typeComposant);

    List<Menu> retrieveMenusByTypeAndPrice(TypeMenu typeMenu, Float PrixTotal);

    Menu retrieveMenu(Long idMenu);

    List<Menu> retrieveAllMenus();

    Menu addMenu(Menu e);

    List<Menu> addMenus(List<Menu> Menus);

    Menu updateMenu(Menu e);

    void removeMenu(Long idMenu);

    ChefCuisinier affecterChefCuisinierAMenu(Long idChefCuisinier, Long idMenu);

    ChefCuisinier desaffecterChefCuisinierDuMenu(Long idMenu);
}
