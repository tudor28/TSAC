package Suport;

import Jocuri.Server;

import java.util.ArrayList;

public class SuportTehnic {

    String nume;
    String specializare;
    Server server;
    ArrayList<Ticket> listaTickete;
    public SuportTehnic(){

    }

    public SuportTehnic(String nume, String specializare){

        this.nume = nume;
        this.specializare = specializare;
        listaTickete = new ArrayList<Ticket>();
    }

    public void afisareTicketeDeschise(){
        int cont=1;
        System.out.println("Lista completa a ticketelor deschise: ");
        for(int i=0;i<listaTickete.size();i++)
            if(listaTickete.get(i).status.equals("Deschis"))
            {
                System.out.println("Ticketul deschis nr. "+cont+":");
                listaTickete.get(i).afisareText();
                System.out.print("\n");
                cont++;
            }
    }


    public void adaugareTicket(Ticket t){
        if (t == null) {
            throw new NullPointerException("Ticketul nu poate avea valoare nula!");
        }
        listaTickete.add(t);
    }
    public String rezolvaTicket(Ticket ticket, String mesajRezolvare, Boolean inchideTicket) throws NullPointerException {

        if (ticket == null) {
            throw new NullPointerException("Ticketul nu poate avea valoare nula!");
        }

        if (!ticket.status.equals("Deschis")) {
            return "Ticketul este inchis!";
        } else {
            ticket.setText(mesajRezolvare);
            ticket.setStatus("Rezolvat");
            if (inchideTicket) {
                ticket.setStatus("Inchis");
                return "Ticketul a fost inchis.";
            } else {
                return "Ticket rezolvat. Va ramane deschis.";
            }
        }
    }
}
