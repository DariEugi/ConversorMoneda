package model;

import principal.BusquedaDivisas;

public class Moneda extends BusquedaDivisas {
    double tasaMXN;
    double tasaARS;
    double tasaBLR;
    double tasaUSD;

    public Moneda(double tasaMXN, double tasaARS, double tasaBLR, double tasaUSD) {
        super();
    }


    public double getTasaMXN() {
        return tasaMXN;
    }

    public double getTasaARS() {
        return tasaARS;
    }

    public double getTasaBLR() {
        return tasaBLR;
    }

    public double getTasaUSD() {
        return tasaUSD;
    }
}
