package Clase;

public class Manager extends Persoana{
    private Integer nivelAcces;
    private Integer Salariu;

    public Manager() {
        super(null, null, null, null);
        nivelAcces = 0;
        Salariu = 0;
    }

    public Manager(String nume, String prenume, String email, String telefon, Integer nivelAcces, Integer Salariu) {
        super(nume, prenume, email, telefon);
        this.nivelAcces = nivelAcces;
        this.Salariu = Salariu;
    }

    public Integer getNivelAcces() {
        return nivelAcces;
    }
    public void setNivelAcces(Integer nivelAcces) {
        this.nivelAcces = nivelAcces;
    }
    public Integer getSalariu() {
        return Salariu;
    }
    public void setSalariu(Integer Salariu) {
        this.Salariu = Salariu;
    }

    @Override
    public void afisare() {
        super.afisare();
        System.out.println("Nivel Acces: " + nivelAcces);
        System.out.println("Salariu: " + Salariu);
    }

    public void gestioneazaStocuri(){}
    public void adaugaProdusInMeniu(){}
    public void modificaProdusDinMeniu(){}
    public void stergeProdusDinMeniu(){}
    public void vizualizeazaRaportVanzari(){}
    public void distribuireSalariuClienti(){}
}
