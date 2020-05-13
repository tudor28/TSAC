package Main;

import Jocuri.Joc;
import Suport.SuportTehnic;
import Suport.Ticket;
import Utilizatori.Admin;
import Utilizatori.Utilizator;

public class Main {
    public static void main(String args[]) {
        Utilizator u = new Utilizator("Tudor", "123", "Alex,Andreea", "online", 1, 0);
        Utilizator u1 = new Utilizator("Alex", "123", "Tudor,Andreea", "online", 1, 0);
        Utilizator u2 = new Utilizator("Andreea", "123", "Alex,Tudor", "online", 1, 0);
        Admin a = new Admin("MVP", "admin123");
        Joc j = new Joc("Hearthstone", 2014, 0, 10, 1000, false, false, 1, a);
        Joc j1 = new Joc("GTA V", 2013, 20, 150, 400, false, true, 3, a);
        SuportTehnic st = new SuportTehnic("Support123", "All");
        Ticket t1 = new Ticket(u, st, "Deschis", "Nu pot achizitiona jocul GTA V.");
        u1.initializareBibliotecaDisponibila(j);
        u1.initializareBibliotecaDisponibila(j1);
        //u1.cumparareJoc();
        st.adaugareTicket(t1);
        // st.rezolvaTicket();
        //a.actualizareJoc(j);
    }
}

//    public String cumparareJoc(Utilizator utilizator, Joc joc) throws IOException {
//        return utilizator.cumparareJoc(joc);
//    }

//    public int rezolvaTicket(SuportTehnic suportTehnic){
//        return suportTehnic.rezolvaTicket();
//    }

//    public int actualizeazaJoc(Admin admin, Joc joc){
//        return admin.actualizareJoc(joc);
//    }
//}
