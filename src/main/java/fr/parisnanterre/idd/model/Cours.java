package fr.parisnanterre.idd.model;

public class Cours {

    private long id_cours;
    private String libelle;
    private String type;
    private String niveau;
    private int heures;

    public Cours() {
    }

    public Cours(long id_cours, String libelle, String type, String niveau) {
        this.id_cours = id_cours;
        this.libelle = libelle;
        this.type = type;
        this.niveau = niveau;
    }

    public Cours(long id_cours, String type, String niveau, int heures) {
        this.id_cours = id_cours;
        this.type = type;
        this.niveau = niveau;
        this.heures = heures;
    }

    public long getId_cours() {
        return id_cours;
    }

    public void setId_cours(long id_cours) {
        this.id_cours = id_cours;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cours{");
        sb.append("id_cours=").append(id_cours).append("\n");
        sb.append("libelle='").append(libelle).append('\'').append("\n");
        sb.append("type='").append(type).append('\'').append("\n");
        sb.append("niveau='").append(niveau).append('\'').append("\n");
        sb.append("heures=").append(heures).append("\n");
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cours cours = (Cours) o;

        return id_cours == cours.id_cours;
    }

    @Override
    public int hashCode() {
        return (int) (id_cours ^ (id_cours >>> 32));
    }
}
