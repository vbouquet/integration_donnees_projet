package fr.parisnanterre.idd.main;

import fr.parisnanterre.idd.extractor.Extractor;
import fr.parisnanterre.idd.extractor.excel.ExcelExtractor;
import fr.parisnanterre.idd.extractor.sql.SQLExtractor;
import fr.parisnanterre.idd.extractor.xml.XMLExtractor;
import fr.parisnanterre.idd.mediator.Mediator;

public class Main {
    public static void main(String[] args) {

        /*Extractor extractor = new SQLExtractor();
        extractor.countStudentInM1();*/

        /*Extractor extractor = new ExcelExtractor();
        extractor.countStudentInM1();*/

        /*Extractor extractor = new XMLExtractor();
        extractor.listStudentInSGBD();*/

        Mediator mediator = new Mediator();
        mediator.countStudentInM1();
    }
}
