package Clase;
import java.util.ArrayList;
import java.util.Scanner;

import Enum.TipBautura;
import Enum.TipMarime;

public class Client extends Persoana {
    private int numarComanda;
    private ArrayList<Comanda> istoricComenzi;
    private ArrayList<Oferte> oferte;  // Lista de oferte
    private ArrayList<Rezervare> rezervari;  // Lista de rezervări
    private Cafenea cafenea;

    public Client(String nume, String prenume, String email, String telefon, Cafenea cafenea) {
        super(nume, prenume, email, telefon);
        this.numarComanda = 0;
        this.istoricComenzi = new ArrayList<>();
        this.oferte = new ArrayList<>(); 
        this.rezervari= new ArrayList<>(); // Initializare lista de oferte
        this.cafenea = cafenea;
    }

    public Cafenea getCafenea() {
        return cafenea;
    }
    public void setCafenea(Cafenea cafenea) {
        this.cafenea = cafenea;
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

    public ArrayList<Oferte> getOferte() {
        return oferte;
    }
    public void setOferte(ArrayList<Oferte> oferte) {
        this.oferte = oferte;
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
            int i = 0;
            for (Oferte oferta : oferte) {
                i++;
                System.out.print(i + ". ");
                oferta.afisare();
            }
        }
    }






    public void creareCont() {
        System.out.println("Cont creat pentru clientul: " + prenume + " " + nume);
    }

    public Comanda plaseazaComanda(Scanner scanner) {
        Comanda comanda = new Comanda();
        Oferte oferta = new Oferte();
        boolean ofertaAplicata = false;

        System.out.print("Selectare ora pickup (Ex: 10:00): ");
        String ora = scanner.nextLine();
        while (!cafenea.esteDeschisaAcum(ora)) {
            System.out.println("Cafeneaua este inchisa la aceasta ora.");
            System.out.print("Selectare ora pickup in intervalul orar " + cafenea.getProgram() + ": ");
            ora = scanner.nextLine();
        }
        comanda.setOraRidicare(ora);

        while (true) {
            System.out.println("\n=== MENIU COMANDA ===");
            System.out.println("1. Adaug produs in meniu");
            System.out.println("2. Elimin produs din meniu");
            System.out.println("3. Adaug Oferta");
            System.out.println("4. Elimin Oferta");
            System.out.println("5. Vizualizeaza Meniu");
            System.out.println("6. Vizualizeaza Cos Comanda");
            System.out.println("0. Plaseaza Comanda");

            System.out.print("Alege o opțiune: ");
            String opt = scanner.nextLine();

            switch (opt) {
                case "1":
                    Bautura bautura = alegeDinMeniu();
                    System.out.println(bautura.getStoc());
                    if (bautura != null) {
                        if(bautura.getStoc() <= 0){
                            System.out.println("Stoc insuficient pentru " + bautura.getTipBautura());
                            System.out.println("Selectati alt produs");
                            break;
                        }
                        comanda.adaugaProdus(bautura);
                        comanda.afisare();
                    }
                    break;

                case "2":
                    comanda.afisare();
                    if (comanda.getBauturi().isEmpty()) {
                        System.out.println("Nu există băuturi în comandă pentru a fi eliminate.");
                        break;
                    }

                    if (ofertaAplicata) comanda.eliminaOferta(oferta);

                    ArrayList<Bautura> bauturi = comanda.getBauturi();
                    for (int i = 0; i < bauturi.size(); i++) {
                        System.out.println((i + 1) + ". " + bauturi.get(i));
                    }

                    System.out.print("Introdu numărul băuturii: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        if (index >= 0 && index < bauturi.size()) {
                            comanda.eliminaProdus(bauturi.get(index));
                            System.out.println("Băutura a fost eliminată.");
                        } else {
                            System.out.println("Index invalid.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input invalid.");
                    }

                    if (ofertaAplicata) comanda.aplicaOferta(oferta);
                    break;

                case "3":
                    if (ofertaAplicata) {
                        System.out.println("O ofertă este deja aplicată.");
                        break;
                    }

                    afiseazaOferte();
                    if (oferte.isEmpty()) break;

                    System.out.print("Alege indexul ofertei: ");
                    try {
                        int idx = Integer.parseInt(scanner.nextLine()) - 1;
                        if (idx >= 0 && idx < oferte.size()) {
                            oferta = oferte.get(idx);
                            comanda.aplicaOferta(oferta);
                            ofertaAplicata = true;
                            System.out.println("Ofertă aplicată.");
                        } else {
                            System.out.println("Index invalid.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input invalid.");
                    }
                    break;

                case "4":
                    if (!ofertaAplicata) {
                        System.out.println("Nu există ofertă aplicată.");
                        break;
                    }
                    comanda.eliminaOferta(oferta);
                    ofertaAplicata = false;
                    System.out.println("Ofertă eliminată.");
                    break;

                case "5":
                    vizualizareMeniu();
                    break;

                case "6":
                    comanda.afisare();
                    break;

                case "0":
                    istoricComenzi.add(comanda);
                    creeazaRezervare(ora);
                    System.out.println("Comanda a fost plasată!");
                    return comanda;

                default:
                    System.out.println("Opțiune invalidă.");
            }
        }
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

    public void notifcare(String mesaj){
        System.out.println(mesaj);
    }

    public Bautura alegeDinMeniu(){
        Scanner sc = new Scanner(System.in);
        // Alege băutura
        System.out.println("Alege băutura (0 pentru a renunța):");
        TipBautura[] bauturi = TipBautura.values();
        for (int i = 0; i < bauturi.length; i++) {
            System.out.println((i + 1) + ". " + bauturi[i].name().replace("_", " "));
        }

        int optBautura = -1;
        while (true) {
            System.out.print("Alegerea ta: ");
            try {
                optBautura = Integer.parseInt(sc.nextLine());
                if (optBautura == 0) {
                    System.out.println("Anulat.");
                    return null;
                } else if (optBautura >= 1 && optBautura <= bauturi.length) {
                    break;
                } else {
                    System.out.println("Opțiune invalidă. Încearcă din nou.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Introdu un număr valid.");
            }
        }

        TipBautura tipBautura = bauturi[optBautura - 1];

        // Alege mărimea
        System.out.println("Alege mărimea (0 pentru a renunța):");
        TipMarime[] marimi = TipMarime.values();
        for (int i = 0; i < marimi.length; i++) {
            System.out.println((i + 1) + ". " + marimi[i].name().replace("_", " "));
        }
        int optMarime = -1;
        while (true) {
            System.out.print("Alegerea ta: ");
            try {
                optMarime = Integer.parseInt(sc.nextLine());
                if (optMarime == 0) {
                    System.out.println("Anulat.");
                    return null;
                } else if (optMarime >= 1 && optMarime <= marimi.length) {
                    break;
                } else {
                    System.out.println("Opțiune invalidă. Încearcă din nou.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Introdu un număr valid.");
            }
        }

        TipMarime tipMarime = marimi[optMarime - 1];
        return new Bautura(tipBautura, tipMarime);
    }

    public void vizualizareMeniu(){
        System.out.println("=== MENIU CAFENEA ===");
        for (TipBautura tipBautura : TipBautura.values()) {
            System.out.println("\n" + tipBautura.name().replace("_", " ") + ":");

            for (TipMarime marime : TipMarime.values()) {
                int pret = 0;

                if (tipBautura == TipBautura.Cafea) {
                    if (marime == TipMarime.Mica) pret = 10;
                    else if (marime == TipMarime.Medie) pret = 15;
                    else pret = 20;
                } else if (tipBautura == TipBautura.Ceai) {
                    if (marime == TipMarime.Mica) pret = 8;
                    else if (marime == TipMarime.Medie) pret = 12;
                    else pret = 16;
                } else if (tipBautura == TipBautura.Suc) {
                    if (marime == TipMarime.Mica) pret = 5;
                    else if (marime == TipMarime.Medie) pret = 7;
                    else pret = 10;
                } else if (tipBautura == TipBautura.Cicolata_Calda) {
                    if (marime == TipMarime.Mica) pret = 12;
                    else if (marime == TipMarime.Medie) pret = 18;
                    else pret = 25;
                } else if (tipBautura == TipBautura.Apa) {
                    if (marime == TipMarime.Mica) pret = 3;
                    else if (marime == TipMarime.Medie) pret = 5;
                    else pret = 8;
                } else if (tipBautura == TipBautura.Limonada) {
                    if (marime == TipMarime.Mica) pret = 7;
                    else if (marime == TipMarime.Medie) pret = 10;
                    else pret = 15;
                } else if (tipBautura == TipBautura.Smoothie) {
                    if (marime == TipMarime.Mica) pret = 12;
                    else if (marime == TipMarime.Medie) pret = 18;
                    else pret = 25;
                }

                System.out.println("  - " + marime.name() + ": " + pret + " lei");
            }
        }
    }
}

