package fr.parisnanterre.idd.model;

public class Etudiant {

    private long id_etudiant;
    private String nom;
    private String prenom;
    private String provenance;
    private String formationPrecedente;
    private String paysFormationPrecedente;
    private String anneeDebut;
    private int age;
    private String niveauInsertion;

    public Etudiant() {
    }

    public Etudiant(long id_etudiant, String nom, String prenom, String provenance, String formationPrecedente,
                    String paysFormationPrecedente, String anneeDebut, int age, String niveauInsertion) {
        this.id_etudiant = id_etudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.provenance = provenance;
        this.formationPrecedente = formationPrecedente;
        this.paysFormationPrecedente = paysFormationPrecedente;
        this.anneeDebut = anneeDebut;
        this.age = age;
        this.niveauInsertion = niveauInsertion;
    }

    public Etudiant(long id_etudiant, String nom, String prenom, String provenance, String formationPrecedente,
                    String niveauInsertion) {
        this.id_etudiant = id_etudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.provenance = provenance;
        this.formationPrecedente = formationPrecedente;
        this.niveauInsertion = niveauInsertion;
    }

    public Etudiant(long id_etudiant, String nom, String provenance, int age, String formationPrecedente,
                    String paysFormationPrecedente, String anneeDebut, String niveauInsertion) {
        this.id_etudiant = id_etudiant;
        this.nom = nom;
        this.provenance = provenance;
        this.age = age;
        this.formationPrecedente = formationPrecedente;
        this.paysFormationPrecedente = paysFormationPrecedente;
        this.anneeDebut = anneeDebut;
        this.niveauInsertion = niveauInsertion;
    }

    public long getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(long id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getFormationPrecedente() {
        return formationPrecedente;
    }

    public void setFormationPrecedente(String formationPrecedente) {
        this.formationPrecedente = formationPrecedente;
    }

    public String getPaysFormationPrecedente() {
        return paysFormationPrecedente;
    }

    public void setPaysFormationPrecedente(String paysFormationPrecedente) {
        this.paysFormationPrecedente = paysFormationPrecedente;
    }

    public String getAnneeDebut() {
        return anneeDebut;
    }

    public void setAnneeDebut(String anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNiveauInsertion() {
        return niveauInsertion;
    }

    public void setNiveauInsertion(String niveauInsertion) {
        this.niveauInsertion = niveauInsertion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("Etudiant {\n");
        sb.append("id = ").append(id_etudiant).append("\n");
        sb.append("prenom = ").append(prenom).append("\n");
        sb.append("nom = ").append(nom).append("\n");
        sb.append("age = ").append(age).append("\n");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Etudiant etudiant = (Etudiant) o;

        return id_etudiant == etudiant.id_etudiant;
    }

    @Override
    public int hashCode() {
        return (int) (id_etudiant ^ (id_etudiant >>> 32));
    }
}
