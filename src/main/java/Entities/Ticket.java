package Entities;

import javax.persistence.Id;


import java.util.UUID;


public class Ticket {

    @Id

    private String ticket_id;

    int price;


    public Ticket(int price) {

        this.price = price;

        this.ticket_id = UUID.randomUUID().toString();

    }


    public Ticket() {
    }

    public String getTicket_id() {
        return ticket_id;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }
}

