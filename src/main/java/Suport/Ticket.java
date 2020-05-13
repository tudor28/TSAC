package Suport;


import Utilizatori.Utilizator;

public class Ticket {

    Utilizator utilizator;
    SuportTehnic suport;
    String status;
    String text;

    public Ticket(){

    }

    public Ticket(Utilizator utilizator, SuportTehnic suportTehnic, String status, String text){
        this.utilizator = utilizator;
        this.suport = suportTehnic;
        this.status = status;
        this.text = text;
    }
    public void setText(String t){
        text = t;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void afisareText(){
        System.out.println(text);
    }

}
