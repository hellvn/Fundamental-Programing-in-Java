public class Customer {
    int CustomerID;
    String CustomerName;
    String CustomerAddress;
    int customerAge;

    public static void main(String[] args) {


        Customer objCustomer1 = new Customer();
        objCustomer1.CustomerID = 100;
        objCustomer1.CustomerName= "John";
        objCustomer1.CustomerAddress = "123 Street";
        objCustomer1.customerAge = 30;

        System.out.println("Customer Identification Number: " + objCustomer1.CustomerID);
        System.out.println("Customer Name: " + objCustomer1.CustomerName);
        System.out.println("Customer Address: " + objCustomer1.CustomerAddress);
        System.out.println("Customer Age: "  + objCustomer1.customerAge);
    }
}
