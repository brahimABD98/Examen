package tn.esprit.Examen.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Examen.Entity.CoursClassroom;
@Repository
public interface CoursClassroomrepo extends JpaRepository<CoursClassroom, Integer> {
    
}

