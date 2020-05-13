
import static org.junit.Assert.*;

import Jocuri.Joc;
import Suport.SuportTehnic;
import Suport.Ticket;
import Utilizatori.Admin;
import Utilizatori.Utilizator;
import org.junit.Test;

public class TestRezolvaTicket {

    //test pozitiv; ticket rezolvat cu succes si inchis.
    @Test
    public void testRezolvaTicket() {

        Utilizator utilizator = new Utilizator("Tudor","123","Alex,Andreea","online",1,0);
        SuportTehnic suportTehnic = new SuportTehnic("SupportTest","Game Bugs");
        Admin admin = new Admin("Admin", "admin123");
        Joc joc = new Joc("GTA V", 2013, 20, 150, 400, false, true, 3, admin);
        utilizator.initializareBibliotecaDisponibila(joc);
        Ticket ticket = new Ticket(utilizator,suportTehnic,"Deschis","Nu pot achizitiona jocul GTA V.");
        suportTehnic.adaugareTicket(ticket);

        String mesajRezolvare = "Nu aveti nivelul minim necesar pentru a achizitiona jocul.";
        String mesajAsteptat = "Ticketul a fost inchis.";
        assertEquals("Eroare la inchiderea ticket-ului", mesajAsteptat, suportTehnic.rezolvaTicket(ticket, mesajRezolvare, true));
    }

    //test negativ; ticket cu valoare nula.
    @Test (expected = NullPointerException.class)
    public void testTicketNull() {
        try {
            SuportTehnic suportTehnic = new SuportTehnic("SupportTest", "Game Bugs");
            suportTehnic.adaugareTicket(null);

        } catch (NullPointerException npe) {
            String message = "Ticketul nu poate avea valoare nula!";
            assertEquals("Obiectul ticket null nu a generat exceptie", message, npe.getMessage());
            throw npe;
        }
        fail("NPE nu a fost aruncat!");
    }

}