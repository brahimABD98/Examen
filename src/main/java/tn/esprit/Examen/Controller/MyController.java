package tn.esprit.Examen.Controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Examen.Entity.Classe;
import tn.esprit.Examen.Entity.CoursClassroom;
import tn.esprit.Examen.Entity.Niveau;
import tn.esprit.Examen.Entity.Utilisateur;
import tn.esprit.Examen.Service.IMyService;

@AllArgsConstructor
@NoArgsConstructor
@RestController

public class MyController {

     IMyService myService;

    @PostMapping("/ajouteruser")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        return myService.ajouterUtilisateur(utilisateur);
    }

    @PostMapping("/ajouterclasse")
    public Classe ajouterClasse(@RequestBody Classe classe) {
        return myService.ajouterClasse(classe);
    }

    @PostMapping("/ajoutercoursclassroom/{codeClasse}")
    public CoursClassroom ajouterCoursClasseroom(@RequestBody CoursClassroom coursClassroom, @PathVariable("codeClasse") Integer codeClasse) {
        return myService.ajouterCoursClassroom(coursClassroom, codeClasse);
    }

    @PutMapping("/affecterUser/{iduser}/{codeclasse}")
    public void affecteruserclasse(@PathVariable("iduser") Integer iduser, @PathVariable("codeclasse") Integer codeClasse) {
        myService.affecterUtilisateurClasse(iduser, codeClasse);
    }

    @GetMapping("/getnbruserbyniv/{niv}")
    public int getnbruserbyniv(@PathVariable("niv") Niveau niveau) {
        return myService.nbUtilisateursParNiveau(niveau);
    }

    @GetMapping("/getnbruserbyniv/count/{niv}")
    public int getnbruserbynivcount(@PathVariable("niv") Niveau niveau) {
        return myService.nbUtilisateursParNiveauUsingCount(niveau);
    }
}
