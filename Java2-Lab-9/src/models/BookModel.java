package models;

public class BookModel {
    private int bookID;
    private String title;
    private String author;
    private int published;
    private int qty;
    private float price;
    private int status;
    private String created;
    private String updated;

    public BookModel(int bookID, String title, String author, int published, int qty, float price, int status, String created, String updated) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.published = published;
        this.qty = qty;
        this.price = price;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    public BookModel(int bookID, String title, String author, int published, int qty, float price) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.published = published;
        this.qty = qty;
        this.price = price;

    }
    public BookModel(){
        bookID=0;
        title="";
        author="";
        published=0;
        qty=0;
        price=0;
        status=0;
        created="";
        updated="";
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%-30d%-30s%-30s%-30d%-30d%-30d%-30f%-30s%-30s\n",bookID,title,author,published,status,qty,price,created,updated);
    }
}
