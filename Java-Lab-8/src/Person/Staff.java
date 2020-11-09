package Person;

public class Staff extends Person{
    String school;
    double pay;
    public Staff(String name, String address,String school,double pay) {
        super(name, address);
        this.pay = pay;
        this.school = school;
    }
}
