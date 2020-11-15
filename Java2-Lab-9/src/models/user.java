package models;

public class user {
    private String username;
    private String password;
    private int role;
    private String updated;
    private String created;

    public user(String username, String password, int role, String updated, String created) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.updated = updated;
        this.created = created;
    }

    public user(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public user(){
        this.username = "";
        this.password = "";
        this.role = 0;
        this.updated = "";
        this.created = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return String.format("%-30s%-30s%-30d%-30s%-30s", username, password, role, created, updated);
    }
}
