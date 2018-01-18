package fr.parisnanterre.idd.extractor.excel;

import fr.parisnanterre.idd.extractor.Extractor;
import fr.parisnanterre.idd.model.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ExcelExtractor implements Extractor {

    private static String SOURCE = "src\\main\\resources\\donnees.xls";
    private HSSFWorkbook workbook;
    private FileInputStream excelFile;
    private static BDD dataset = null;

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
    public Set<Etudiant> listStudentInSGBD() {
        Set<Etudiant> sgbdStudents = new LinkedHashSet<>();
        if (dataset == null) {
            buildDataset();
        }
        for (Inscription inscription : dataset.getInscriptions()) {
            if (inscription.getCours().getLibelle().equals("SGBD")) {
                sgbdStudents.add(inscription.getEtudiant());
            }
        }
        return sgbdStudents;
    }

    @Override
    public Set<Cours> listProfessorCourses() {
        if (dataset == null) {
            buildDataset();
        }
        return dataset.getCours();
    }

    @Override
    public Set<Etudiant> countStudentInM1() {
        if (dataset == null) {
            buildDataset();
        }
        return dataset.getEtudiants().stream()
                .filter(e -> e.getNiveauInsertion()
                        .equals("M1")).collect(Collectors.toSet());
    }

    private void buildDataset() {
        getSession();
        dataset = new BDD();

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            for (Row row : sheet) {

                if (row.getRowNum() != 0) {

                    /*// ID etudiant
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

                    // Get year (sheet name)
                    System.out.println(sheet.getSheetName());*/

                    Cours cours = new Cours((long) row.getCell(7).getNumericCellValue(),
                            row.getCell(8).getStringCellValue(),
                            row.getCell(9).getStringCellValue(),
                            row.getCell(10).getStringCellValue());
                    dataset.addCours(cours);

                    if (Objects.equals(row.getCell(3).getStringCellValue(), "etudiant")) {

                        Etudiant etudiant = new Etudiant((long) row.getCell(0).getNumericCellValue(),
                                row.getCell(1).getStringCellValue(),
                                row.getCell(2).getStringCellValue(),
                                row.getCell(4).getStringCellValue(),
                                row.getCell(5).getStringCellValue(),
                                row.getCell(6).getStringCellValue());
                        dataset.addEtudiant(etudiant);

                        Inscription inscription = new Inscription(etudiant, cours, sheet.getSheetName(),
                                (float) row.getCell(11).getNumericCellValue());

                        dataset.addInscription(inscription);

                    } else if (Objects.equals(row.getCell(3).getStringCellValue(), "enseignant")) {

                        Enseignant enseignant = new Enseignant((long) row.getCell(0).getNumericCellValue(),
                                row.getCell(1).getStringCellValue(),
                                row.getCell(2).getStringCellValue());
                        dataset.addEnseignant(enseignant);

                        Enseigne enseigne = new Enseigne(enseignant, cours, sheet.getSheetName());
                        dataset.addEnseigne(enseigne);
                    }
                }
            }
        }
        closeSession();
    }
}
