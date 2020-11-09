package Exercise1;

public class TestBank {
    public static void main(String[] args) {
        Bank b1 = new Bank(100000.99, 0.5);
        System.out.printf("Your Monthly interest is: $%.2f.",b1.calculateInterest());
    }
}
