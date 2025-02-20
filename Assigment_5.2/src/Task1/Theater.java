package Task1;

import java.util.ArrayList;

public class Theater {
    private int seats;

    public Theater(int seats){
        this.seats = seats;
    }

    public synchronized boolean sellTickets(int tickets){
        if(this.seats >= tickets) {
            this.seats -= tickets;
            return true;
        }
        return false;
    }

    public int ticketsLeft() {
        return this.seats;
    }
}

class Customer extends Thread {
    private Theater theater;
    private int customerId;

    public Customer(Theater theater, int customerId) {
        this.theater = theater;
        this.customerId = customerId;
    }

    @Override
    public void run() {
        int tickets = (int) (Math.random() * 3) + 1;
        if ( theater.sellTickets(tickets) ) {
            System.out.println("Customer " + this.customerId + " reserved " + tickets + " tickets");
        }
        else {
            System.out.println("Customer " + this.customerId + " couldn't reserve " + tickets + " tickets");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Theater theater = new Theater(15);

        ArrayList<Customer> customers = new ArrayList<>();

        for(int i = 1; i <= 20; i++){
            Customer c = new Customer(theater, i);
            customers.add(c);
            c.start();
        }

        for( Customer c : customers ){
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Tickets left " + theater.ticketsLeft());
    }
}