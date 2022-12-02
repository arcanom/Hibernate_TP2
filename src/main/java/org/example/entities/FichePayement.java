package org.example.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("1")
public class FichePayement extends FicheDeSoin {


    private Date dateExigibiliteP;

    private Date datePayement;

    private double montantPaye;

    private  boolean indicateurPayement;

    public Date getDateExigibiliteP() {
        return dateExigibiliteP;
    }

    public void setDateExigibiliteP(Date dateExigibiliteP) {
        this.dateExigibiliteP = dateExigibiliteP;
    }

    public Date getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(Date datePayement) {
        this.datePayement = datePayement;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public boolean isIndicateurPayement() {
        return indicateurPayement;
    }

    public void setIndicateurPayement(boolean indicateurPayement) {
        this.indicateurPayement = indicateurPayement;
    }

    public FichePayement() {
    }
}
