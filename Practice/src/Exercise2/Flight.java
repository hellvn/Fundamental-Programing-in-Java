package Exercise2;

public class Flight {
    private int number;
    private String destination;

    public Flight() {
        this.destination = "";
        this.number = 0;
    }

    public Flight(int number, String destination) {
        this.number = number;
        this.destination = destination;
    }

    public int getNumber() {
        return number;
    }

    public String getDestination() {
        return destination;
    }
    void display(){
        System.out.printf("%d, %s", getNumber(), getDestination());
    }
}
