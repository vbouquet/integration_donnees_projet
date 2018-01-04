package fr.parisnanterre.idd.model;

import java.util.*;

public class BDD {
    private Set<Cours> cours;
    private Set<Enseignant> enseignants;
    private Set<Enseigne> enseignes;
    private Set<Etudiant> etudiants;
    private Set<Inscription> inscriptions;

    public BDD() {
        cours = new LinkedHashSet<>();
        enseignants = new LinkedHashSet<>();
        enseignes = new LinkedHashSet<>();
        etudiants = new LinkedHashSet<>();
        inscriptions = new LinkedHashSet<>();
    }

    public Set<Cours> getCours() {
        return cours;
    }

    public void setCours(Set<Cours> cours) {
        this.cours = cours;
    }

    public Set<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public Set<Enseigne> getEnseignes() {
        return enseignes;
    }

    public void setEnseignes(Set<Enseigne> enseignes) {
        this.enseignes = enseignes;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public void addCours(Cours cours) {
        this.cours.add(cours);
    }

    public void addEnseignant(Enseignant enseignant) {
        this.enseignants.add(enseignant);
    }

    public void addEnseigne(Enseigne enseigne) {
        this.enseignes.add(enseigne);
    }

    public void addEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
    }

    public void addInscription(Inscription inscription) {
        this.inscriptions.add(inscription);
    }

    public Etudiant getSpecificStudent(Long id) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getId_etudiant() == id) {
                return etudiant;
            }
        }
        return null;
    }

    public Enseignant getSpecificTeacher(Long id) {
        for (Enseignant enseignant : enseignants) {
            if (enseignant.getId_enseignant() == id) {
                return enseignant;
            }
        }
        return null;
    }

    public Cours getSpecificCourse(Long id) {
        for (Cours cours : cours) {
            if (cours.getId_cours() == id) {
                return cours;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BDD{");
        sb.append("cours=").append(cours).append("\n");
        sb.append("enseignants=").append(enseignants).append("\n");
        sb.append("enseignes=").append(enseignes).append("\n");
        sb.append("etudiants=").append(etudiants).append("\n");
        sb.append("inscriptions=").append(inscriptions).append("\n");
        sb.append('}');
        return sb.toString();
    }

    /*@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BDD{");
        sb.append("enseignes=").append(enseignes).append("\n");
        sb.append("inscriptions=").append(inscriptions).append("\n");
        sb.append('}');
        return sb.toString();
    }*/
}
