package fr.parisnanterre.idd.extractor;

import fr.parisnanterre.idd.model.BDD;
import fr.parisnanterre.idd.model.Cours;
import fr.parisnanterre.idd.model.Etudiant;

import java.util.Set;

public interface Extractor {
    boolean getSession();
    boolean closeSession();
    Set<Etudiant> listStudentInSGBD();
    Set<Cours> listProfessorCourses();
    Set<Etudiant> countStudentInM1();
}
