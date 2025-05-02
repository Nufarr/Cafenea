package Clase;

import Enum.StatusOferta;

public class Oferte {
    private Integer discount;
    private String dataExpirare;
    private StatusOferta status;

    public Oferte() {
        this.discount = 0;
        this.dataExpirare = null;
        this.status = StatusOferta.Acceptata;
    }

    public Oferte(Integer discount, String dataExpirare, StatusOferta status) {
        this.discount = discount;
        this.dataExpirare = dataExpirare;
        this.status = status;
    }

    public Integer getDiscount() {
        return discount;
    }
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
    public String getDataExpirare() {
        return dataExpirare;
    }
    public void setDataExpirare(String dataExpirare) {
        this.dataExpirare = dataExpirare;
    }
    public StatusOferta getStatus() {
        return status;
    }
    public void setStatus(StatusOferta status) {
        this.status = status;
    }

    public void afisare() {
        System.out.println("Discount: " + discount + "%");
        System.out.println("Data Expirare: " + dataExpirare);
        System.out.println("Status: " + status);
    }

    public void schimbaStatus() {
        if(status == StatusOferta.Acceptata) {
            status = StatusOferta.Respinsa;
        } else 
        status = StatusOferta.Acceptata;
    }

}
