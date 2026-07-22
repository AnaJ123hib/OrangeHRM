package testdata;

import models.User;

public class UserData {
    public static final User DEFAULT_USER = new User(
            "userExample",
            "Enabled",
            "Admin",
            EmployeeData.DEFAULT_EMPLOYEE,
            "Password123!"
    );

    public static final User EDITED_USER = new User(
            "userEdited",
            "Disabled",
            "ESS",
            EmployeeData.DEFAULT_EMPLOYEE,
            ""
    );
}
