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
    private List<Bautura> bauturi;  // Lista de băuturi


    public Comanda() {
        contorIdComanda++;
        this.idComanda=contorIdComanda;
        this.oraRidicare = "";
        this.status = StatusComanda.In_Asteptare;
        this.pretTotal = 0;
        this.bauturi=new ArrayList<>();
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
            System.out.println(b.adaugaBautura());
        }
    }
    // Metoda de afișare a detaliilor comenzii
    public void afisare() {
        System.out.println("Ora ridicării comenzii: " + oraRidicare);
        System.out.println("Statusul comenzii: " + status);
        afisareBauturi();  // Afișează băuturile comenzii
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
        int pretInitial = 0;
        for (Bautura b : bauturi) {
            pretInitial += b.getPret();  // Calculăm prețul inițial al băuturilor
        }  // Restaurăm prețul la valoarea inițială
        pretTotal = pretInitial;
        System.out.println("Oferta a fost eliminată și prețul a fost restaurat la " + pretTotal);
    }
}