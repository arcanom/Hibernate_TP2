package org.example.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany(mappedBy = "fiches")
    Set<FicheDeSoin> ficheDeSoins = new HashSet<>();

    @Override
    public String toString() {
        return "DossierMedical{" +
                "numero=" + numero +
                ", dateCreation=" + dateCreation +
                ", codeAccessPatient='" + codeAccessPatient + '\'' +
                ", patient=" + patient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DossierMedical that = (DossierMedical) o;
        return numero == that.numero && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(codeAccessPatient, that.codeAccessPatient) && Objects.equals(patient, that.patient) && Objects.equals(ficheDeSoins, that.ficheDeSoins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, dateCreation, codeAccessPatient, patient, ficheDeSoins);
    }
}


