package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMenu")
    private Long idMenu; // Clé primaire
    private String libelleMenu;
    private Float prixTotal;
    @Enumerated(EnumType.STRING)
    private TypeMenu typeMenu;
    @ManyToMany(fetch = FetchType.LAZY)
    private ArrayList<ChefCuisinier> chefCuisinier;
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private ArrayList<Commande> commandes;
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private ArrayList<Composant> composants;
}
