package Jocuri;
import Utilizatori.Admin;
import Utilizatori.Utilizator;

import java.util.ArrayList;

public class Joc {

    public String nume;
    private int an;
    private int reducere;
    private int pret;
    private int nrStoc;
    private boolean stocLimitat;
    private boolean redus;
    private int nivelMinim;
    Admin admin;
    ArrayList<Achievement> listaAchiv;
    ArrayList<Utilizator> listaUtilizatori;
    ArrayList<Review> listaReview;

    public Joc(String nume, int an, int reducere, int pret, int nrStoc, boolean stocLimitat, boolean redus, int nivelMinim, Admin admin){

        this.nume=nume;
        this.an=an;
        this.reducere=reducere;
        this.pret=pret;
        this.nrStoc=nrStoc;
        this.stocLimitat=stocLimitat;
        this.redus=redus;
        this.nivelMinim=nivelMinim;
        this.admin=admin;
        listaAchiv=new ArrayList<Achievement>();
        listaUtilizatori=new ArrayList<Utilizator>();
        listaReview=new ArrayList<Review>();

    }
    public void afisare(){
        System.out.println("Nume: "+nume+", An: "+an+", Reducere: "+reducere+", Pret: "+pret+", Stoc: "+nrStoc+", Stoc Limitat: "+stocLimitat);
    }
    public void adaugareAchiv(Achievement a){
        listaAchiv.add(a);
    }
    public void adaugareJucator(Utilizator u){
        listaUtilizatori.add(u);
    }
    public void adaugareReview(Review r){
        listaReview.add(r);
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getReducere() {
        return reducere;
    }

    public void setReducere(int reducere) {
        this.reducere = reducere;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public boolean getStocLimitat() {
        return stocLimitat;
    }

    public void setStocLimitat(boolean stocLimitat) {
        this.stocLimitat = stocLimitat;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public void setNrStoc(int nrStoc) {
        this.nrStoc = nrStoc;
    }

    public void setRedus(boolean redus) {
        this.redus = redus;
    }

    public void setA(Admin admin) {
        this.admin = admin;
    }

    public void setListaAchiv(ArrayList<Achievement> listaAchiv) {
        this.listaAchiv = listaAchiv;
    }

    public void setListaUtilizatori(ArrayList<Utilizator> listaUtilizatori) {
        this.listaUtilizatori = listaUtilizatori;
    }

    public void setListaReview(ArrayList<Review> listaReview) {
        this.listaReview = listaReview;
    }

    public int getNrStoc() {
        return nrStoc;
    }

    public int getAn() {
        return an;
    }

    public boolean isRedus() {
        return redus;
    }

    public Admin getAdmin() {
        return admin;
    }

    public ArrayList<Achievement> getListaAchiv() {
        return listaAchiv;
    }

    public ArrayList<Utilizator> getListaUtilizatori() {
        return listaUtilizatori;
    }

    public ArrayList<Review> getListaReview() {
        return listaReview;
    }

    public int getNivelMinim() {
        return nivelMinim;
    }

    public void setNivelMinim(int nivelMinim) {
        this.nivelMinim = nivelMinim;
    }


}
