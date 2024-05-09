package tn.esprit.tic.ds.springproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.tic.ds.springproj.entities.ChefCuisinier;
import tn.esprit.tic.ds.springproj.entities.Menu;
import tn.esprit.tic.ds.springproj.entities.TypeChef;

import java.util.List;

@Repository
public interface ChefCuisinierRepository extends JpaRepository<ChefCuisinier, Long> {
}
