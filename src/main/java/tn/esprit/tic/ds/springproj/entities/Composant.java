package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Composant")
public class Composant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdComposant")
    private Long idComposant;
    private String nomComposant;
    private Float pix;
}
