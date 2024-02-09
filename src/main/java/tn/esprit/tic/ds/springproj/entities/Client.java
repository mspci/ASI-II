package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    private Long idClient; // Clé primaire
    private String identifiant;
    @Temporal(TemporalType.DATE)
    private Date datePremiereVisite;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private ArrayList<Commande> commandes;
}
