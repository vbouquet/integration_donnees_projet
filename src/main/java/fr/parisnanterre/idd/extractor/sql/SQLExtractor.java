package fr.parisnanterre.idd.extractor.sql;

import com.sun.rowset.CachedRowSetImpl;
import fr.parisnanterre.idd.extractor.Extractor;
import fr.parisnanterre.idd.model.BDD;
import fr.parisnanterre.idd.model.Etudiant;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;

public class SQLExtractor implements Extractor {
    private Connection connection = null;
    private static final String databaseName = "idd";
    private static final String user = "root";
    private static final String password = "root";

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

    private ResultSet getResult(String sql) {
        if ( !this.getSession())
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

    @Override
    public BDD listStudentInSGBD () {

        ResultSet resultSet = getResult(
                "SELECT DISTINCT E.NOM, E.PRENOM " +
                        "FROM ETUDIANT E, INSCRIPTION I, COURS C " +
                        "WHERE C.NUMCOURS = I.NUMCOURS " +
                        "AND E.ID_ETUDIANT = I.NUMET " +
                        "AND C.LIBELE = 'SGBD'");
        if (resultSet == null)
            return null;

        try {
            BDD bdd = new BDD();

            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                System.out.println(etudiant);
                bdd.getEtudiants().add(etudiant);
            }
            return bdd;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
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
}
