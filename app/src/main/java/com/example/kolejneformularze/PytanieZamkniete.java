package com.example.kolejneformularze;
public abstract class PytanieZamkniete extends Pytanie {
    private String odpowiedzA;
    private String odpowiedzB;
    private String odpowiedzC;
    private char poprawnaOdpowiedz;

    public PytanieZamkniete(String trescPytania, String nazwaPliku,
                            String odpowiedzA, String odpowiedzB,
                            String odpowiedzC, char poprawnaOdpowiedz) {
        super(trescPytania, nazwaPliku);
        this.odpowiedzA = odpowiedzA;
        this.odpowiedzB = odpowiedzB;
        this.odpowiedzC = odpowiedzC;
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
    }

    @Override
    public boolean sprawdzOdpowiedz(char odpowiedz) {
        char odpowiedzWielka = Character.toUpperCase(odpowiedz);
        boolean czyPoprawna = odpowiedzWielka == this.poprawnaOdpowiedz;
        this.czyOdpowiedzPoprawna = czyPoprawna;
        return czyPoprawna;
    }

    public String getOdpowiedzA() {
        return odpowiedzA;
    }

    public String getOdpowiedzB() {
        return odpowiedzB;
    }

    public String getOdpowiedzC() {
        return odpowiedzC;
    }

    public char getPoprawnaOdpowiedz() {
        return poprawnaOdpowiedz;
    }
}
