package Clase;

import java.util.ArrayList;

public class Client extends Persoana {
    private int numarComanda;
    private ArrayList<Comanda> istoricComenzi;
    private ArrayList<Oferte> oferte;  // Lista de oferte
    private ArrayList<Rezervare> rezervari;  // Lista de rezervări

    public Client(String nume, String prenume, String email, String telefon) {
        super(nume, prenume, email, telefon);
        this.numarComanda = 0;
        this.istoricComenzi = new ArrayList<>();
        this.oferte = new ArrayList<>(); 
        this.rezervari= new ArrayList<>(); // Initializare lista de oferte
    }
    public int getNumarComanda() {
        return numarComanda;
    }

    public void setNumarComanda(int numarComanda) {
        this.numarComanda = numarComanda;
    }

    public ArrayList<Comanda> getIstoricComenzi() {
        return istoricComenzi;
    }

    public void setIstoricComenzi(ArrayList<Comanda> istoricComenzi) {
        this.istoricComenzi = istoricComenzi;
    }

    public void creeazaRezervare(String oraRezervare) {
        Rezervare rezervare = new Rezervare(nume + " " + prenume, oraRezervare);
        rezervari.add(rezervare);
        System.out.println("Rezervarea a fost creată cu succes.");
    }

    public void afiseazaRezervare() {
        if (rezervari.isEmpty()) {
            System.out.println("Nu aveți rezervări.");
        } else {
            System.out.println("Rezervările disponibile:");
            for (Rezervare rezervare : rezervari) {
                rezervare.afisare();
            }
        }
    }


// Metode pentru gestionarea ofertelor
    public void adaugaOferta(Oferte oferta) {
        this.oferte.add(oferta);
        System.out.println("Oferta adăugată cu succes.");
    }

    public void afiseazaOferte() {
        if (oferte.isEmpty()) {
            System.out.println("Nu aveți oferte disponibile.");
        } else {
            System.out.println("Ofertele disponibile:");
            for (Oferte oferta : oferte) {
                oferta.afisare();
            }
        }
    }






    public void creareCont() {
        System.out.println("Cont creat pentru clientul: " + prenume + " " + nume);
    }

    public void plaseazaComanda(Comanda comanda) {
        numarComanda++;
        comanda.setIdComanda(numarComanda);
        istoricComenzi.add(comanda);
        System.out.println("Comanda plasata cu succes.");
    }

    public void ridicaComanda() {
        if (numarComanda == 0) {
            System.out.println("Nu exista comenzi de ridicat.");
        } else {
            System.out.println("Comanda #" + numarComanda + " a fost ridicata.");
        }
    }

    public void afiseazaIstoric() {
        if (istoricComenzi.isEmpty()) {
            System.out.println("Nu exista comenzi in istoric.");
        } else {
            System.out.println("Istoric comenzi pentru " + prenume + " " + nume + ":");
            for (Comanda comanda : istoricComenzi) {
                comanda.afisare();
            }
        }
    }

    public void anuleazaRezervare() {
        if (rezervari.isEmpty()) {
            System.out.println("Nu exista rezervari de anulat.");
        } else {
            System.out.println("Rezervarea a fost anulata.");
            rezervari.remove(rezervari.size() - 1); // Anuleaza ultima rezervare
        }
    }
}

