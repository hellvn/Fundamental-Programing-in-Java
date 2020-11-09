public class ClassCustomer {
    int CustomerID;
    String CustomerName;
    String CustomerAddress;
    int CustomerAge;

    void changeCustomerAddress(String address){
        CustomerAddress = address;
    }
    void displayCustomerInformation(){
        System.out.println("Customer Identification Number: " + CustomerID);
        System.out.println("Customer Name: " + CustomerName);
        System.out.println("Customer Address: " + CustomerAddress);
        System.out.println("Customer Age: " + CustomerAge);
    }
}
