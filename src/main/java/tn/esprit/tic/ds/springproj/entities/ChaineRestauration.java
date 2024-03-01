package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
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
