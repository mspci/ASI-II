package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Menu")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMenu")
    Long idMenu;
    String libelleMenu;
    Float prixTotal;
    @Enumerated(EnumType.STRING)
    TypeMenu typeMenu;
    @ManyToMany(fetch = FetchType.LAZY)
    List<ChefCuisinier> chefCuisinier;
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    List<Commande> commandes;
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    List<Composant> composants;
}
