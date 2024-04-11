package tn.esprit.tic.ds.springproj.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
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
    @JsonIgnore
    private Menu menu;
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnore
    private DetailComposant detailComposant;
}
