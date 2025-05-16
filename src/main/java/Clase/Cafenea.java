package Clase;
import java.util.ArrayList;
import java.util.List;

import Enum.Locatie;

public class Cafenea {
    private String nume;
    private Locatie adresa;
    private String program;
    private List<Angajat> angajati;  // Lista de angajați
    private List<Client> clienti;    // Lista de clienți

    public Cafenea() {
        this.nume = null;
        this.adresa = null;
        this.program = null;
    }
    public Cafenea(String nume, Locatie adresa, String program) {
        this.nume = nume;
        this.adresa = adresa;
        this.program = program;
        this.angajati = new ArrayList<>();
        this.clienti = new ArrayList<>();
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public Locatie getAdresa() {
        return adresa;
    }
    public void setAdresa(Locatie adresa) {
        this.adresa = adresa;
    }
    public String getProgram() {
        return program;
    }
    public void setProgram(String program) {
        this.program = program;
    }
    // Metode pentru gestionarea angajaților
    public void adaugaAngajat(Angajat angajat) {
        angajati.add(angajat);
        System.out.println("Angajatul " + angajat.getNume() + " a fost adăugat la cafenea.");
    }

    public void afisareAngajati() {
        System.out.println("Angajații din cafenea " + nume + ":");
        for (Angajat angajat : angajati) {
            angajat.afisareAngajati();
        }
    }
     // Metode pentru gestionarea clienților
    public void adaugaClient(Client client) {
        clienti.add(client);
        System.out.println("Clientul " + client.getNume() + " a fost adăugat la cafenea.");
    }

    public void afisareClienti() {
        System.out.println("Clienții din cafenea " + nume + ":");
        for (Client client : clienti) {
            System.out.println(client.getNume());
        }
    }

    public void afisare() {
        System.out.println("Nume Cafenea: " + nume);
        System.out.println("Adresa Cafenea: " + adresa);
        System.out.println("Program Cafenea: " + program);
    }
    public void modificareProgram(String program) {
        this.program = program;
    }

    //TESTAT!
    public boolean esteDeschisaAcum(String ora) { // ora in format 07:00 - 21:00
        if(Integer.parseInt(ora.substring(0, 2)) < Integer.parseInt(program.substring(0, 2))){
            return false; //ora mai mica decat ora de deschidere
        } else if(Integer.parseInt(ora.substring(0, 2)) > Integer.parseInt(program.substring(6, 8)) ){
            return false; //ora mai mare decat ora de inchidere
        } else if(Integer.parseInt(ora.substring(0, 2)) == Integer.parseInt(program.substring(0, 2))) { //aceeasi ora cu ora de deshidere
            if(Integer.parseInt(ora.substring(3, 5)) < Integer.parseInt(program.substring(3, 5))) //minute mai mici decat cele de deschidere
                return false;
        } else if(Integer.parseInt(ora.substring(0, 2)) == Integer.parseInt(program.substring(6, 8))) //aceeasi ora cu ora de inchidere
            if(Integer.parseInt(ora.substring(3, 5)) >= Integer.parseInt(program.substring(9, 11))){  //minute mai mare decat cele de inchidere
                return false;
            }
        return true;
    }
}
