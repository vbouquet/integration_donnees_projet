package fr.parisnanterre.idd.extractor.xml;

import fr.parisnanterre.idd.extractor.Extractor;
import fr.parisnanterre.idd.model.BDD;

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
    public BDD listStudentInSGBD () {
        //TODO Lister les étudiants inscrits en SGBD
        return null;
    }

    @Override
    public BDD listProfessorCourses() {
        return null;
    }

    @Override
    public BDD countStudentInM1() {
        //TODO Count student in M1
        return null;
    }
}
