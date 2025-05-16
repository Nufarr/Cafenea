package Clase;

import Enum.TipBautura;
import Enum.TipMarime;

public class Bautura {
    private TipBautura tipBautura;
    private TipMarime marime;
    private int pret;

    public Bautura() {
        this.tipBautura = null;
        this.marime = null;
        this.pret = 0;
    }

    public Bautura(TipBautura tipBautura, TipMarime marime) {
        this.tipBautura = tipBautura;
        this.marime = marime;
        setPret();
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
    public int getPret() {
        return pret;
    }
    public void setPret() {
        if (tipBautura == TipBautura.Cafea) {
            if (marime == TipMarime.Mica) {
                this.pret = 10;
            } else if (marime == TipMarime.Medie) {
                this.pret = 15;
            } else if (marime == TipMarime.Mare) {
                this.pret = 20;
            }
        } else if (tipBautura == TipBautura.Ceai) {
            if (marime == TipMarime.Mica) {
                this.pret = 8;
            } else if (marime == TipMarime.Medie) {
                this.pret = 12;
            } else if (marime == TipMarime.Mare) {
                this.pret = 16;
            }
        } else if (tipBautura == TipBautura.Suc) {
            if (marime == TipMarime.Mica) {
                this.pret = 5;
            } else if (marime == TipMarime.Medie) {
                this.pret = 7;
            } else if (marime == TipMarime.Mare) {
                this.pret = 10;
            }
        } else if (tipBautura == TipBautura.Cicolata_Calda) {
            if (marime == TipMarime.Mica) {
                this.pret = 12;
            } else if (marime == TipMarime.Medie) {
                this.pret = 18;
            } else if (marime == TipMarime.Mare) {
                this.pret = 25;
            }
        }
        else if (tipBautura == TipBautura.Apa) {
            if (marime == TipMarime.Mica) {
                this.pret = 3;
            } else if (marime == TipMarime.Medie) {
                this.pret = 5;
            } else if (marime == TipMarime.Mare) {
                this.pret = 8;
            }
        }
        else if (tipBautura == TipBautura.Limonada) {
            if (marime == TipMarime.Mica) {
                this.pret = 7;
            } else if (marime == TipMarime.Medie) {
                this.pret = 10;
            } else if (marime == TipMarime.Mare) {
                this.pret = 15;
            }
        }
        else if (tipBautura == TipBautura.Smoothie) {
            if (marime == TipMarime.Mica) {
                this.pret = 12;
            } else if (marime == TipMarime.Medie) {
                this.pret = 18;
            } else if (marime == TipMarime.Mare) {
                this.pret = 25;
            }
        }
        else {
            this.pret = 0; // Pretul default
        }
    }
    

    public void afisare() {
        System.out.println("Tip Bautura: " + tipBautura);
        System.out.println("Marime: " + marime);
        System.out.println("Pret Bautura: " + pret);
    }

    public TipBautura adaugaBautura() {return tipBautura;}
    public TipBautura stergeBautura() {return tipBautura;}
}
