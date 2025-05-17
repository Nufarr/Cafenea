package Clase;

import Enum.TipBautura;
import Enum.TipMarime;

public class Bautura {
    private TipBautura tipBautura;
    private TipMarime marime;
    private static int stocCafea = 30;
    private static int stocCeai = 40;
    private static int stocSuc = 50;
    private static int stocCC = 10;
    private static int stocApa = 60;
    private static int stocLimo = 25;
    private static int stocSmoothie = 1;
    private static int pret;

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

    public int getStoc(){
        if (tipBautura == TipBautura.Cafea) {
            return stocCafea;
        } else if (tipBautura == TipBautura.Ceai) {
            return stocCeai;
        } else if (tipBautura == TipBautura.Suc) {
            return stocSuc;
        } else if (tipBautura == TipBautura.Cicolata_Calda) {
            return stocCC;
        }
        else if (tipBautura == TipBautura.Apa) {
            return stocApa;
        }
        else if (tipBautura == TipBautura.Limonada) {
            return this.stocLimo;
        }
        else if (tipBautura == TipBautura.Smoothie) {
            return stocSmoothie;
        }
        else {
            return 0; // Pretul default
        }
    }

    public void setStoc(int stoc){
        if (tipBautura == TipBautura.Cafea) {
            this.stocCafea = stoc;
        } else if (tipBautura == TipBautura.Ceai) {
            this.stocCeai = stoc;
        } else if (tipBautura == TipBautura.Suc) {
            this.stocSuc = stoc;
        } else if (tipBautura == TipBautura.Cicolata_Calda) {
            this.stocCC = stoc;
        }
        else if (tipBautura == TipBautura.Apa) {
            this.stocApa = stoc;
        }
        else if (tipBautura == TipBautura.Limonada) {
            this.stocLimo = stoc;
        }
        else if (tipBautura == TipBautura.Smoothie) {
            this.stocSmoothie = stoc;
        }
        else {
            this.pret = 0; // Pretul default
        }
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
        System.out.println(tipBautura + " - " + marime + " - " + pret + "lei");
    }

    public void afisareStoc() {
        System.out.println("Tip Bautura: " + tipBautura);
        System.out.println("Marime: " + marime);
        System.out.println("Pret Bautura: " + pret);
        System.out.println("Stoc Bautura: " + getStoc());
    }


    public void scadeStoc(int cantitate) {
        if (getStoc() >= cantitate) {
            setStoc(getStoc() - cantitate);
            System.out.println("Stoc actualizat. Cantitate rămasă: " + getStoc());
        } else {
            System.out.println("Stoc insuficient! Nu se poate procesa comanda.");
        }
    }

//    public TipBautura adaugaBautura() {return tipBautura;}
//    public TipBautura stergeBautura() {return tipBautura;}
}
