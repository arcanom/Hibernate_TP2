package org.example.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name="discriminator", discriminatorType = DiscriminatorType.INTEGER )
public abstract class FicheDeSoin {

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
    @ManyToMany
    @JoinTable(name="fiches",joinColumns = @JoinColumn(name="fds_id"),inverseJoinColumns=@JoinColumn(name="dm_id"))
    Set<DossierMedical> fiches = new HashSet<>();

    private  void ajouterFiches(DossierMedical dm){
        this.fiches.add(dm);
    }

    @ManyToOne
    @JoinColumn(name="fichespayes")
    private FicheDeSoin fichespayes;

    @OneToMany(mappedBy ="fichespayes")
    private Set<FicheDeSoin> ficheDeSoins = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FicheDeSoin that = (FicheDeSoin) o;
        return numeroFiche == that.numeroFiche && Objects.equals(dateCreation, that.dateCreation) && Objects.equals(agentCreateur, that.agentCreateur) && Objects.equals(addresseCreateur, that.addresseCreateur) && Objects.equals(fiches, that.fiches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroFiche, dateCreation, agentCreateur, addresseCreateur, fiches);
    }
}
