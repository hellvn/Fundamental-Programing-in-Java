package models;

public class  customer {
    private String username;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;
    private String created;
    private String updated;

    public customer(String username, String customerName, String customerAddress, String customerEmail, String customerPhone, String created, String updated) {
        this.username = username;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.created = created;
        this.updated = updated;
    }

    public customer(String username, String customerName, String customerAddress, String customerEmail, String customerPhone) {
        this.username = username;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public customer(){
        this.username = "";
        this.customerName = "";
        this.customerAddress = "";
        this.customerEmail = "";
        this.customerPhone = "";
        this.created = "";
        this.updated = "";
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return String.format("%-30s%-30s%-30s%-30s%-30s%-30s%-30s", username, customerName,customerAddress,customerEmail,customerPhone,created,updated);
    }
}
