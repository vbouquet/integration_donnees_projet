package fr.parisnanterre.idd.model;

import java.util.List;

public class BDD {
    public List<Cours> cours;
    public List<Enseignant> enseignants;
    public List<Enseigne> enseignes;
    public List<Etudiant> etudiants;
    public List<Inscription> inscriptions;

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public List<Enseigne> getEnseignes() {
        return enseignes;
    }

    public void setEnseignes(List<Enseigne> enseignes) {
        this.enseignes = enseignes;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
