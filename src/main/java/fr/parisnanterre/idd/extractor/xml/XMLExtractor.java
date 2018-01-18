package fr.parisnanterre.idd.extractor.xml;

import fr.parisnanterre.idd.extractor.Extractor;
import fr.parisnanterre.idd.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class XMLExtractor implements Extractor {

    private static String SOURCE = "src\\main\\resources\\donnees.xml";
    private Document doc;
    private static BDD dataset = null;
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/d");

    @Override
    public boolean getSession() {
        File xmlFile = new File(SOURCE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean closeSession() {
        return false;
    }

    @Override
    public Set<Etudiant> listStudentInSGBD() {
        Set<Etudiant> sgbdStudents = new LinkedHashSet<>();
        if (dataset == null) {
            buildDataset();
        }
        for (Inscription inscription : dataset.getInscriptions()) {
            try {

                // le libelle n'existe pas dans la source
                if (inscription.getCours().getLibelle().equals("SGBD")) {
                    sgbdStudents.add(inscription.getEtudiant());
                }
            } catch (NullPointerException e) {
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

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    private void buildDataset() {
        getSession();
        dataset = new BDD();
        NodeList nodeList = doc.getElementsByTagName("Enseignant");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            Enseignant enseignant = new Enseignant(Long.parseLong(getTagValue("NumEns", element)),
                    getTagValue("Nom", element),
                    getTagValue("Prenom", element),
                    getTagValue("adresseMail", element));
            dataset.addEnseignant(enseignant);
        }

        nodeList = doc.getElementsByTagName("Etudiant");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            Etudiant etudiant = new Etudiant(Long.parseLong(getTagValue("NumEt", element)),
                    getTagValue("nom", element),
                    getTagValue("Provenance", element),
                    extractAge(getTagValue("dateNaissance", element)),
                    getTagValue("FormationPrecedante", element),
                    getTagValue("Pays_formation_precedante", element),
                    getTagValue("AnneeDebut", element),
                    getTagValue("Niveau_insertion", element));
            dataset.addEtudiant(etudiant);
        }

        nodeList = doc.getElementsByTagName("Cours");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            Cours cours = new Cours(Long.parseLong(getTagValue("ID_cours", element)),
                    getTagValue("Type", element),
                    getTagValue("Niveau", element),
                    Integer.parseInt(getTagValue("Nb_heures", element)));
            dataset.addCours(cours);
        }

        nodeList = doc.getElementsByTagName("Enseigne");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            Enseigne enseigne = new Enseigne(
                    dataset.getSpecificTeacher(Long.parseLong(getTagValue("NumEns", element))),
                    dataset.getSpecificCourse(Long.parseLong(getTagValue("ID_Cours", element))),
                    getTagValue("Annee_universitaire", element),
                    Integer.parseInt(getTagValue("Nb_heures", element)));
            dataset.addEnseigne(enseigne);
        }

        nodeList = doc.getElementsByTagName("Inscription");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            Inscription inscription = new Inscription(
                    dataset.getSpecificStudent(Long.parseLong(getTagValue("NumEt", element))),
                    dataset.getSpecificCourse(Long.parseLong(getTagValue("ID_cours", element))),
                    getTagValue("Annee_universitaire", element),
                    Integer.parseInt(getTagValue("Note_cours", element)));
            dataset.addInscription(inscription);
        }
        closeSession();
    }

    private int extractAge(String date) {
        LocalDate birthDate = LocalDate.parse(date, dateTimeFormatter);
        LocalDate now = LocalDate.now();
        return now.getYear() - birthDate.getYear();
    }
}
