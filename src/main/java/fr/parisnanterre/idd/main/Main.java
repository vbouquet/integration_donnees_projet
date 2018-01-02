package fr.parisnanterre.idd.main;

import fr.parisnanterre.idd.extractor.Extractor;
import fr.parisnanterre.idd.extractor.excel.ExcelExtractor;
import fr.parisnanterre.idd.extractor.sql.SQLExtractor;

public class Main {
    public static void main(String[] args) {
        /*Extractor extractor = new SQLExtractor();
        extractor.listStudentInSGBD();*/

        Extractor extractor = new ExcelExtractor();
        extractor.listStudentInSGBD();
    }
}
