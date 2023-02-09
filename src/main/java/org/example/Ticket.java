package org.example;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String from;
    protected String to;
    protected int minutes;


    @Override
    public int compareTo(Ticket o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.price < o.price) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Ticket(int price) {
        this.price = price;
    }

    public Ticket(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public Ticket(String from, String to, int price) {
        this.from = from;
        this.to = to;
        this.price = price;
    }


}
