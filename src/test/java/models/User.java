package models;

public class User {
    private String username;
    private String role;
    private String status;
    private String employeeName;
    private String password;

    public User(
            String username, String role, String status,
            String employeeName, String password) {
        this.username = username;
        this.role = role;
        this.status = status;
        this.employeeName = employeeName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getRole() {
        return role;
    }
    public  String getStatus() {
        return status;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
