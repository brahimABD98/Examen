package tn.esprit.Examen.Service;


import lombok.Builder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.Examen.Entity.*;
import tn.esprit.Examen.Respository.Classerepo;
import tn.esprit.Examen.Respository.CoursClassroomrepo;
import tn.esprit.Examen.Respository.Utilisateurrepo;

import java.util.List;

@Builder
@Service

public class MyService implements IMyService {

    private Classerepo classerepo;

    private CoursClassroomrepo coursClassroomrepo;

    private Utilisateurrepo utilisateurrepo;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        if (utilisateur != null)
            return utilisateurrepo.save(utilisateur);
        return null;
    }

    @Override
    public Classe ajouterClasse(Classe classe) {
        if (classe != null)
            classerepo.save(classe);
        return null;
    }

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom coursClassroom, Integer codeClasse) {
        Classe c = classerepo.findById(codeClasse).orElse(null);
        if (c != null) {
            coursClassroom.setClasse(c);
            coursClassroomrepo.save(coursClassroom);
        }
        return null;
    }

    @Override
    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse) {
        Utilisateur u = utilisateurrepo.findById(idUtilisateur).orElse(null);
        Classe c = classerepo.findById(codeClasse).orElse(null);
        if ((u != null) && (c != null)) {
            u.setClasse(c);
            utilisateurrepo.save(u);
        }
    }

    @Override
    public Integer nbUtilisateursParNiveau(Niveau nv) {
        List<Utilisateur> lu = utilisateurrepo.findByClasseNiveau(nv);
        if (lu.size() > 0) {
            return lu.size();
        }

        return null;
    }

    @Override
    public Integer nbUtilisateursParNiveauUsingCount(Niveau nv) {
        if (nv != null)
            return utilisateurrepo.countByClasseNiveau(nv);
        return null;
    }

    @Override
    public void desaffecterCoursClassroomClasse(Integer idCours) {
        CoursClassroom cc = coursClassroomrepo.findById(idCours).orElse(null);

        if (cc != null) {
            cc.setIdCours(0);
            coursClassroomrepo.save(cc);
        }
    }


    @Override
    @Scheduled(fixedRate = 60000)
    public void archiverCoursClassrooms() {
        List<CoursClassroom> listecours = coursClassroomrepo.findAll();
        for (CoursClassroom cour : listecours) {
            cour.setArchive(true);
            coursClassroomrepo.save(cour);
        }

    }

    @Override
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) {
        if (sp != null && nv != null) {
            return coursClassroomrepo.sommedesheuresparspec(sp, nv);
        }
        return null;
    }
}
