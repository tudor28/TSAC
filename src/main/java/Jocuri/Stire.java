package Jocuri;

import Utilizatori.Admin;

public class Stire {

    String text;
    Admin administrator;


    public Stire(){

    }

    public Stire(String t,Admin a){

        this.text=t;
        this.administrator=a;
    }

    public String citesteStire() {
        return text;
    }

}