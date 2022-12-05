package org.example.interfaces;

import org.example.entities.DossierMedical;
import org.example.entities.Patient;

public interface IDAOPatient {

   boolean createPatient(Patient p);

   Patient findbyId(int id );

   boolean createDossierMedical(DossierMedical dm);

}
