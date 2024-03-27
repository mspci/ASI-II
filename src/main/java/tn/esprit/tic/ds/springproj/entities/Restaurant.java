package tn.esprit.tic.ds.springproj.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    ChaineRestauration chaineRestauration;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Menu> menus;
}
