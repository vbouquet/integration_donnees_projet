package fr.parisnanterre.idd.model;

public class Enseigne {

    private Enseignant enseignant;
    private Cours cours;
    private String annee;
    private int heures;

    public Enseigne() {
    }

    public Enseigne(Enseignant enseignant, Cours cours, String annee, int heures) {
        this.enseignant = enseignant;
        this.cours = cours;
        this.annee = annee;
        this.heures = heures;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
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
