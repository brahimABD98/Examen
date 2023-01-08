package tn.esprit.Examen.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilisateur;

    private String prenom;

    private String nom;

    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    private Classe classe;

}
