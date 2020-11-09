package Person;

public class Person {
    String name;
    String address;
    public Person(String name,String address){
        this.name = name;
        this.address = address;
    }
    public String getAddress() {return address;}
    public String getName() {return name;}
    public void setAddress(String address) {this.address = address;}

    @Override
    public String toString() {
        return "Person:" + "\n" +
                "name:'" + name + "\n" +
                "address:'" + address + '\'' ;
    }
}
