package Person;

public class Student extends Person{
    String programming;
    int year;
    double fee;
    public Student(String programming, int year, double fee,String name,String address){
        super(name, address);
        this.programming = programming;
        this.fee = fee;
        this.year = year;
    }
    public String getProgramming() {return programming;}
    public void setProgramming(String programming) {this.programming = programming;}
    public int getYear() { return year;}
    public void setYear(int year) {this.year = year;}
    public double getFee() {return fee;}
    public void setFee(double fee) {this.fee = fee;}

    @Override
    public String toString() {
        return "programming" + programming + "\n" + "year:" + year+ "\n" + "fee:" + fee;
    }
}
