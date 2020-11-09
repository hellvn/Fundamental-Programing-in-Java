package FlightTicket;

public class Ticket {
    private int numOfTicket;
    private String type;
    private double cost;

    public Ticket(int numOfTicket, String type, double cost){
        this.numOfTicket = numOfTicket;
        this.type = type;
        this.cost = cost;
    }

    public int getNumOfTicket() {
        return numOfTicket;
    }

    public void setNumOfTicket(int numOfTicket) {
        if (numOfTicket>0){
            this.numOfTicket = numOfTicket;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == "1"){
            this.type = "Business";
        }
        else if (type == "2"){
            this.type = "First";
        }
        else if (type == "3"){
            this.type = "Economy";
        }
        else{
            this.type = "Invalid choice!";
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (type == "1"){
            this.cost = cost*numOfTicket*3;
        }
        else if (type == "2"){
            this.cost = cost*numOfTicket*2;
        }
        else if (type == "3"){
            this.cost = cost*numOfTicket;
        }
    }

    @Override
    public String toString() {
        return "Number of ticket:"+numOfTicket+"\nType of cabin: "+type+"\nTotal cost of the ticket: "+cost;
    }
}
