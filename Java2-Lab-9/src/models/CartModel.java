package models;

public class CartModel {
    private int bookID;
    private String title;
    private float price;
    private int amount;

    public CartModel(int bookID, String title, float price, int amount) {
        this.bookID = bookID;
        this.title = title;
        this.price = price;
        this.amount = amount;
    }

    public CartModel(int bookID, int amount) {
        this.bookID = bookID;
        this.amount = amount;
    }

    public CartModel() {
        this.bookID = 0;
        this.title = "";
        this.price = 0;
        this.amount = 0;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
