package models;

public class cart {
    private int bookID;
    private String title;
    private int qty;
    private int amount;
    private int discount;

    public cart(){
        this.bookID = 0;
        this.title = "";
        this.qty = 0;
        this.amount = 0;
        this.discount = 0;
    }

    public cart(int bookID, String title, int qty) {
        this.bookID = bookID;
        this.title = title;
        this.qty = qty;
    }

    public cart(int bookID, String title, int qty, int amount, int discount) {
        this.bookID = bookID;
        this.title = title;
        this.qty = qty;
        this.amount = amount;
        this.discount = discount;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("%-30d%-30s%-30d%-30d%-30d", bookID, title, qty, amount, discount);
    }
}
