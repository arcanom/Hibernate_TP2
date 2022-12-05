package org.example.services;

import org.example.entities.DossierMedical;
import org.example.entities.Patient;
import org.example.interfaces.IDAOPatient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PatientService implements IDAOPatient {
    private StandardServiceRegistry registre;

    private SessionFactory sessionFactory;

    public PatientService(){
        registre = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
    }

    @Override
    public boolean createPatient(Patient p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Patient findbyId(int id) {
        Patient patient = null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        patient = (Patient) session.get(Patient.class,id);
        session.getTransaction();
        return patient;
    }

    @Override
    public boolean createDossierMedical(DossierMedical dm) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(dm);
        session.getTransaction().commit();
        return true;
    }
}
