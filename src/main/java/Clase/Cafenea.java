package Clase;

import Enum.Locatie;

public class Cafenea {
    private String nume;
    private Locatie adresa;
    private String program;
    
    public Cafenea() {
        this.nume = null;
        this.adresa = null;
        this.program = null;
    }
    public Cafenea(String nume, Locatie adresa, String program) {
        this.nume = nume;
        this.adresa = adresa;
        this.program = program;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public Locatie getAdresa() {
        return adresa;
    }
    public void setAdresa(Locatie adresa) {
        this.adresa = adresa;
    }
    public String getProgram() {
        return program;
    }
    public void setProgram(String program) {
        this.program = program;
    }
    public void afisare() {
        System.out.println("Nume Cafenea: " + nume);
        System.out.println("Adresa Cafenea: " + adresa);
        System.out.println("Program Cafenea: " + program);
    }
    public void modificareProgram(String program) {
        this.program = program;
    }

    //NEAPARAT TESTAT!
    public boolean esteDeschisaAcum(String ora) { // ors in format 07:00 - 21:00
        if(Integer.parseInt(ora.substring(0, 2)) < Integer.parseInt(program.substring(0, 2))){
            return false;
        } else if(Integer.parseInt(ora.substring(0, 2)) > Integer.parseInt(program.substring(6, 8)) ){
            return false;
        } else if(Integer.parseInt(ora.substring(0, 2)) == Integer.parseInt(program.substring(0, 2)))
            if(Integer.parseInt(ora.substring(3, 5)) < Integer.parseInt(program.substring(3, 5))){
                return false;
            } else if(Integer.parseInt(ora.substring(0, 2)) == Integer.parseInt(program.substring(6, 8)))
                if(Integer.parseInt(ora.substring(3, 5)) > Integer.parseInt(program.substring(9, 11))){
                    return false;
                }
        return true;
    }
}
