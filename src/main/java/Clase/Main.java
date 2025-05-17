package Clase;

import Enum.Locatie;
import Enum.StatusComanda;
import Enum.StatusOferta;
import Enum.TipBautura;
import Enum.TipFunctie;
import Enum.TipMarime;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static boolean validareOra(String ora) {
        if (ora.matches("^\\d{2}:\\d{2}$")) {
            String[] parti = ora.split(":");

            int ore = Integer.parseInt(parti[0]);
            int minute = Integer.parseInt(parti[1]);

            if (ore >= 0 && ore <= 23 && minute >= 0 && minute <= 59) {
                return true; // Ora este validă
            } else {
                System.out.println("Ora sau minutul este în afara intervalului valid (00:00 - 23:59).");
                return false;
            }
        } else {
            System.out.println("Format invalid. Te rog să introduci ora în formatul HH:mm (ex: 08:30).");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       // Cafenele
       Cafenea cafenea1 = new Cafenea("Cafenea Pipera", Locatie.Pipera, "08:00 - 22:00");
       Cafenea cafenea2 = new Cafenea("Cafenea Centru", Locatie.Piata_Victoriei, "10:00 - 23:00");

       // Angajati
       Angajat angajat1 = new Angajat("Ion", "Popescu", "ion@email.com", "123456789", 3000, 40, TipFunctie.Barista, cafenea1);
       cafenea1.adaugaAngajat(angajat1);
       Angajat angajat2 = new Angajat("Maria", "Ionescu", "maria@email.com", "987654321", 3500, 40, TipFunctie.Om_de_Serviciu, cafenea1);
       cafenea1.adaugaAngajat(angajat2);
       Angajat angajat3 = new Angajat("Serban", "Marius", "serbanmarius@email.com", "0734563243", 1900, 30, TipFunctie.Barista, cafenea2);
       cafenea2.adaugaAngajat(angajat3);

       //Oferte
        Oferte oferta1 = new Oferte(10, "2023-12-31", StatusOferta.Acceptata);
        Oferte oferta2 = new Oferte(15, "2023-12-31", StatusOferta.Acceptata);

        ArrayList<Cafenea> cafenele = new ArrayList<>();
        ArrayList<Client> clienti = new ArrayList<>();
        cafenele.add(cafenea1);
        cafenele.add(cafenea2);

        while(true)
        {
            System.out.println("\n==============MENIU PRINCIPAL==============");
            System.out.println("1. Client");
            System.out.println("2. Angajat");
            System.out.println("0. Iesire");
            System.out.println("Alege o optiune:");

            String optiune = scanner.nextLine();
            switch (optiune)
            {
                case "1":
                    System.out.println("Creeza cont: \n");

                    System.out.print("Nume: ");
                    String nume = scanner.nextLine();

                    System.out.print("Prenume: ");
                    String prenume = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Telefon: ");
                    String telefon = scanner.nextLine();

                    System.out.print("Alege cafeneaua la care vrei sa mergi: ");
                    for(int i = 0; i < cafenele.size(); i++)
                        System.out.print("\n" + (1+i) + ". " + cafenele.get(i).getNume() + " - " + cafenele.get(i).getAdresa() +" " + cafenele.get(i).getProgram());

                    int indexCafenea = -1;
                    while(true){
                        System.out.print("\nIntrodu numărul cafenelei (1-" + cafenele.size() + "): ");
                        try {
                            indexCafenea = Integer.parseInt(scanner.nextLine()) - 1;
                            if (indexCafenea >= 0 && indexCafenea < cafenele.size()) {
                                break;
                            } else {
                                System.out.println("Număr invalid. Încearcă din nou.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Introdu un număr valid!");
                        }
                    }

                    Client client = new Client(nume,prenume,email,telefon,cafenele.get(indexCafenea));
                    client.creareCont();
                    System.out.println("Datele contului: ");
                    client.afisare();
                    clienti.add(client);
                    client.adaugaOferta(oferta1);
                    client.adaugaOferta(oferta2);

                    while(true) {
                        System.out.println("\n==============MENIU CLIENT==============");
                        System.out.println("1. Vizualizare Meniu");
                        System.out.println("2. Vizualizare Oferte");
                        System.out.println("3. Comanda");
                        System.out.println("0. Iesire");
                        String optiuneClient = scanner.nextLine();
                        switch (optiuneClient) {
                            case "0":
                                break;
                            case "1":
                                client.vizualizareMeniu();
                            case "2":
                                client.afiseazaOferte();
                            case "3":
                                Comanda comanda = new Comanda();
                                System.out.print("Selectare ora pickup (Ex: 10:00): ");
                                String ora = scanner.nextLine();
                                System.out.println(validareOra(ora) + " " + client.getCafenea().esteDeschisaAcum(ora));
                                while (!validareOra(ora) || !client.getCafenea().esteDeschisaAcum(ora)) {
                                    if(!client.getCafenea().esteDeschisaAcum(ora)) {
                                        System.out.println("Cafeneaua este inchisa la aceasta ora");
                                    }
                                    System.out.print("Selectare ora pickup in intervalul orar " + client.getCafenea().getProgram() + ": ");
                                    ora = scanner.nextLine();
                                }
                                comanda.setOraRidicare(ora);

                                System.out.println("\n1. Adaug produs in meniu");
                                System.out.println("2. Elimin produs in meniu");
                                System.out.println("3. Adaug Oferta");
                                System.out.println("4. Elimin Oferta");
                                System.out.println("5. Vizualizeaza Meniu");
                                System.out.println("0. Plaseaza Comanda");
                                String optiuneComanda = scanner.nextLine();
                                while(true){
                                    switch (optiuneComanda) {
                                        case "1":
                                            comanda.adaugaProdus(client.alegeDinMeniu());
                                            comanda.afisare();
                                        case "3":
                                            client.afiseazaOferte();
                                            comanda.aplicaOferta(oferta1);
                                        case "5":
                                            client.vizualizareMeniu();
                                        case "0":
                                            client.plaseazaComanda(comanda);
                                            client.creeazaRezervare(ora);
                                            break;
                                    }
                                }
                        }
                    }
            }
        }
//       // Creăm clienți
//       Client client1 = new Client("George", "Vasile", "george@email.com", "345678912");
//       Client client2 = new Client("Elena", "Dumitrescu", "elena@email.com", "876543210");
//       Client client3 = new Client("Codrin", "Ursula", "ursula.codrin@email.com", "123456779");
//
//
//       // Adăugăm angajați și clienți la cafenea
//       cafenea.adaugaClient(client1);
//       cafenea.adaugaClient(client2);
//       cafenea.adaugaClient(client3);
//
//
//       // Afișăm angajați și clienți
//       cafenea.afisareAngajati();
//       cafenea.afisareClienti();
//
//   // Creăm o ofertă de 10%, resp. 15%
//         Oferte oferta1 = new Oferte(10, "2023-12-31", StatusOferta.Acceptata);
//         Oferte oferta2 = new Oferte(15, "2023-12-31", StatusOferta.Acceptata);
//
//         // Adăugăm oferte la clienți
//        client1.adaugaOferta(oferta1);
//        client2.adaugaOferta(oferta2);
//
//// Creăm comenzi pentru clienți
//        Comanda comanda1 = new Comanda("12:00", StatusComanda.In_Asteptare);
//        Comanda comanda2 = new Comanda("13:00", StatusComanda.In_Asteptare);
//        Comanda comanda3 = new Comanda("14:00", StatusComanda.In_Asteptare);
//
//// Creăm băuturi
//        Bautura bautura1 = new Bautura(TipBautura.Cafea, TipMarime.Mica);  // Pretul va fi setat prin `setPret`
//        Bautura bautura2 = new Bautura(TipBautura.Ceai, TipMarime.Mare);   // Pretul va fi setat prin `setPret`
//        Bautura bautura3 = new Bautura(TipBautura.Limonada, TipMarime.Medie);   // Pretul va fi setat prin `setPret`
//
// // Clientul 1 plasează o comandă
//        client1.plaseazaComanda(comanda1);
//        comanda1.adaugaProdus(bautura1);
//        comanda1.adaugaProdus(bautura2);
//        client1.afiseazaIstoric();
//
//        // Aplicăm o ofertă la comanda clientului 1
//        comanda1.aplicaOferta(oferta1);
//        comanda1.afisare();
//        System.out.println("\nDupa eliminarea unei bauturi:");
//        comanda1.eliminaOferta(oferta1);
//        comanda1.eliminaProdus(bautura1);
//        comanda1.aplicaOferta(oferta1);
//        comanda1.afisare();
//
//        // Clientul 2 plasează două comenzi
//        client2.plaseazaComanda(comanda2);
//        comanda2.adaugaProdus(bautura1);
//        comanda2.adaugaProdus(bautura2);
//        client2.afiseazaIstoric();
//
//        client2.plaseazaComanda(comanda3);
//        comanda3.adaugaProdus(bautura3);
//        comanda3.adaugaProdus(bautura3);
//        client2.afiseazaIstoric();
//
//       // Angajatul preia și pregătește comenzile
//        angajat1.preluareComanda(comanda1);
//        angajat1.pregatireComanda(comanda1);
//        System.out.println("\nComanda clientului 1 a fost finalizată:");
//        comanda1.afisare();
//
////Comenzile pentru clientul 2
//        angajat1.preluareComanda(comanda2);
//        angajat1.pregatireComanda(comanda2);
//        System.out.println("\nComanda clientului 2 a fost finalizată:");
//        comanda2.afisare();
//
//        angajat1.preluareComanda(comanda3);
//        angajat1.pregatireComanda(comanda3);
//        System.out.println("\nComanda clientului 2 (a doua comanda) a fost finalizată:");
//        comanda3.afisare();
//
//









    //     Client client = new Client("Ion", "Popescu", "ion@email.com", "123456789");
    //     client.creeazaRezervare("20:00");
    //     client.creeazaRezervare("11:00");

    //     client.afiseazaRezervare();
    //     client.anuleazaRezervare();
    //     client.afiseazaRezervare();

    // }
}

}