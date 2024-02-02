package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCommande")
    private Long idCommande;
    @Temporal(TemporalType.DATE)
    private LocalDate dateCommande;
    private Integer pourcentageRemise;
    private Float totalRemise;
    private Float totalCommande;
    private Long note;
}
