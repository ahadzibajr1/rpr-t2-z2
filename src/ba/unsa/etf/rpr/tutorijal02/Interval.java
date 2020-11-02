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

    public static Interval Intersect (Interval interval1, Interval interval2) {
        Interval presjek = new Interval (0,0,false,false);
        if (interval2.isIn(interval1.krajnjaTacka) && !interval2.isIn(interval1.pocetnaTacka)) {
            presjek.krajnjaTacka = interval1.krajnjaTacka;
            presjek.pocetnaTacka = interval2.pocetnaTacka;
            if (interval2.pocetnaTackaPripada) presjek.pocetnaTackaPripada = true;
            else presjek.pocetnaTackaPripada = false;
            if (interval1.krajnjaTackaPripada) presjek.krajnjaTackaPripada = true;
            else presjek.krajnjaTackaPripada = false;
        }
        else if (interval1.isIn(interval2.krajnjaTacka) && !interval1.isIn(interval2.pocetnaTacka)) {
            presjek.krajnjaTacka = interval2.krajnjaTacka;
            presjek.pocetnaTacka = interval1.pocetnaTacka;
            if (interval1.pocetnaTackaPripada) presjek.pocetnaTackaPripada = true;
            else presjek.pocetnaTackaPripada = false;
            if (interval2.krajnjaTackaPripada) presjek.krajnjaTackaPripada = true;
            else presjek.krajnjaTackaPripada = false;
        }
        else if (interval2.isIn(interval1.krajnjaTacka) && interval2.isIn(interval1.pocetnaTacka)) {
            presjek = interval1;
        }
        else if (interval1.isIn(interval2.krajnjaTacka) && interval1.isIn(interval2.pocetnaTacka)) {
            presjek = interval2;
        }
        return presjek;
    }

}
