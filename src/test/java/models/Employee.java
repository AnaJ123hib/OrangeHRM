package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Employee {

    private String firstName;
    private String middleName;
    private String lastName;
    private String employeeId;
    private String otherId;
    private String driversLicenseNumber;
    private String licenseExpiryDate;
    private String nationality;
    private String maritalStatus;
    private String dateOfBirth;
    private String gender;

    public String getFullName() {
        return String.join(" ",
                        firstName,
                        middleName == null ? "" : middleName,
                        lastName)
                .replaceAll("\\s+", " ")
                .trim();
    }
}
