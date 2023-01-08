package tn.esprit.Examen.Service;

import tn.esprit.Examen.Entity.*;

public interface IMyService {
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
    public Classe ajouterClasse(Classe classe);
    public CoursClassroom ajouterCoursClassroom(CoursClassroom coursClassroom,Integer codeClasse);
    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer codeClasse);
    public Integer nbUtilisateursParNiveau(Niveau nv);
    public Integer nbUtilisateursParNiveauUsingCount(Niveau nv);
    public void desaffecterCoursClassroomClasse(Integer idCours);
    public void archiverCoursClassrooms();
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);
}
