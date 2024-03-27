package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ChaineRestauration")
public class ChaineRestauration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChaineRestauration")
    private Long idChaineRestauration;
    private String libelle;
    private LocalDate dateCreation;
    @OneToMany(mappedBy = "chaineRestauration")
    List<Restaurant> restaurants;
}
