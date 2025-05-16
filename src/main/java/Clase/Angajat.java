package Clase;

import Enum.TipFunctie;

public class Angajat extends Persoana{
    private Float salariu;
    private Integer numarOreSapt;
    private TipFunctie functie;

    public Angajat() {
        super(null, null, null, null);
        this.salariu = null;
        this.numarOreSapt = null;
        this.functie = null;
    }

    public Angajat(String nume, String prenume, String email, String telefon, Float salariu, Integer numarOreSapt, TipFunctie functie) {
        super(nume, prenume, email, telefon);
        this.salariu = salariu;
        this.numarOreSapt = numarOreSapt;
        this.functie = functie;
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


    // 1. Preluarea comenzii de la un client
    // public void preluareComanda(Client client, Comanda comanda) {
    //     comenziGestionate.add(comanda);
    //     comanda.setStatus(StatusComanda.InAsteptare);
    //     System.out.println("Comanda #" + comanda.getNumarComanda() + " a fost preluata de " + functie + ".");
    //     client.notifica("Comanda ta a fost preluată de un angajat.");
    // }

    // // 2. Încasarea sumei
    // public void incasareSuma(Client client, double suma) {
    //     // logica de plată simplificată
    //     System.out.println("Angajatul " + functie + " a încasat suma de " + suma + " RON de la clientul " + client.getNume() + ".");
    //     client.notifica("Plata de " + suma + " RON a fost înregistrată.");
    // }

    // // 3. Pregătirea comenzii
    // public void pregatesteComanda(Comanda comanda) {
    //     if (comenziGestionate.contains(comanda) && comanda.getStatus() == StatusComanda.InAsteptare) {
    //         System.out.println("Comanda #" + comanda.getNumarComanda() + " este pregătită.");
    //         comanda.setStatus(StatusComanda.Finalizata);
    //     } else {
    //         System.out.println("Comanda nu este în așteptare sau nu aparține acestui angajat.");
    //     }
    // }

    // // 4. Trimiterea unei notificări
    // public void trimiteNotificare(Client client, String mesaj) {
    //     System.out.println("Notificare trimisă clientului " + client.getNume() + ": " + mesaj);
    //     client.notifica(mesaj);
    // }
    
}
