package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    @ManyToMany(mappedBy = "chefCuisinier")
    private List<Menu> menu;
}
