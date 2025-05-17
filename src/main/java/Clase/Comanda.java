package Clase;

import java.util.ArrayList;
import java.util.List;

import Enum.StatusComanda;
import Enum.StatusOferta;

public class Comanda {
    private static int contorIdComanda = 0;
    private int idComanda; // ID-ul comenzii
    private String oraRidicare;
    private StatusComanda status;
    private int pretTotal;
    private ArrayList<Bautura> bauturi;  // Lista de băuturi
    private Client client;
    private Angajat angajat;
    private Oferte oferta;

    public Comanda() {
        contorIdComanda++;
        this.idComanda = contorIdComanda;
        this.oraRidicare = "12:00";
        this.status = StatusComanda.In_Asteptare;
        this.pretTotal = 0;
        this.bauturi = new ArrayList<>();
    }

    public Comanda(String oraRidicare, StatusComanda status) {
        contorIdComanda++;  // Incrementăm contorul de fiecare dată când creăm o comandă
        this.idComanda = contorIdComanda;  // Atribuim un ID unic comenzii
        this.oraRidicare = oraRidicare;
        this.status = status;
        this.pretTotal = 0;
        this.bauturi = new ArrayList<>();
    }

    public int getIdComanda() {
        return idComanda;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Angajat getAngajat() {
        return angajat;
    }
    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }
    public ArrayList<Bautura> getBauturi() {
        return bauturi;
    }

    public String getOraRidicare() {
        return oraRidicare;
    }
    public void setOraRidicare(String oraRidicare) {
        this.oraRidicare = oraRidicare;
    }
    public StatusComanda getStatus() {
        return status;
    }
    public void setStatus(StatusComanda status) {
        this.status = status;
    }

    // Metoda pentru adăugarea unei băuturi
    public void adaugaProdus(Bautura bautura) {
        pretTotal = pretTotal + bautura.getPret();
        this.bauturi.add(bautura);
    }

    // Metoda pentru eliminarea unei băuturi
    public void eliminaProdus(Bautura bautura) {
        pretTotal = pretTotal - bautura.getPret();
        this.bauturi.remove(bautura);
    }

    public void afisareBauturi() {
        System.out.println("Băuturi în comandă:");
        for (Bautura b : bauturi) {
            b.afisare();
        }
    }
    // Metoda de afișare a detaliilor comenzii
    public void afisare() {
        System.out.println("Ora ridicării comenzii: " + oraRidicare);
        System.out.println("Statusul comenzii: " + status);
        afisareBauturi();  // Afișează băuturile comenzii
        if(oferta != null)
            System.out.println("Discount: " + oferta.getDiscount());
        System.out.println("Total plata: " + pretTotal);
        System.out.println();
    }

    public void anuleazaComanda() {
        // Logica pentru anularea comenzii
        this.status = StatusComanda.Anulata;
        System.out.println("Comanda a fost anulată.");
    }

    public void finalizeazaComanda() {
        // Logica pentru finalizarea comenzii
        this.status = StatusComanda.Finalizata;
        System.out.println("Comanda a fost finalizată.");
    }

    // Metoda pentru a aplica oferta
    public void aplicaOferta(Oferte oferta) {
        this.oferta = oferta;
        if (oferta != null && oferta.getStatus() == StatusOferta.Acceptata) {  // Verificăm dacă oferta este acceptată
            int discount = oferta.getDiscount(); // Discountul oferit
            int valoareDiscount = (pretTotal * discount) / 100;  // Calculăm reducerea
            pretTotal -= valoareDiscount;  // Aplicăm discountul la prețul total
            System.out.println("Oferta de " + discount + "% a fost aplicată.");
        } else {
            System.out.println("Oferta nu este acceptată sau nu există oferte disponibile.");
        }
    }
    public void eliminaOferta(Oferte oferta) {
        this.oferta = null;
        int pretInitial = 0;
        for (Bautura b : bauturi) {
            pretInitial += b.getPret();  // Calculăm prețul inițial al băuturilor
        }  // Restaurăm prețul la valoarea inițială
        pretTotal = pretInitial;
        System.out.println("Oferta a fost eliminată și prețul a fost restaurat la " + pretTotal);
    }
}