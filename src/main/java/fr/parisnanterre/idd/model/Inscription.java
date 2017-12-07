package fr.parisnanterre.idd.model;

public class Inscription {

    private long fk_etudiant;
    private long fk_cours;
    private String annee;
    private float note;

    public Inscription() {
    }

    public Inscription(long fk_etudiant, long fk_cours, String annee, float note) {
        this.fk_etudiant = fk_etudiant;
        this.fk_cours = fk_cours;
        this.annee = annee;
        this.note = note;
    }

    public long getFk_etudiant() {
        return fk_etudiant;
    }

    public void setFk_etudiant(long fk_etudiant) {
        this.fk_etudiant = fk_etudiant;
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

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
