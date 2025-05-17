package Clase;

import java.util.ArrayList;
import java.util.Collections;

import Enum.StatusComanda;
import Enum.TipFunctie;

public class Angajat extends Persoana{
    private Float salariu;
    private Integer numarOreSapt;
    private TipFunctie functie;
    private ArrayList<Comanda> comenziGestionate;

    public Angajat() {
        super(null, null, null, null);
        this.salariu = null;
        this.numarOreSapt = null;
        this.functie = null;
        comenziGestionate = new ArrayList<>();
    }

    public Angajat(String nume, String prenume, String email, String telefon, Float salariu, Integer numarOreSapt, TipFunctie functie) {
        super(nume, prenume, email, telefon);
        this.salariu = salariu;
        this.numarOreSapt = numarOreSapt;
        this.functie = functie;
        comenziGestionate = new ArrayList<>();
    }

    public Float getSalariu() {
        return salariu;
    }

    public void setSalariu(Float salariu) {
        this.salariu = salariu;
    }

    public Integer getNumarOreSapt() {
        return numarOreSapt;
    }

    public void setNumarOreSapt(Integer numarOreSapt) {
        this.numarOreSapt = numarOreSapt;
    }

    public TipFunctie getFunctie()  {
        return functie;
    }

    public void setFunctie(TipFunctie functie) {
        this.functie = functie;
    }

    public ArrayList<Comanda> getComenziGestionate() {
        return comenziGestionate;
    }

    public void afisareAngajati() {
        super.afisare();
        System.out.println("Angajat:");
        System.out.println("Functie: " + functie);
        System.out.println("Salariu: " + salariu);
        System.out.println("Ore pe saptamana: " + numarOreSapt);
    }


    public void preluareComanda(Comanda comanda) {
        comenziGestionate.add(comanda);
        comanda.setStatus(StatusComanda.Preluata);
        System.out.println("Comanda #" + comanda.getIdComanda() + " a fost preluata de " + functie + ".");
    }



    // 3. Pregătirea comenzii
    public void pregatireComanda() {
        // Sortăm comenzile direct în funcția de pregătire pe baza orei de ridicare
        Collections.sort(comenziGestionate, (comanda1, comanda2) -> comanda1.getOraRidicare().compareTo(comanda2.getOraRidicare()));

        // Procesăm comenzile în ordinea corectă
        for (Comanda comanda : comenziGestionate) {
            comanda.setStatus(StatusComanda.In_Pregatire);
            System.out.println("Comanda #" + comanda.getIdComanda() + " este în pregătire.");
            try {
                Thread.sleep(2000);  // Simulăm pregătirea comenzii
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            comanda.finalizeazaComanda();
        }
    }
    
}
