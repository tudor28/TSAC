package Jocuri;

import Utilizatori.Utilizator;

import java.util.ArrayList;

public class Achievement {

    Joc joc;
    String nume;
    String obiectiv;
    ArrayList<Utilizator> listaJucatori;

    public Achievement() { }

    public Achievement(Joc joc, String nume, String obiectiv) {
        this.joc= joc;
        this.nume= nume;
        this.obiectiv= obiectiv;
        listaJucatori=new ArrayList<Utilizator>();
    }

    public void adaugareJucator(Utilizator u) {
        listaJucatori.add(u);
    }

    public String getNume() {
        return nume;
    }

    public String getObiectiv() {
        return obiectiv;
    }

}