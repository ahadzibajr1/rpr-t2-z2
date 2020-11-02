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
    public Interval Intersect (Interval drugiInterval) {
        Interval presjek = new Interval (0,0,false,false);
        if (drugiInterval.isIn(this.krajnjaTacka) && !drugiInterval.isIn(this.pocetnaTacka)) {
            presjek.krajnjaTacka = this.krajnjaTacka;
            presjek.pocetnaTacka = drugiInterval.pocetnaTacka;
            if (drugiInterval.pocetnaTackaPripada) presjek.pocetnaTackaPripada = true;
            else presjek.pocetnaTackaPripada = false;
            if (this.krajnjaTackaPripada) presjek.krajnjaTackaPripada = true;
            else presjek.krajnjaTackaPripada = false;
        }
        else if (this.isIn(drugiInterval.krajnjaTacka) && !this.isIn(drugiInterval.pocetnaTacka)) {
            presjek.krajnjaTacka = drugiInterval.krajnjaTacka;
            presjek.pocetnaTacka = this.pocetnaTacka;
            if (this.pocetnaTackaPripada) presjek.pocetnaTackaPripada = true;
            else presjek.pocetnaTackaPripada = false;
            if (drugiInterval.krajnjaTackaPripada) presjek.krajnjaTackaPripada = true;
            else presjek.krajnjaTackaPripada = false;
        }
        else if (drugiInterval.isIn(this.krajnjaTacka) && drugiInterval.isIn(this.pocetnaTacka)) {
            presjek = this;
        }
        else if (this.isIn(drugiInterval.krajnjaTacka) && this.isIn(drugiInterval.pocetnaTacka)) {
            presjek = drugiInterval;
        }
        return presjek;
    }

}
