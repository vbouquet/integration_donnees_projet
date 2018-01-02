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

    @Override
    public String toString() {
        return "BDD{" +
                "cours=" + cours +
                ", enseignants=" + enseignants +
                ", enseignes=" + enseignes +
                ", etudiants=" + etudiants +
                ", inscriptions=" + inscriptions +
                '}';
    }
}
