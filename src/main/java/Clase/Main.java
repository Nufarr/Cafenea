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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       // Cafenele
       Cafenea cafenea1 = new Cafenea("Cafenea Pipera", Locatie.Pipera, "08:00-22:00");
       Cafenea cafenea2 = new Cafenea("Cafenea Centru", Locatie.Piata_Victoriei, "10:00-23:00");

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
        ArrayList<Comanda> comenzi = new ArrayList<>();
        cafenele.add(cafenea1);
        cafenele.add(cafenea2);

        meniuprincipal:
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

                    meniuclient:
                    while(true) {
                        System.out.println("\n==============MENIU CLIENT==============");
                        System.out.println("1. Vizualizare Meniu");
                        System.out.println("2. Vizualizare Oferte");
                        System.out.println("3. Comanda");
                        System.out.println("0. Iesire");
                        String optiuneClient = scanner.nextLine();
                        switch (optiuneClient) {
                            case "0":
                                break meniuclient;
                            case "1":
                                client.vizualizareMeniu();
                                break;
                            case "2":
                                client.afiseazaOferte();
                                break;
                            case "3":
                                  comenzi.add(client.plaseazaComanda(scanner));
                                  break;
                            default:
                                break;
                        }
                    }
                case "2":
                    //TODO:
                    break;

                case "3":
                    break;

                case "0":
                    return;
                default:
                    break;
            }
        }

//TODO: anuleaza Rezervari, Gestionare comenzi de angajat, Gestionae Stocuri Manager
    //     Client client = new Client("Ion", "Popescu", "ion@email.com", "123456789");
    //     client.creeazaRezervare("20:00");
    //     client.creeazaRezervare("11:00");

    //     client.afiseazaRezervare();
    //     client.anuleazaRezervare();
    //     client.afiseazaRezervare();

    // }
}

}