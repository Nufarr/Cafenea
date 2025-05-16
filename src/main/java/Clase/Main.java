package Clase;

public class Main {
    public static void main(String[] args) {
        //  // Creăm clientul
        // Client client = new Client("Ion", "Popescu", "ion@email.com", "123456789");

        // // Creăm o ofertă de 10%
        // Oferte oferta1 = new Oferte(10, "2023-12-31", StatusOferta.Acceptata);
        // Oferte oferta2 = new Oferte(15, "2023-12-31", StatusOferta.Acceptata);

        // // Adăugăm oferta la client
        // client.adaugaOferta(oferta1);
        // client.adaugaOferta(oferta2);

        // // Creăm o comandă
        // Comanda comanda = new Comanda("14:00", StatusComanda.In_Asteptare);

        // // Creăm băuturi și le adăugăm în comandă
        // Bautura bautura1 = new Bautura(TipBautura.Cafea, TipMarime.Mica); // Pretul va fi setat prin `setPret`
        // Bautura bautura2 = new Bautura(TipBautura.Ceai, TipMarime.Mare);   // Pretul va fi setat prin `setPret`

        // // Adăugăm băuturi la comandă
        // comanda.adaugaProdus(bautura1);
        // comanda.adaugaProdus(bautura2);
        // // Afișăm detaliile comenzii
        // comanda.afisare();

        // System.out.println();
        // comanda.aplicaOferta(oferta2);
        // // Afișăm detaliile comenzii după eliminare
        // comanda.afisare();
        // System.out.println("\nDupă eliminarea unei băuturi:");
        // comanda.eliminaProdus(bautura2);
        // comanda.afisare();

        // comanda.eliminaOferta(oferta2);
        // comanda.afisare();
         // Creăm locația cafenelei
//        Locatie locatie = Locatie.Pipera;
//
//        // Creăm cafenea
//        Cafenea cafenea = new Cafenea("Cafenea La Noi", locatie, "08:00 - 22:00");
//
//        // Creăm angajați
//        Angajat angajat1 = new Angajat("Ion", "Popescu", "ion@email.com", "123456789", 3000.0f, 40, TipFunctie.Barista);
//        Angajat angajat2 = new Angajat("Maria", "Ionescu", "maria@email.com", "987654321", 3500.0f, 40, TipFunctie.Om_de_Serviciu);
//
//        // Creăm clienți
//        Client client1 = new Client("George", "Vasile", "george@email.com", "345678912");
//        Client client2 = new Client("Elena", "Dumitrescu", "elena@email.com", "876543210");
//
//        // Adăugăm angajați și clienți la cafenea
//        cafenea.adaugaAngajat(angajat1);
//        cafenea.adaugaAngajat(angajat2);
//        cafenea.adaugaClient(client1);
//        cafenea.adaugaClient(client2);
//
//        // Afișăm angajați și clienți
//        cafenea.afisareAngajati();
//        cafenea.afisareClienti();

        Client client = new Client("Ion", "Popescu", "ion@email.com", "123456789");
        client.creeazaRezervare("20:00");
        client.creeazaRezervare("11:00");

        client.afiseazaRezervare();
        client.anuleazaRezervare();
        client.afiseazaRezervare();

    }
}
