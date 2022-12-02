package org.example.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DossierMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int numero;

    private Date dateCreation;

    private String codeAccessPatient ;

    public DossierMedical() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getCodeAccessPatient() {
        return codeAccessPatient;
    }

    public void setCodeAccessPatient(String codeAccessPatient) {
        this.codeAccessPatient = codeAccessPatient;
    }

    @OneToOne(mappedBy = "dossierMedical")
    private  Patient patient;

    @Override
    public String toString() {
        return "DossierMedical{" +
                "numero=" + numero +
                ", dateCreation=" + dateCreation +
                ", codeAccessPatient='" + codeAccessPatient + '\'' +
                ", patient=" + patient +
                '}';
    }
}


