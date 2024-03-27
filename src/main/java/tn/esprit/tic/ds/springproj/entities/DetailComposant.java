package tn.esprit.tic.ds.springproj.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DetailComposant")
public class DetailComposant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetailComposant")
    private Long idDetailComposant;
    private Float imc;
    @Enumerated(EnumType.STRING)
    private TypeComposant typeComposant;
}
