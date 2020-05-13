import static org.junit.Assert.*;

import Jocuri.Joc;
import Utilizatori.Admin;
import Utilizatori.Utilizator;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCumparareJoc {
    private final static Logger LOGGER = Logger.getLogger(TestCumparareJoc.class.getName());

    //test pozitiv; utilizatorul cumpara un joc si indeplineste toate conditiile pentru acest lucru.
    @Test
    public void testCumparareJoc() {
        try {
            Utilizator utilizator = new Utilizator("Tudor", "123", "Alex, Andreea", "online", 1, 0);
            Admin admin = new Admin("Admin", "admin123");
           // Joc joc1 = new Joc("Hearthstone", 2014, 0, 10, 1000, false, false, 1, admin);
            Joc joc = new Joc("World of Warcraft", 2004, 0, 10, 1000, false, false, 1, admin);
            utilizator.initializareBibliotecaDisponibila(joc);

            assertEquals("Jocul nu a putut fi achizitionat", "Jocul a fost achizitionat.", utilizator.cumparareJoc(joc));
            assertEquals("Stocul jocului nu a scazut dupa achizitionare", 999, joc.getNrStoc());
            assertEquals("Jocul nu a fost adaugat in lista utilizatorului", joc, utilizator.returneazaJoc(joc));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Eroare la achizitionarea jocului");
        }
    }

    //test negativ; utilizatorul incearca sa cumpere un joc cu nivel minim necesar mai mare decat nivelul sau.
    @Test (expected = Exception.class)
    public void testCumparareJocNivel() throws Exception {
        try {
            Utilizator utilizator = new Utilizator("Tudor", "123", "Alex, Andreea", "online", 1, 0);
            Admin admin = new Admin("Admin", "admin123");
            Joc joc = new Joc("GTA V", 2013, 20, 150, 400, false, true, 3, admin);
            utilizator.initializareBibliotecaDisponibila(joc);
            utilizator.cumparareJoc(joc);

        } catch (Exception e) {
            String message = "Nu aveti nivel suficient de mare pentru a achizitiona acest joc!";
            assertEquals("Utilizatorul cu nivel mai mic decat cel necesar cumpararii unui joc a putut sa il achizitioneze", message, e.getMessage());
            throw e;
        }
        fail("Exceptia asteptata nu a fost aruncata!");
    }

    //test negativ; utilizatorul incearca sa cumpere un joc care nu este disponibil in biblioteca acestuia.
    @Test
    public void testCumparareJocIndisponibil() {
        try {
            Utilizator utilizator = new Utilizator("Tudor", "123", "Alex, Andreea", "online", 1, 0);
            Admin admin = new Admin("Admin", "admin123");
            Joc joc = new Joc("Hearthstone", 2014, 0, 10, 1000, false, false, 1, admin);

            String mesajAsteptat = "Jocul pe care doriti sa il achizitionati nu exista in biblioteca disponibila pentru dvs.!";
            assertEquals("Utilizatorul a putut sa cumpere un joc care nu era disponibil in biblioteca acestuia", mesajAsteptat, utilizator.cumparareJoc(joc));

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Jocul este disponibil, desi nu ar trebui sa fie");
        }
    }

    //test negativ; utilizatorul incearca sa cumpere un joc pe care il are deja.
    @Test
    public void testCumparareJocDejaExistent() {
        try {
            Utilizator utilizator = new Utilizator("Tudor", "123", "Alex, Andreea", "online", 1, 0);
            Admin admin = new Admin("Admin", "admin123");
            Joc joc = new Joc("Hearthstone", 2014, 0, 10, 1000, false, false, 1, admin);
            utilizator.initializareBibliotecaDisponibila(joc);
            utilizator.cumparareJoc(joc);

            String mesajAsteptat = "Jocul pe care doriti sa il cumparati exista deja in lista dvs!";
            assertEquals("Utilizatorul nu a primit eroare cand a incercat sa cumpere un joc pe care il avea deja", mesajAsteptat, utilizator.cumparareJoc(joc));

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Jocul deja existent a putut fi cumparat");
        }
    }

    //test negativ; utilizatorul incearca sa cumpere un joc cu stoc 0.
    @Test (expected = Exception.class)
    public void testCumparareJocFaraStoc() throws Exception {
        try {
            Utilizator utilizator1 = new Utilizator("Tudor", "123", "Alex, Andreea", "online", 1, 0);
            Utilizator utilizator2 = new Utilizator("Alin", "123", "Adrian, Alex", "online", 1, 0);
            Admin admin = new Admin("Admin", "admin123");
            Joc joc = new Joc("Hearthstone", 2014, 0, 10, 1, true, false, 1, admin);
            utilizator1.initializareBibliotecaDisponibila(joc);
            utilizator1.cumparareJoc(joc);
            utilizator2.initializareBibliotecaDisponibila(joc);
            utilizator2.cumparareJoc(joc);

        } catch (Exception e) {
            String mesajAsteptat = "Jocul pe care doriti sa il cumparati nu exista pe stoc!";
            assertEquals("Utilizatorul a putut cumpara un joc cu stoc 0", mesajAsteptat, e.getMessage());
            throw e;
        }
        fail("Exceptia asteptata nu a fost aruncata!");
    }

    //test negativ; valoare nula pentru obiectul joc.
    @Test (expected = NullPointerException.class)
    public void testJocNull() {
        try {
            Utilizator utilizator = new Utilizator("Tudor", "123", "Alex, Andreea", "online", 1, 0);
            utilizator.cumparareJoc(null);

        } catch (NullPointerException npe) {
            String message = "Jocul nu poate avea valoare nula!";
            assertEquals("Obiectul joc null nu a cauzat erori", message, npe.getMessage());
            throw npe;

        } catch (Exception e) {
            e.printStackTrace();
        }
        fail("NPE nu a fost aruncat!");
    }

}

