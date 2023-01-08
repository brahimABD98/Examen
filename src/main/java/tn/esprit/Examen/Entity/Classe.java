package tn.esprit.Examen.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@ToString
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Classe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeClasse;
    private String titre;
    @Enumerated(value = EnumType.STRING)
    private Niveau niveau;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "classe")
    private Set<CoursClassroom> coursClassrooms;

}
