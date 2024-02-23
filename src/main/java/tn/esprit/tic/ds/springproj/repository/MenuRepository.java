package tn.esprit.tic.ds.springproj.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.entities.TypeComposant;
import tn.esprit.tic.ds.springproj.entities.TypeMenu;

import java.util.List;

public interface MenuRepository {
    List<Menu> findAllByComposantsOrderByPrixTotalGreaterThan(float PrixTotal);

    @Query("SELECT m.libelleMenu FROM Menu m " +
            "WHERE m.typeMenu = :typeMenu " +
            "ORDER BY m.prixTotal")
    List<String> retrieveMenuLabelByMenuTypeOrderedByPrice(@Param("typeMenu") TypeMenu typeMenu);

    @Query("SELECT m FROM Menu m " +
            "JOIN m.composants c " +
            "JOIN c.detailComposant dc " +
            "WHERE dc.typeComposant = :typeComposant")
    List<Menu> retrieveMenuByTypeComposant(@Param("typeComposant") TypeComposant typeComposant);
}
