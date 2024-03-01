package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Composant")
public class Composant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdComposant")
    private Long idComposant;
    private String nomComposant;
    private Float prix;
    @ManyToOne(fetch = FetchType.EAGER)
    private Menu menu;
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private DetailComposant detailComposant;
}
