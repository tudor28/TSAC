package Utilizatori;
import Jocuri.Joc;
import Jocuri.Stire;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    String nume;
    String parola;
    ArrayList<Stire> listaStiri;
    ArrayList<Utilizator> listaUtilizatori;
    ArrayList<Joc> listaJocuri;

    public Admin(){

    }

    public Admin(String nume, String parola) {
        this.nume = nume;
        this.parola = parola;
        listaStiri = new ArrayList<Stire>();
        listaUtilizatori = new ArrayList<Utilizator>();
        listaJocuri = new ArrayList<Joc>();
    }

    public void adaugareJucator(Utilizator u){
        listaUtilizatori.add(u);
    }
    public void adaugareJucator(Stire s){
        listaStiri.add(s);
    }
    public void adaugareJucator(Joc j){
        listaJocuri.add(j);
    }

    public int actualizareJoc(Joc jocDeActualizat){
        System.out.println("Ce doriti sa modificati la jocul "+jocDeActualizat.nume+ "?( (n)ume/(a)n/(r)educere/(p)ret/(s)stoc/(sl)stoc Limitat/exit )");
        jocDeActualizat.afisare();
        Scanner reader = new Scanner(System.in);
        String consoleInput = reader.next();
        String n = jocDeActualizat.getNume();
        int an = jocDeActualizat.getAn(), val = jocDeActualizat.getReducere(), pret = jocDeActualizat.getPret(), cant = jocDeActualizat.getNrStoc();
        while(true)
        {
            if ("n".equals(consoleInput.toLowerCase())) {
                System.out.println("Intorduceti noul nume:");
                n = reader.next();
            } else if ("a".equals(consoleInput.toLowerCase())) {
                System.out.print("Intorduceti noul an (AAAA): ");
                an = reader.nextInt();
            } else if ("r".equals(consoleInput.toLowerCase())) {
                System.out.print("Intorduceti noua valoare a reducerii: ");
                val = reader.nextInt();
            } else if ("p".equals(consoleInput.toLowerCase())) {
                System.out.print("Intorduceti noul pret: ");
                pret = reader.nextInt();
            } else if ("sl".equals(consoleInput.toLowerCase())) {//System.out.println("Este jocul in stoc limitat?");
                if (jocDeActualizat.getStocLimitat() == true && jocDeActualizat.getNrStoc() >= 5) {
                    jocDeActualizat.setStocLimitat(false);
                    System.out.println("Jocul nu mai este stoc limitat!");
                } else {
                    jocDeActualizat.setStocLimitat(true);
                    System.out.println("Jocul a intrat in stoc limitat!");
                }
            } else if ("s".equals(consoleInput.toLowerCase())) {
                System.out.print("Introduceti noua cantitate din stoc: ");
                cant = reader.nextInt();
            } else if ("exit".equals(consoleInput.toLowerCase())) {
                System.out.println("Doriti sa salvati(D/N) ?");
                String alegere = reader.next();
                if (alegere.toUpperCase().equals("N"))
                    return 1;//s-a ales renuntarea salvarii datelor
                jocDeActualizat.setNume(n);
                jocDeActualizat.setReducere(val);
                jocDeActualizat.setRedus(true);
                jocDeActualizat.setAn(an);
                jocDeActualizat.setPret(pret);
                jocDeActualizat.setNrStoc(cant);
                System.out.println("Modificari salvate!");
                jocDeActualizat.afisare();
                reader.close();
                return 2;// datele au fost modificate cu succes
            }
            System.out.println("Ce doriti sa modificati in continuare? ( (n)ume/(a)n/(r)educere/(p)ret/(s)stoc/(sl)stoc Limitat/exit )");
            consoleInput = reader.next();
        }
    }
}
