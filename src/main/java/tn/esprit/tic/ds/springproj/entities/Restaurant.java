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
    List<Menu> menus;
}
