package fr.parisnanterre.idd.extractor.xml;

import fr.parisnanterre.idd.extractor.Extractor;
import fr.parisnanterre.idd.model.BDD;
import fr.parisnanterre.idd.model.Cours;
import fr.parisnanterre.idd.model.Enseignant;
import fr.parisnanterre.idd.model.Etudiant;
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
import java.util.Set;

public class XMLExtractor implements Extractor {

    private static String SOURCE = "src\\main\\resources\\donnees.xml";
    private Document doc;
    private static BDD dataset = null;

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
    public Set<Etudiant> listStudentInSGBD () {
        if (dataset == null) {
            buildDataset();
        }
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

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
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
        System.out.println(dataset);
        closeSession();
    }
}
