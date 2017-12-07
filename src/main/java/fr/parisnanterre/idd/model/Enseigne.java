package fr.parisnanterre.idd.model;

public class Enseigne {

    private long fk_enseignant;
    private long fk_cours;
    private String annee;
    private int heures;

    public Enseigne() {
    }

    public Enseigne(long fk_enseignant, long fk_cours, String annee, int heures) {
        this.fk_enseignant = fk_enseignant;
        this.fk_cours = fk_cours;
        this.annee = annee;
        this.heures = heures;
    }

    public long getFk_enseignant() {
        return fk_enseignant;
    }

    public void setFk_enseignant(long fk_enseignant) {
        this.fk_enseignant = fk_enseignant;
    }

    public long getFk_cours() {
        return fk_cours;
    }

    public void setFk_cours(long fk_cours) {
        this.fk_cours = fk_cours;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }
}
