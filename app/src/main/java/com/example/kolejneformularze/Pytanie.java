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


    public abstract boolean sprawdzOdpowiedź(char odpowiedz);

    public String getTreść() {
        return treść;
    }

    public String getNazwaPliku() {
        return nazwaPliku;
    }

    public boolean isCzyOdpowiedzPoprawna() {
        return czyOdpowiedzPoprawna;
    }

    protected void setCzyOdpowiedzPoprawna(boolean czyOdpowiedzPoprawna) {
        this.czyOdpowiedzPoprawna = czyOdpowiedzPoprawna;
    }

}

