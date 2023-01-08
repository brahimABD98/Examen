package tn.esprit.Examen.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Examen.Entity.CoursClassroom;
import tn.esprit.Examen.Entity.Niveau;
import tn.esprit.Examen.Entity.Specialite;

@Repository
public interface CoursClassroomrepo extends JpaRepository<CoursClassroom, Integer> {
    @Query("select sum (cc.nbHeures) from CoursClassroom cc where cc.specialite=:specialite and cc.classe.niveau=:niveau ")
    Integer sommedesheuresparspec(@Param("specialite") Specialite specialite, Niveau niveau);
}

