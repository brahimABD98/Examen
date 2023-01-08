package tn.esprit.Examen.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CoursClassroom  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCours;
    private  String Nom;
    private int nbHeures;
    private boolean archive;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @ManyToOne(cascade = CascadeType.ALL)
    private Classe classe;
}
