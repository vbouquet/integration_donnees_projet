package fr.parisnanterre.idd.extractor.sql;

import com.sun.rowset.CachedRowSetImpl;
import fr.parisnanterre.idd.extractor.Extractor;
import fr.parisnanterre.idd.model.BDD;
import fr.parisnanterre.idd.model.Cours;
import fr.parisnanterre.idd.model.Etudiant;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;

public class SQLExtractor implements Extractor {

    private Connection connection = null;
    private static final String databaseName = "idd";
    private static final String user = "root";
    private static final String password = "root";
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

    @Override
    public boolean getSession() {
        if (connection != null)
            return true;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    String.format("jdbc:mysql://localhost/%s?user=%s&password=%s",
                            databaseName, user, password));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean closeSession() {
        try {
            if (connection != null)
                connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Set<Etudiant> listStudentInSGBD() {

        ResultSet resultSet = getResult(
                "SELECT * " +
                        "FROM ETUDIANT E, INSCRIPTION I, COURS C " +
                        "WHERE C.NUMCOURS = I.NUMCOURS " +
                        "AND E.ID_ETUDIANT = I.NUMET " +
                        "AND C.LIBELE = 'SGBD'");
        if (resultSet == null)
            return null;

        try {
            Set<Etudiant> students = new LinkedHashSet<>();

            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setId_etudiant(Long.parseLong(resultSet.getString("ID_etudiant")));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                etudiant.setProvenance(resultSet.getString("provenance"));
                etudiant.setFormationPrecedente(resultSet.getString("Formation_precedente"));
                etudiant.setPaysFormationPrecedente(resultSet.getString("Pays_Formation_precedente"));
                etudiant.setAnneeDebut(resultSet.getString("Annee_debut"));
                etudiant.setNiveauInsertion(resultSet.getString("Niveau_inscription"));
                etudiant.setAge(extractAge(resultSet.getString("dateNaissance")));
                students.add(etudiant);
            }
            System.out.println(students);
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Cours> listProfessorCourses() {
        ResultSet resultSet = getResult(
                "SELECT * " +
                        "FROM COURS");
        if (resultSet == null)
            return null;
        try {
            Set<Cours> courses = new LinkedHashSet<>();

            while (resultSet.next()) {
                Cours cours = new Cours();
                cours.setId_cours(Long.parseLong(resultSet.getString("NumCours")));
                cours.setLibelle(resultSet.getString("libele"));
                cours.setNiveau(resultSet.getString("niveau"));
                cours.setType(resultSet.getString("type"));
                courses.add(cours);
            }
            System.out.println(courses);
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int countStudentInM1() {

        ResultSet resultSet = getResult(
                "SELECT COUNT(*) AS COUNT " +
                        "FROM ETUDIANT " +
                        "WHERE Niveau_inscription = 'M1'");

        if (resultSet == null)
            return 0;

        try {
            if (resultSet.next()) {
                System.out.println(resultSet.getInt("COUNT"));
                return resultSet.getInt("COUNT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int extractAge(String date) {
        LocalDate birthDate = LocalDate.parse(date, dateTimeFormatter);
        LocalDate now = LocalDate.now();
        return now.getYear() - birthDate.getYear();
    }

    private ResultSet getResult(String sql) {
        if (!this.getSession())
            return null;

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            CachedRowSet cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            return cachedRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
