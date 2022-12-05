package org.example.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OperationAnalyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private Date dateHeureOperation;

    private  String resultat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateHeureOperation() {
        return dateHeureOperation;
    }

    public void setDateHeureOperation(Date dateHeureOperation) {
        this.dateHeureOperation = dateHeureOperation;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public OperationAnalyse() {
    }

    @ManyToMany
    @JoinTable(name="analyses",joinColumns = @JoinColumn(name="oa_id"),inverseJoinColumns=@JoinColumn(name="fc_id"))
    private Set<FicheConsultation> analyses = new HashSet<>();

    public void ajouterFicheConsultation(FicheConsultation fc){
        this.analyses.add(fc);
    }

    public Set<FicheConsultation> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(Set<FicheConsultation> analyses) {
        this.analyses = analyses;
    }


}
