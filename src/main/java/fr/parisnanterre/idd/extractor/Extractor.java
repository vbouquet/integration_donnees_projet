package fr.parisnanterre.idd.extractor;

import fr.parisnanterre.idd.model.BDD;

public interface Extractor {
    boolean getSession();
    boolean closeSession();
    BDD listStudentInSGBD();
    BDD listProfessorCourses();
    BDD countStudentInM1();
}
