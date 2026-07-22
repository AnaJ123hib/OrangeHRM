package models;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String role;
    @Setter
    @Getter
    private String status;
    private Employee employee;
    @Setter
    @Getter
    private String password;

    public User(
            String username, String role, String status,
            Employee employee, String password) {
        this.username = username;
        this.role = role;
        this.status = status;
        this.employee = employee;
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
