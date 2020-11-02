package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetnaTacka;
    double krajnjaTacka;
    boolean pocetnaTackaPripada;
    boolean krajnjaTackaPripada;

    Interval (double pocetnaTacka, double krajnjaTacka,
              boolean pocetnaTackaPripada, boolean krajnjaTackaPripada ) {
        if (pocetnaTacka > krajnjaTacka) throw new IllegalArgumentException("Početna tačka je veća od kranje!");
        this.pocetnaTacka = pocetnaTacka; this.krajnjaTacka = krajnjaTacka;
        this.pocetnaTackaPripada = pocetnaTackaPripada; this.krajnjaTackaPripada = krajnjaTackaPripada;
    }

    Interval () {
        pocetnaTacka = 0; krajnjaTacka = 0;
        pocetnaTackaPripada = false; krajnjaTackaPripada = false;
    }

    boolean isNull () {
        return !pocetnaTackaPripada && !krajnjaTackaPripada && pocetnaTacka == 0 && krajnjaTacka == 0;
    }

}
