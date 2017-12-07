package fr.parisnanterre.idd.extractor.xml;

import fr.parisnanterre.idd.extractor.Extractor;

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
    public String listStudentInSGBD () {
        //TODO Lister les étudiants inscrits en SGBD
        return null;
    }

    @Override
    public String listProfessorCourses() {
        return null;
    }

    @Override
    public String countStudentInM1() {
        //TODO Count student in M1
        return null;
    }
}
