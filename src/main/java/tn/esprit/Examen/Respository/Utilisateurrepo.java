package tn.esprit.Examen.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Examen.Entity.Niveau;
import tn.esprit.Examen.Entity.Utilisateur;

import java.util.List;
@Repository
public interface Utilisateurrepo extends JpaRepository<Utilisateur,Integer> {
    public List<Utilisateur> findByClasseNiveau(Niveau niveau);
    public Integer countByClasseNiveau(Niveau niveau);
}
