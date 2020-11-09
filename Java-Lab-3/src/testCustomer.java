public class testCustomer {
    public static void main(String[] args) {
        ClassCustomer objCustomer = new ClassCustomer();

        objCustomer.CustomerID = 100;
        objCustomer.CustomerName = "Jack";
        objCustomer.CustomerAddress = "123 Street";
        objCustomer.CustomerAge = 30;

        objCustomer.changeCustomerAddress("123 Fort, Main Street");
        objCustomer.displayCustomerInformation();

    }
}
