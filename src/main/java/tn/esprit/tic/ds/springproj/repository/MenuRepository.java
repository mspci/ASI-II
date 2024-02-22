package tn.esprit.tic.ds.springproj.repository;

import tn.esprit.tic.ds.springproj.entities.Menu;

import java.util.List;

public interface MenuRepository {
    List<Menu> findAllByComposantsOrderByPrixTotalGreaterThan(float PrixTotal);
}
