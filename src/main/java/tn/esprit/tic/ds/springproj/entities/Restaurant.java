package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRestaurant")
    private Long idRestaurant;
    private String nom;
    private Long nbPlacesMax;
    @ManyToOne(fetch = FetchType.EAGER)
    ChaineRestauration chaineRestauration;
    @OneToMany(fetch = FetchType.LAZY)
    ArrayList<Menu> menus;
}
