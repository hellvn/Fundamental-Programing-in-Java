public class books {
    private int bookID;
    private String title;
    private String author;
    private int published;
    private int qty;
    private float price;
    private int status;

    public books(int bookID, String title, String author, int published, int qty, float price, int status) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.published = published;
        this.qty = qty;
        this.price = price;
        this.status = status;
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
        return "INSERT INTO books (`title`, `author`, `published`, `qty`, `price`) VALUES ('"+title+"', "+author+"', "+published+", "+qty+", "+price+")";
    }
}
