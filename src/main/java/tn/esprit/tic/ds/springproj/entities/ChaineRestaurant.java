package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ChaineRestaurant")
public class ChaineRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChaineRestaurant")
    private Long idChaineRestaurant;
    private String libelle;
    @Temporal(TemporalType.DATE)
    private LocalDate dateCreation;
}
