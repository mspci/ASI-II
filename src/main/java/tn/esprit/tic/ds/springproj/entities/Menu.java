package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;

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
}
