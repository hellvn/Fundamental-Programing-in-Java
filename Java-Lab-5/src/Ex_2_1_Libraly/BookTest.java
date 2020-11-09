package Ex_2_1_Libraly;

public class BookTest {
    public static void main(String[] args) {
        Author vuong = new Author("Hoang Minh Vuong", "vuongpt93@gmail.com", 'M');
        System.out.println(vuong);

        Book vuongbook = new Book("Java for dummy",vuong, 19.95, 99);
        System.out.println(vuongbook);

        vuongbook.setPrice(29.95);
        vuongbook.setQty(28);
        System.out.println("Book name is: "+vuongbook.getName());
        System.out.println("price is: "+vuongbook.getPrice());
        System.out.println("qty is: "+vuongbook.getQty());
        System.out.println("Author is: "+vuongbook.getAuthor());
        System.out.println("Author's name is: "+vuongbook.getAuthor().getName());
        System.out.println("Author's email is: "+vuongbook.getAuthor().getEmail());

        Book anotherBook = new Book("more Java", new Author("Dang Kim Thi", "dangkimthi@gmail.com",'F'), 29.95);
        System.out.println(anotherBook);
    }
}
