package Clase;

public class Rezervare {
    private String numeRezervare;
    private String oraRezervare;

    public Rezervare() {
        this.numeRezervare = null;
        this.oraRezervare = null;
    }

    public Rezervare(String numeRezervare, String oraRezervare) {
        this.numeRezervare = numeRezervare;
        this.oraRezervare = oraRezervare;
    }

    public String getNumeRezervare() {
        return numeRezervare;
    }
    public void setNumeRezervare(String numeRezervare) {
        this.numeRezervare = numeRezervare;
    }
    public String getOraRezervare() {
        return oraRezervare;
    }
    public void setOraRezervare(String oraRezervare) {
        this.oraRezervare = oraRezervare;
    }

    public void afisare() {
        System.out.println("Nume Rezervare: " + numeRezervare);
        System.out.println("Ora Rezervare: " + oraRezervare);
    }
    
    public void pickupRezervare() {
        System.out.println("Rezervarea " + numeRezervare + " a fost ridicată la ora " + oraRezervare);
    }
    public void actualizareOra(String ora) {
        this.oraRezervare = ora;
        System.out.println("Ora rezervării a fost actualizată la: " + oraRezervare);
    }
    
}
