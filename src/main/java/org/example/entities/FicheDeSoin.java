package org.example.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class FicheDeSoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroFiche;

    private Date dateCreation;

    private  String agentCreateur;

    private String addresseCreateur;

    public FicheDeSoin() {
    }

    public int getNumeroFiche() {
        return numeroFiche;
    }

    public void setNumeroFiche(int numeroFiche) {
        this.numeroFiche = numeroFiche;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAgentCreateur() {
        return agentCreateur;
    }

    public void setAgentCreateur(String agentCreateur) {
        this.agentCreateur = agentCreateur;
    }

    public String getAddresseCreateur() {
        return addresseCreateur;
    }

    public void setAddresseCreateur(String addresseCreateur) {
        this.addresseCreateur = addresseCreateur;
    }
}
