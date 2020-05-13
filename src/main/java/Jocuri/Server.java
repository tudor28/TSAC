package Jocuri;

import Utilizatori.Admin;
import Suport.SuportTehnic;
import Utilizatori.Utilizator;

import java.util.ArrayList;

public class Server {

    boolean disponibilitate;
    ArrayList<Utilizator> listaJucatori;
    Admin a;
    SuportTehnic st;
    public Server(){

    }

    public Server(boolean d){

        this.disponibilitate=d;
        listaJucatori=new ArrayList<Utilizator>();
    }
    public void adaugareJucator(Utilizator u){
        listaJucatori.add(u);
    }
    public boolean isDisponibilitate() {
        return disponibilitate;
    }

    public void setDisponibilitate(boolean disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

}
