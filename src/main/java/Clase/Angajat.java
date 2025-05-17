package Clase;

import java.util.ArrayList;

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

    // // 2. Încasarea sumei
    // public void incasareSuma(Client client, double suma) {
    //     // logica de plată simplificată
    //     System.out.println("Angajatul " + functie + " a încasat suma de " + suma + " RON de la clientul " + client.getNume() + ".");
    //     client.notifica("Plata de " + suma + " RON a fost înregistrată.");
    // }

    // 3. Pregătirea comenzii
    public void pregatireComanda(Comanda comanda) {
        // Modifică statusul comenzii la "In_Preparare"
        comanda.setStatus(StatusComanda.In_Pregatire);
        System.out.println("Comanda #" + comanda.getIdComanda() + " este în pregătire.");

        // Simulăm pregătirea comenzii
        try {
            Thread.sleep(2000);  // Întârziere de 2 secunde pentru a simula timpul de pregătire
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // După pregătirea comenzii, schimbăm statusul la "Finalizata"
        comanda.finalizeazaComanda();
    }
    
}
