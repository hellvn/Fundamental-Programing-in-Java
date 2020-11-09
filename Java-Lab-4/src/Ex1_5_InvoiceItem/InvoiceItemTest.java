package Ex1_5_InvoiceItem;

public class InvoiceItemTest {
    public static void main(String[] args) {
        InvoiceItem i1 = new InvoiceItem("A001","PD02", 500, 9.99);
        System.out.println(i1);
        System.out.println("Id is: "+i1.getId());
        System.out.println("Desc is: "+i1.getDesc());
        System.out.println("Quantity is: "+i1.getQty());
        System.out.println("Unit Price is: "+i1.getUnitPrice());
        System.out.println("Total: "+i1.getTotal());
    }
}
