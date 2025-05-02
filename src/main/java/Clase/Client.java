package Clase;

import java.util.ArrayList;
import java.util.List;

public class Client extends Persoana {
    private int numarComanda;
    private List<String> istoricComenzi;

    public Client(String nume, String prenume, String email, String telefon) {
        super(nume, prenume, email, telefon);
        this.numarComanda = 0;
        this.istoricComenzi = new ArrayList<>();
    }
    public int getNumarComanda() {
        return numarComanda;
    }

    public void setNumarComanda(int numarComanda) {
        this.numarComanda = numarComanda;
    }

    public List<String> getIstoricComenzi() {
        return istoricComenzi;
    }

    public void setIstoricComenzi(List<String> istoricComenzi) {
        this.istoricComenzi = istoricComenzi;
    }
    public void creareCont() {
        System.out.println("Cont creat pentru clientul: " + prenume + " " + nume);
    }

    public void plaseazaComanda(String descriereComanda) {
        numarComanda++;
        istoricComenzi.add("Comanda #" + numarComanda + ": " + descriereComanda);
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
            for (String comanda : istoricComenzi) {
                System.out.println(comanda);
            }
        }
    }
}

