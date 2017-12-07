package fr.parisnanterre.idd.extractor;

public interface Extractor {
    boolean getSession();
    boolean closeSession();
    String listStudentInSGBD();
    String listProfessorCourses();
    String countStudentInM1();
}
