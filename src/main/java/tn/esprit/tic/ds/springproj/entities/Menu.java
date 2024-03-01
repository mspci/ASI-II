package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMenu")
    private Long idMenu;
    private String libelleMenu;
    private Float prixTotal;
    @Enumerated(EnumType.STRING)
    private TypeMenu typeMenu;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<ChefCuisinier> chefCuisinier;
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<Commande> commandes;
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<Composant> composants;
}
