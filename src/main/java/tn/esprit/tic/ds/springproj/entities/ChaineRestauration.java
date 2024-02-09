package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "ChaineRestauration")
public class ChaineRestauration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChaineRestauration")
    private Long idChaineRestauration;
    private String libelle;
    private LocalDate dateCreation;
    @OneToMany(mappedBy = "chaineRestauration")
    ArrayList<Restaurant> restaurants;
}
