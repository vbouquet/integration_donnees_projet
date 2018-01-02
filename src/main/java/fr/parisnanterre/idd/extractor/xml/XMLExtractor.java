package fr.parisnanterre.idd.extractor.xml;

import fr.parisnanterre.idd.extractor.Extractor;
import fr.parisnanterre.idd.model.BDD;
import fr.parisnanterre.idd.model.Cours;
import fr.parisnanterre.idd.model.Etudiant;

import java.util.Set;

public class XMLExtractor implements Extractor {
    @Override
    public boolean getSession() {
        //TODO connect to SQL database
        return false;
    }

    @Override
    public boolean closeSession() {
        //TODO close session
        return false;
    }

    @Override
    public Set<Etudiant> listStudentInSGBD () {
        //TODO Lister les étudiants inscrits en SGBD
        return null;
    }

    @Override
    public Set<Cours> listProfessorCourses() {
        return null;
    }

    @Override
    public int countStudentInM1() {
        //TODO Count student in M1
        return 0;
    }
}
