package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetnaTackaPripada;
    private boolean krajnjaTackaPripada;

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

    boolean isIn (double tacka) {
        Double t1 = pocetnaTacka; Double t2 = krajnjaTacka;

        if (tacka > pocetnaTacka && tacka < krajnjaTacka) return true;
        if (pocetnaTackaPripada && t1.equals(tacka)) return true;
        return krajnjaTackaPripada && t2.equals(tacka);
    }


}
