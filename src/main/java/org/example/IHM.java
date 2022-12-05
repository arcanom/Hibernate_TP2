package org.example;

import org.example.entities.Patient;
import org.example.services.PatientService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class IHM {
    public static Scanner sc = new Scanner(System.in);

    public static PatientService ps = new PatientService();
    public static  void affichage(){
        System.out.println("1- Créer un patient");
        System.out.println("2- Créer  un dossier médical" );
        System.out.println("3- Exit");
    }

    public static void main() throws ParseException {

        affichage();

        int choix = sc.nextInt();
        while(choix !=0){
            switch (choix){
                case 1:
                    createPatient();
                    break;
                case 2:
                    break;
            }
        }


    }

    public static void createPatient() throws ParseException {
        System.out.println("Numero de sécurité sociale");
        String nss = sc.next();
        System.out.println("Prenom");
        String prenom = sc.next();
        System.out.println("Nom");
        String nom = sc.next();
        System.out.println("Date de Naissance");
        String dateNaissance =  sc.next();
        Date DateNaissance = new SimpleDateFormat("dd-mm-YYYY").parse(dateNaissance);
        System.out.println("Sexe");
        char sexe = sc.next().charAt(1);
        sc.nextLine();
        String addresse = sc.nextLine();
        System.out.println("Numero de téléphone");
        int telephone = sc.nextInt();
        Patient patient = new Patient();
        patient.setnSS(nss);
        patient.setPrenom(prenom);
        patient.setNom(nom);
        patient.setDateNaissance(DateNaissance);
        patient.setSexe(sexe);
        patient.setAddresse(addresse);
        patient.setNumTelephone(telephone);
        if(ps.createPatient(patient)){
            System.out.println("Patient crée");
        } else {
            System.out.println("Erreur de création ");
        }

    }

    public static void createDossierMedical() {
        System.out.println("Numero de securite sociale");
        int nss = sc.nextInt();
        Patient p = ps.findbyId(nss);
        String codeAccessPatient = "GTyuzertvyzragfz6515";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String dateCreation = formatter.format(date);

    }
}
