package com.example.kolejneformularze;


public abstract class Pytanie {

    protected String treść;
    protected String nazwaPliku;
    protected boolean czyOdpowiedzPoprawna;


    public Pytanie(String treść, String nazwaPliku) {
        this.treść = treść;
        this.nazwaPliku = nazwaPliku;
        this.czyOdpowiedzPoprawna = false;
    }


    public abstract boolean sprawdzOdpowiedź(char odpowiedź);

    public String getTreść() {
        return treść;
    }

    public String getNazwaPliku() {
        return nazwaPliku;
    }

    public boolean isCzyOdpowiedzPoprawna() {
        return czyOdpowiedzPoprawna;
    }

    // Setter
    protected void setCzyOdpowiedzPoprawna(boolean czyOdpowiedzPoprawna) {
        this.czyOdpowiedzPoprawna = czyOdpowiedzPoprawna;
    }

    public abstract boolean sprawdzOdpowiedz(char odpowiedz);
}

