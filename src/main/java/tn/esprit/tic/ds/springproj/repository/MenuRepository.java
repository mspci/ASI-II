package tn.esprit.tic.ds.springproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.entities.TypeComposant;
import tn.esprit.tic.ds.springproj.entities.TypeMenu;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    // 1.4 liste des menus selon le type menu avec le prix  des composants est supérieur à un montant donné en paramètres
    List<Menu> findAllByTypeMenuAndPrixTotalGreaterThan(TypeMenu typeMenu, Float PrixTotal);

    // 2.1 List nom Menu Par le type Menu Ordonne Par PrixTotal
    @Query("SELECT m.libelleMenu FROM Menu m " +
            "WHERE m.typeMenu = :typeMenu " +
            "ORDER BY m.prixTotal")
    List<String> retrieveMenuLabelByMenuTypeOrderedByPrice(@Param("typeMenu") TypeMenu typeMenu);

    // 2.2 list Menu Par TypeComposant (exemple : les menus contenant de la viande blanche)
    @Query("SELECT m FROM Menu m " +
            "JOIN m.composants c " +
            "JOIN c.detailComposant dc " +
            "WHERE dc.typeComposant = :typeComposant")
    List<Menu> retrieveMenuByTypeComposant(@Param("typeComposant") TypeComposant typeComposant);

    // 9.1 Afficher les noms des menus ordonnés par prix total
    @Query("SELECT m.libelleMenu FROM Menu m " +
            "Where m.typeMenu = :typeMenu " +
            "ORDER BY m.prixTotal")
    List<String> retrieveMenuLabelByTypeMenuOrderedByPrice(@Param("typeMenu") TypeMenu typeMenu);

    // 9.2 Afficher les menus selon un typeMenu donné
    // dont le prix des composants est supérieur à un montant donné en paramètres
    List<Menu> findByTypeMenuAndComposantsPrixGreaterThan(TypeMenu typeMenu, Float prixTotal);

//    @Query("SELECT m FROM Menu m " +
//            "JOIN m.composants c " +
//            "WHERE m.typeMenu = :typeMenu " +
//            "AND SUM(c.prix) > :prixTotal")
//    List<Menu> retrieveMenuByTypeMenuAndPrixTotalGreaterThan(@Param("typeMenu") TypeMenu typeMenu, @Param("prixTotal") Float prixTotal);

    Optional<Menu> findByLibelleMenu(String libelleMenu);

    @Query("SELECT m FROM Menu m WHERE SIZE(m.commandes) = (SELECT MAX(SIZE(m2.commandes)) FROM Menu m2)")
    Menu findMenuWithMaxCommandes();
}
