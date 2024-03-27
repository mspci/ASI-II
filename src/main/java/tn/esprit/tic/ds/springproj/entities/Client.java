package tn.esprit.tic.ds.springproj.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
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
    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandes;
}
