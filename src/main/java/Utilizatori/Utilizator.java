package Utilizatori;

import Jocuri.Achievement;
import Jocuri.Joc;
import Jocuri.Review;
import Suport.Ticket;

import java.util.ArrayList;

public class Utilizator {

    String nume;
    String parola;
    String listaPrieteni;
    String disponibilitate;
    int nivel;
    int listaPlayTime;
    ArrayList<Joc> bibliotecaJocuriDisponibila;
    ArrayList<Joc> listaJocuri;
    ArrayList<Achievement> listaAchiv;
    ArrayList<Ticket> listaTickete;
    ArrayList<Review> listaReview;

    public Utilizator(){ }

    public Utilizator(String nume, String parola, String listaPrieteni, String disponibilitate, int nivel, int listaPlayTime) {
        this.nume = nume;
        this.parola = parola;
        this.listaPrieteni = listaPrieteni;
        this.disponibilitate = disponibilitate;
        this.nivel = nivel;
        this.listaPlayTime = listaPlayTime;
        listaJocuri = new ArrayList<Joc>();
        listaAchiv = new ArrayList<Achievement>();
        listaTickete = new ArrayList<Ticket>();
        listaReview = new ArrayList<Review>();
        bibliotecaJocuriDisponibila = new ArrayList<Joc>();
    }

    public void adaugareReview(Review r){
        listaReview.add(r);
    }
    public void adaugareJucator(Ticket t){
        listaTickete.add(t);
    }
    public void adaugareAchiv(Achievement a){
        listaAchiv.add(a);
    }
    public void adaugareJoc(Joc j){
        listaJocuri.add(j);
    }
    public void setParola(String parola) {
        this.parola = parola;
    }
    public void initializareBibliotecaDisponibila(Joc j){
        bibliotecaJocuriDisponibila.add(j);
    }


    public Joc returneazaJoc(Joc j) {
        for (Joc joc : listaJocuri) {
            if (j.getNume().equals(joc.getNume())) {
                return j;
            }
        }
        return null;
    }

    public String cumparareJoc(Joc joc) throws Exception {

        if (joc == null){
            throw new NullPointerException("Jocul nu poate avea valoare nula!");
        }

        String numeJoc = joc.getNume();
        Boolean exists = false;

        // se cauta jocul in biblioteca de jocuri disponibila utilizatorului
        for (Joc joc1 : bibliotecaJocuriDisponibila) {
            if (numeJoc.toUpperCase().equals(joc1.nume.toUpperCase())) {
                exists = true;
                break;
            }
        }

        // jocul nu este disponibil pentru utilizator
        if(!exists) {
            return "Jocul pe care doriti sa il achizitionati nu exista in biblioteca disponibila pentru dvs.!";
        }

        // se verifica daca jocul exista deja in lista utilizatorului
        if(listaJocuri.size() != 0) {
            for (Joc joc1 : listaJocuri) {
                if (numeJoc.equals(joc1.nume)) {
                    return "Jocul pe care doriti sa il cumparati exista deja in lista dvs!";
                }
            }
        }

        // ultimele conditii pentru adaugarea unui joc
        if (joc.getNrStoc() == 0) {
            throw new Exception("Jocul pe care doriti sa il cumparati nu exista pe stoc!");
        } else if (nivel < joc.getNivelMinim()) {
            throw new Exception("Nu aveti nivel suficient de mare pentru a achizitiona acest joc!");
        } else {
            adaugareJoc(joc);
            joc.setNrStoc(joc.getNrStoc() - 1);
            return "Jocul a fost achizitionat.";
        }
    }
}
