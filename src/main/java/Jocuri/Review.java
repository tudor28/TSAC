package Jocuri;

import Utilizatori.Utilizator;

public class Review {

    Joc joc;
    Utilizator utilizator;
    String text;
    Utilizator u;
    public Review(){

    }

    public Review(Joc j,Utilizator u,String t){

        this.joc=j;
        this.utilizator=u;
        this.text=t;
    }

    public String citesteReview() {
        return text;
    }


}
