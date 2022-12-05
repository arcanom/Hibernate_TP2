package org.example.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("2")
public class FicheConsultation extends FicheDeSoin {
    private String CompteRendu;

    public String getCompteRendu() {
        return CompteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        CompteRendu = compteRendu;
    }

    public FicheConsultation() {
    }


    @OneToOne(mappedBy = "origineFiche")
    private Consultation consultation;

    @OneToMany(mappedBy ="prescription")
    private List<Prescription> prescriptions;



    @ManyToMany(mappedBy = "analyses")
    private Set<OperationAnalyse> operationAnalyses =new HashSet<>();



    public void ajouterOperationAnalyse(OperationAnalyse oa){
        this.operationAnalyses.add(oa);
    }
    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
