package tn.esprit.tic.ds.springproj.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // add a test attribute


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
    @JsonIgnore
    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
    List<Commande> commandes;
    @JsonIgnore
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    List<Composant> composants;
}
