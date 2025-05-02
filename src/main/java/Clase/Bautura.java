package Clase;

import Enum.TipBautura;
import Enum.TipMarime;

public class Bautura {
    private TipBautura tipBautura;
    private TipMarime marime;

    public Bautura() {
        this.tipBautura = null;
        this.marime = null;
    }

    public Bautura(TipBautura tipBautura, TipMarime marime) {
        this.tipBautura = tipBautura;
        this.marime = marime;
    }

    public TipBautura getTipBautura() {
        return tipBautura;
    }

    public void setTipBautura(TipBautura tipBautura) {
        this.tipBautura = tipBautura;
    }

    public TipMarime getMarime() {
        return marime;
    }

    public void setMarime(TipMarime marime) {
        this.marime = marime;
    }

    public void afisare() {
        System.out.println("Tip Bautura: " + tipBautura);
        System.out.println("Marime: " + marime);
    }

    public TipBautura adaugaBautura() {return tipBautura;}
    public TipBautura stergeBautura() {return tipBautura;}
}
