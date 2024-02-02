package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ChefCuisinier")
public class ChefCuisinier {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idChefCuisinier")
    private Long idChefCuisinier; // Clé primaire
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private TypeChef typeChef;

    // Constructeur et accesseurs (getters) et mutateurs (setters)
}
