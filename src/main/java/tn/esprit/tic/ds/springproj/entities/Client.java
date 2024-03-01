package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    private Long idClient;
    private String identifiant;
    @Temporal(TemporalType.DATE)
    private Date datePremiereVisite;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private ArrayList<Commande> commandes;
}
