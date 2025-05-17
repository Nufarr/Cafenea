package Clase;

import Enum.Locatie;
import Enum.StatusComanda;
import Enum.StatusOferta;
import Enum.TipBautura;
import Enum.TipFunctie;
import Enum.TipMarime;


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
       Locatie locatie = Locatie.Pipera;

       // Creăm cafenea
       Cafenea cafenea = new Cafenea("Cafenea La Noi", locatie, "08:00 - 22:00");

       // Creăm angajați
       Angajat angajat1 = new Angajat("Ion", "Popescu", "ion@email.com", "123456789", 3000.0f, 40, TipFunctie.Barista);
       Angajat angajat2 = new Angajat("Maria", "Ionescu", "maria@email.com", "987654321", 3500.0f, 40, TipFunctie.Om_de_Serviciu);

       // Creăm clienți
       Client client1 = new Client("George", "Vasile", "george@email.com", "345678912");
       Client client2 = new Client("Elena", "Dumitrescu", "elena@email.com", "876543210");
       Client client3 = new Client("Codrin", "Ursula", "u._codrin@email.com", "123456779");


       // Adăugăm angajați și clienți la cafenea
       cafenea.adaugaAngajat(angajat1);
       cafenea.adaugaAngajat(angajat2);
       cafenea.adaugaClient(client1);
       cafenea.adaugaClient(client2);
       cafenea.adaugaClient(client3);


       // Afișăm angajați și clienți
       cafenea.afisareAngajati();
       cafenea.afisareClienti();

   // Creăm o ofertă de 10%, resp. 15%
         Oferte oferta1 = new Oferte(10, "2023-12-31", StatusOferta.Acceptata);
         Oferte oferta2 = new Oferte(15, "2023-12-31", StatusOferta.Acceptata);

         // Adăugăm oferte la clienți
        client1.adaugaOferta(oferta1);
        client2.adaugaOferta(oferta2);

// Creăm comenzi pentru clienți
        Comanda comanda1 = new Comanda("12:00", StatusComanda.In_Asteptare);
        Comanda comanda2 = new Comanda("13:00", StatusComanda.In_Asteptare);
        Comanda comanda3 = new Comanda("14:00", StatusComanda.In_Asteptare);
        
// Creăm băuturi
        Bautura bautura1 = new Bautura(TipBautura.Cafea, TipMarime.Mica);  // Pretul va fi setat prin `setPret`
        Bautura bautura2 = new Bautura(TipBautura.Ceai, TipMarime.Mare);   // Pretul va fi setat prin `setPret`
        Bautura bautura3 = new Bautura(TipBautura.Limonada, TipMarime.Medie);   // Pretul va fi setat prin `setPret`

 // Clientul 1 plasează o comandă
        client1.plaseazaComanda(comanda1);
        comanda1.adaugaProdus(bautura1);
        comanda1.adaugaProdus(bautura2);
        client1.afiseazaIstoric();

        // Aplicăm o ofertă la comanda clientului 1
        comanda1.aplicaOferta(oferta1);
        comanda1.afisare();
        System.out.println("\nDupa eliminarea unei bauturi:");
        comanda1.eliminaOferta(oferta1);
        comanda1.eliminaProdus(bautura1);
        comanda1.aplicaOferta(oferta1);
        comanda1.afisare();

        // Clientul 2 plasează două comenzi
        client2.plaseazaComanda(comanda2);
        comanda2.adaugaProdus(bautura1);
        comanda2.adaugaProdus(bautura2);
        client2.afiseazaIstoric();

        client2.plaseazaComanda(comanda3);
        comanda3.adaugaProdus(bautura3);
        comanda3.adaugaProdus(bautura3);
        client2.afiseazaIstoric();

       // Angajatul preia și pregătește comenzile
        angajat1.preluareComanda(comanda1);
        angajat1.pregatireComanda(comanda1);
        System.out.println("\nComanda clientului 1 a fost finalizată:");
        comanda1.afisare();

//Comenzile pentru clientul 2
        angajat1.preluareComanda(comanda2);
        angajat1.pregatireComanda(comanda2);
        System.out.println("\nComanda clientului 2 a fost finalizată:");
        comanda2.afisare();

        angajat1.preluareComanda(comanda3);
        angajat1.pregatireComanda(comanda3);
        System.out.println("\nComanda clientului 2 (a doua comanda) a fost finalizată:");
        comanda3.afisare();











    //     Client client = new Client("Ion", "Popescu", "ion@email.com", "123456789");
    //     client.creeazaRezervare("20:00");
    //     client.creeazaRezervare("11:00");

    //     client.afiseazaRezervare();
    //     client.anuleazaRezervare();
    //     client.afiseazaRezervare();

    // }
}

}