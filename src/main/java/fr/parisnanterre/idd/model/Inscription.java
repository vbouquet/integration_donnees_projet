package fr.parisnanterre.idd.model;

public class Inscription {

    private Etudiant etudiant;
    private Cours cours;
    private String annee;
    private float note;

    public Inscription() {
    }

    public Inscription(Etudiant etudiant, Cours cours, String annee, float note) {
        this.etudiant = etudiant;
        this.cours = cours;
        this.annee = annee;
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
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

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Inscription{");
        sb.append("etudiant=").append(etudiant).append("\n");
        sb.append("cours=").append(cours).append("\n");
        sb.append("annee='").append(annee).append('\'').append("\n");
        sb.append("note=").append(note).append("\n");
        sb.append('}');
        return sb.toString();
    }
}
