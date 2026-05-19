package com.example.kolejneformularze;


public abstract class Pytanie {
    protected String trescPytania;
    protected String nazwaPliku;
    protected boolean czyOdpowiedzPoprawna;

    public Pytanie(String trescPytania, String nazwaPliku) {
        this.trescPytania = trescPytania;
        this.nazwaPliku = nazwaPliku;
        this.czyOdpowiedzPoprawna = false;
    }

    public abstract boolean sprawdzOdpowiedz(char odpowiedz);

    public String getTrescPytania() {
        return trescPytania;
    }

    public String getNazwaPliku() {
        return nazwaPliku;
    }

    public boolean isCzyOdpowiedzPoprawna() {
        return czyOdpowiedzPoprawna;
    }

    public void setCzyOdpowiedzPoprawna(boolean czyOdpowiedzPoprawna) {
        this.czyOdpowiedzPoprawna = czyOdpowiedzPoprawna;
    }
}