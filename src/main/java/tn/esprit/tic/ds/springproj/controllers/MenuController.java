package tn.esprit.tic.ds.springproj.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Menu Management Module",
        description = "Operations pertaining to menu management")
public class MenuController {
    private final IMenuService menuService;

    //    http://localhost:8089/menu/menu/find-menu-labels/DINER
    @Operation(summary = "Find menu labels by type ordered by price",
            description = "Find menu labels by type ordered by price")
    @GetMapping("/find-menu-labels/{typeMenu}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved menu labels"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menu labels not found")
    })
    public List<String> findMenuLabelsByTypeOrderedByPrice(
            @Parameter(description = "Type of menu", required = true)
            @PathVariable("typeMenu") TypeMenu typeMenu) {
        return menuService.getMenuLabelByMenuTypeOrderedByPrice(typeMenu);
    }

    //    http://localhost:8089/menu/menu/find-menus-by-type-composant/VIANDE_BLANCHE
    @Operation(summary = "Find menus by type composant",
            description = "Find menus by type composant")
    @GetMapping("/find-menus-by-type-composant/{typeComposant}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved menus by type of component"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menus not found")
    })
    public List<Menu> findMenusByTypeComposant(
            @Parameter(description = "Type of composant", required = true)
            @PathVariable("typeComposant") TypeComposant typeComposant) {
        return menuService.getMenuByTypeComposant(typeComposant);
    }

    //    http://localhost:8089/menu/menu/find-menus/DINER/500
    @Operation(summary = "Find menus by type and price",
            description = "Find menus by type and price greater than a given value")
    @GetMapping("/find-menus/{typeMenu}/{prixTotal}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved menus by type and price"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menus not found")
    })
    public List<Menu> findMenusByTypeAndPriceGreaterThan(
            @Parameter(description = "Type of menu", required = true)
            @PathVariable("typeMenu") TypeMenu typeMenu,
            @Parameter(description = "Total price", required = true)
            @PathVariable("prixTotal") Float prixTotal) {
        return menuService.retrieveMenusByTypeAndPrice(typeMenu, prixTotal);
    }

    //   http://localhost:8089/menu/menu/find-all-menus
    @Operation(summary = "Find all menus")
    @GetMapping("/find-all-menus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all menus"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menus not found")
    })
    public List<Menu> findAllMenus() {
        return menuService.retrieveAllMenus();
    }

    //  http://localhost:8089/menu/menu/find-menu/1
    @Operation(summary = "Find a menu by ID")
    @GetMapping("/find-menu/{idMenu}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the menu"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menu not found")
    })
    public Menu findMenu(
            @Parameter(description = "ID of the menu", required = true)
            @PathVariable("idMenu") Long idMenu) {
        return menuService.retrieveMenu(idMenu);
    }

    // http://localhost:8089/menu/menu/add-menu
    @Operation(summary = "Add a menu")
    @PostMapping("/add-menu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Menu successfully added"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public Menu addMenu(
            @Parameter(description = "Menu object to add", required = true)
            @RequestBody Menu m) {
        return menuService.addMenu(m);
    }

    // http://localhost:8089/menu/menu/add-menus
    @Operation(summary = "Add multiple menus")
    @PostMapping("/add-menus")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Menus successfully added"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public List<Menu> addMenus(
            @Parameter(description = "List of menu objects to add", required = true)
            @RequestBody List<Menu> menus) {
        return menuService.addMenus(menus);
    }

    // http://localhost:8089/menu/menu/update-menu
    @Operation(summary = "Update a menu")
    @PutMapping("/update-menu")
    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Menu successfully updated"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menu not found")
    })
    public Menu updateMenu(
            @Parameter(description = "Menu object to update", required = true)
            @RequestBody Menu m) {
        return menuService.updateMenu(m);
    }

    // http://localhost:8089/menu/menu/remove-menu/1
    @Operation(summary = "Remove a menu by ID")
    @DeleteMapping("/remove-menu/{idMenu}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Menu successfully removed"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menu not found")
    })
    public void removeMenu(
            @Parameter(description = "ID of the menu to remove", required = true)
            @PathVariable("idMenu") Long idMenu) {
        menuService.removeMenu(idMenu);
    }

    // Affectations

    // http://localhost:8089/menu/menu/affecter-chef-cuisinier-a-menu/2/1
    @Operation(summary = "Assign a chef cuisinier to a menu")
    @GetMapping("/affecter-chef-cuisinier-a-menu/{idMenu}/{idChefCuisinier}/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chef cuisinier successfully assigned to menu"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menu or chef not found")
    })
    public void affecterChefCuisinierAMenu(
            @Parameter(description = "ID of the chef cuisinier", required = true)
            @PathVariable("idChefCuisinier") Long idChefCuisinier,
            @Parameter(description = "ID of the menu", required = true)
            @PathVariable("idMenu") Long idMenu) {
        menuService.affecterChefCuisinierAMenu(idChefCuisinier, idMenu);
    }

    // http://localhost:8089/menu/menu/desaffecter-chef-cuisinier-du-menu/2/1
    @Operation(summary = "Remove assignment of a chef cuisinier from a menu")
    @GetMapping("/desaffecter-chef-cuisinier-du-menu/{idMenu}/{idChef}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chef cuisinier successfully removed from menu"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menu or chef not found")
    })
    public void desaffecterChefCuisinierDuMenu(
            @Parameter(description = "ID of the menu", required = true)
            @PathVariable("idMenu") Long idMenu,
            @Parameter(description = "ID of the chef cuisinier", required = true)
            @PathVariable("idChef") Long idChef) {
        menuService.desaffecterChefCuisinierDuMenu(idMenu, idChef);
    }

    // 9.1 Afficher les noms des menus ordonnés par prix total
    // http://localhost:8089/menu/menu/find-menu-labels-by-type-menu-ordered-by-price/DINER
    @Operation(summary = "Find menu labels by type ordered by price",
            description = "Find menu labels by type ordered by price")
    @GetMapping("/find-menu-labels-by-type-menu-ordered-by-price/{typeMenu}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved menu labels"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menu labels not found")
    })
    public List<String> findMenuLabelsByTypeMenuOrderedByPrice(
            @Parameter(description = "Type of menu", required = true)
            @PathVariable("typeMenu") TypeMenu typeMenu) {
        return menuService.nomMenuparTypeMenuOrdonneParTprixTotal(typeMenu);
    }

    // 9.2 Afficher les menus selon un typeMenu donné
    // dont le prix des composants est supérieur à un montant donné en paramètres
    // http://localhost:8089/menu/menu/find-menus-by-type-menu-and-price/DINER/500
    @Operation(summary = "Find menus by type and price",
            description = "Find menus by type and price greater than a given value")
    @GetMapping("/find-menus-by-type-menu-and-price/{typeMenu}/{prixTotal}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved menus by type and price"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Menus not found")
    })
    public List<Menu> findMenusByTypeMenuAndPriceGreaterThan(
            @Parameter(description = "Type of menu", required = true)
            @PathVariable("typeMenu") TypeMenu typeMenu,
            @Parameter(description = "Total price", required = true)
            @PathVariable("prixTotal") Float prixTotal) {
        return menuService.listeMenuSelonTypeMenuEtprixComposantsSuperieurAUnMontant(typeMenu, prixTotal);
    }
}
