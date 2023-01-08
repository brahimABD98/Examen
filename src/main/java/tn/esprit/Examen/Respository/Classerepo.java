package tn.esprit.Examen.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Examen.Entity.Classe;
import tn.esprit.Examen.Entity.Utilisateur;

import java.util.List;

@Repository
public interface Classerepo extends JpaRepository<Classe, Integer> {

}
