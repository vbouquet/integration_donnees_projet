package fr.parisnanterre.idd.extractor.excel;

import fr.parisnanterre.idd.extractor.Extractor;
import fr.parisnanterre.idd.model.BDD;
import fr.parisnanterre.idd.model.Enseignant;
import fr.parisnanterre.idd.model.Etudiant;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class ExcelExtractor implements Extractor {

    private static String SOURCE = "src\\main\\resources\\donnees.xls";
    private HSSFWorkbook workbook;
    private FileInputStream excelFile;
    private BDD dataset = null;

    @Override
    public boolean getSession() {
        try {
            excelFile = new FileInputStream(new File(SOURCE));
            workbook = new HSSFWorkbook(excelFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean closeSession() {
        try {
            excelFile.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public BDD listStudentInSGBD() {
        //TODO Lister les étudiants inscrits en SGBD
        buildDataset();

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

    private void buildDataset() {
        getSession();
        dataset = new BDD();

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            for (Row row : sheet) {

                if (row.getRowNum() != 0) {

                    // ID etudiant
                    System.out.println(row.getCell(0));

                    // Nom
                    System.out.println(row.getCell(1));

                    // Prenom
                    System.out.println(row.getCell(2));

                    // Statut
                    System.out.println(row.getCell(3));

                    // Provenance
                    System.out.println(row.getCell(4));

                    // Formation precedente
                    System.out.println(row.getCell(5));

                    // Niveau insertion
                    System.out.println(row.getCell(6));

                    // ID cours
                    System.out.println(row.getCell(7));

                    // Libelle cours
                    System.out.println(row.getCell(8));

                    // Type cours
                    System.out.println(row.getCell(9));

                    // Niveau cours
                    System.out.println(row.getCell(10));

                    // Note
                    System.out.println(row.getCell(11));

                    if (Objects.equals(row.getCell(3).getStringCellValue(), "etudiant")) {

                        dataset.addEtudiant(new Etudiant((long) row.getCell(0).getNumericCellValue(),
                                row.getCell(1).getStringCellValue(),
                                row.getCell(2).getStringCellValue(),
                                row.getCell(4).getStringCellValue(),
                                row.getCell(5).getStringCellValue(),
                                row.getCell(6).getStringCellValue()));

                    } else if (Objects.equals(row.getCell(3).getStringCellValue(), "enseignant")) {

                        dataset.addEnseignant(new Enseignant((long) row.getCell(0).getNumericCellValue(),
                                row.getCell(1).getStringCellValue(),
                                row.getCell(2).getStringCellValue()));

                    }
                }
            }
        }
        System.out.println(dataset);
    }
}
