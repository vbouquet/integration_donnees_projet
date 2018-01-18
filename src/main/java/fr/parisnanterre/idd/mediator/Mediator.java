package fr.parisnanterre.idd.mediator;

import fr.parisnanterre.idd.extractor.Extractor;
import fr.parisnanterre.idd.extractor.excel.ExcelExtractor;
import fr.parisnanterre.idd.extractor.sql.SQLExtractor;
import fr.parisnanterre.idd.extractor.xml.XMLExtractor;
import fr.parisnanterre.idd.model.Cours;
import fr.parisnanterre.idd.model.Etudiant;

import java.util.Set;

public class Mediator {

    private Extractor excelExtractor;
    private Extractor xmlExtractor;
    private Extractor sqlExtractor;

    public Mediator() {
        this.excelExtractor = new ExcelExtractor();
        this.xmlExtractor = new XMLExtractor();
        this.sqlExtractor = new SQLExtractor();
    }

    public Set<Etudiant> listStudentInSGBD() {
        Set<Etudiant> studentsInSGBD = this.excelExtractor.listStudentInSGBD();
        studentsInSGBD.addAll(this.xmlExtractor.listStudentInSGBD());
        studentsInSGBD.addAll(this.sqlExtractor.listStudentInSGBD());
        System.out.println("Students in SGBD  : " + studentsInSGBD);
        return studentsInSGBD;
    }

    public Set<Cours> listProfessorCourses() {
        Set<Cours> courses = this.excelExtractor.listProfessorCourses();
        courses.addAll(this.xmlExtractor.listProfessorCourses());
        courses.addAll(this.sqlExtractor.listProfessorCourses());
        System.out.println("Courses : " + courses);
        return courses;
    }

    public int countStudentInM1() {
        Set<Etudiant> studentsInM1 = this.excelExtractor.countStudentInM1();
        studentsInM1.addAll(this.xmlExtractor.countStudentInM1());
        studentsInM1.addAll(this.sqlExtractor.countStudentInM1());
        System.out.println("Number of students in M1 : " + studentsInM1.size());
        return studentsInM1.size();
    }
}
