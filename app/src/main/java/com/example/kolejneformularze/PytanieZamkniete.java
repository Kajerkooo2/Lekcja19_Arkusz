package com.example.kolejneformularze;
public class PytanieZamkniete extends Pytanie {
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

    @Override
    public boolean sprawdzOdpowiedź(char odpowiedz) {
        char odpowiedzWielka = Character.toUpperCase(odpowiedz);
        boolean czyPoprawna = odpowiedzWielka == this.poprawnaOdpowiedz;
        this.czyOdpowiedzPoprawna = czyPoprawna;
        return czyPoprawna;
    }

}
