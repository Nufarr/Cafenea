package Clase;

import java.util.ArrayList;
import java.util.Collections;

import Enum.StatusComanda;
import Enum.TipFunctie;

public class Angajat extends Persoana{
    private Integer salariu;
    private Integer numarOreSapt;
    private TipFunctie functie;
    private ArrayList<Comanda> comenziGestionate;
    private Cafenea cafenea;

    public Angajat() {
        super(null, null, null, null);
        this.salariu = null;
        this.numarOreSapt = null;
        this.functie = null;
        comenziGestionate = new ArrayList<>();
    }

    public Angajat(String nume, String prenume, String email, String telefon, Integer salariu, Integer numarOreSapt, TipFunctie functie, Cafenea cafenea) {
        super(nume, prenume, email, telefon);
        this.salariu = salariu;
        this.numarOreSapt = numarOreSapt;
        this.functie = functie;
        this.cafenea = cafenea;
        comenziGestionate = new ArrayList<>();
    }

    public Integer getSalariu() {
        return salariu;
    }

    public void setSalariu(Integer salariu) {
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
        comanda.setAngajat(this);
        comenziGestionate.add(comanda);
        comanda.setStatus(StatusComanda.Preluata);
        System.out.println("Comanda #" + comanda.getIdComanda() + " a fost preluata de " + functie + ".");
        comenziGestionate.sort( (c1, c2) -> c1.getOraRidicare().compareTo(c2.getOraRidicare()));
    }



    // 3. Pregătirea comenzii
    public void pregatireComanda() {
        for (Comanda comanda : comenziGestionate) {
            if(comanda.getStatus() == StatusComanda.Preluata) {
                comanda.setStatus(StatusComanda.In_Pregatire);
                System.out.println("Comanda #" + comanda.getIdComanda() + " este în pregătire.");
                try {
                    Thread.sleep(2000);  // Simulăm pregătirea comenzii
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                comanda.finalizeazaComanda();
                comanda.getClient().notifcare("Comanda cu numarul "+ comanda.getIdComanda() +" a clientului " + comanda.getClient().getNumeIntreg() + " este gata si poate fi ridicata");
            }
        }
    }
    
}
