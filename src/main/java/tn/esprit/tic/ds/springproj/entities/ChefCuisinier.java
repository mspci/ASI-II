package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ChefCuisinier")
public class ChefCuisinier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChefCuisinier")
    private Long idChefCuisinier;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private TypeChef typeChef;
    @ManyToMany(mappedBy = "chefCuisinier", fetch = FetchType.LAZY)
    private List<Menu> menu;
}
