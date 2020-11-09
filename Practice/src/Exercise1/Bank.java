package Exercise1;

public class Bank {
    private double balance;
    private double rate;

    public Bank(double balance, double rate) {
        this.balance = balance;
        this.rate = rate;
    }

    public double calculateInterest(){
        double interest = balance*(rate/1200);
        return interest;
    }
}
