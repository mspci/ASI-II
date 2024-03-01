package tn.esprit.tic.ds.springproj.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.entities.TypeComposant;
import tn.esprit.tic.ds.springproj.entities.TypeMenu;
import tn.esprit.tic.ds.springproj.services.IMenuService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/menu")
public class MenuController {
    private final IMenuService menuService;

    //    http://localhost:8089/menu/menu/find-menu-labels/DINER
    @GetMapping("/find-menu-labels/{typeMenu}")
    public List<String> findMenuLabelsByTypeOrderedByPrice(@PathVariable("typeMenu") TypeMenu typeMenu) {
        List<String> menuLabels = menuService.getMenuLabelByMenuTypeOrderedByPrice(typeMenu);
        return menuLabels;
    }

    //    http://localhost:8089/menu/menu/find-menus-by-type-composant/VIANDE_BLANCHE
    @GetMapping("/find-menus-by-type-composant/{typeComposant}")
    public List<Menu> findMenusByTypeComposant(@PathVariable("typeComposant") TypeComposant typeComposant) {
        List<Menu> menus = menuService.getMenuByTypeComposant(typeComposant);
        return menus;
    }

    //    http://localhost:8089/menu/menu/find-menus/DINER/500
    @GetMapping("/find-menus/{typeMenu}/{prixTotal}")
    public List<Menu> findMenusByTypeAndPriceGreaterThan(@PathVariable("typeMenu") TypeMenu typeMenu, @PathVariable("prixTotal") Float prixTotal) {
        List<Menu> menus = menuService.retrieveMenusByTypeAndPrice(typeMenu, prixTotal);
        return menus;
    }

    //   http://localhost:8089/menu/menu/find-all-menus
    @GetMapping("/find-all-menus")
    public List<Menu> findAllMenus() {
        List<Menu> menus = menuService.retrieveAllMenus();
        return menus;
    }

    //  http://localhost:8089/menu/menu/find-menu/1
    @GetMapping("/find-menu/{idMenu}")
    public Menu findMenu(@PathVariable("idMenu") Long idMenu) {
        Menu menu = menuService.retrieveMenu(idMenu);
        return menu;
    }

    // http://localhost:8089/menu/menu/add-menu
    @PostMapping("/add-menu")
    public Menu addMenu(@RequestBody Menu m) {
        Menu menu = menuService.addMenu(m);
        return menu;
    }

    // http://localhost:8089/menu/menu/add-menus
    @PostMapping("/add-menus")
    public List<Menu> addMenus(@RequestBody List<Menu> menus) {
        List<Menu> listMenus = menuService.addMenus(menus);
        return listMenus;
    }

    // http://localhost:8089/menu/menu/update-menu
    @PutMapping("/update-menu")
    public Menu updateMenu(@RequestBody Menu m) {
        Menu menu = menuService.updateMenu(m);
        return menu;
    }

    // http://localhost:8089/menu/menu/remove-menu/1
    @DeleteMapping("/remove-menu/{idMenu}")
    public void removeMenu(@PathVariable("idMenu") Long idMenu) {
        menuService.removeMenu(idMenu);
    }
}
