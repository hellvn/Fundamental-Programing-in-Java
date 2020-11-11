public class  customer {
    private String username;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;

    public customer(String username, String customerName, String customerAddress, String customerEmail, String customerPhone) {
        this.username = username;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public String toString() {
        return "INSERT INTO customer (username, name, address, email, phone) VALUES ('"+username+"', '"+customerName+"', '"+customerAddress+"', '"+customerEmail+"', '"+customerPhone+"')";
    }
}
