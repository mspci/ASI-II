package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRestaurant")
    private Long idRestaurant;
    private String nom;
    private Long nbPlacesMax;
}
