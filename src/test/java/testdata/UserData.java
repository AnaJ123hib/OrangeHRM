package testdata;

import models.User;

public class UserData {
    public static final User DEFAULT_USER = new User(
            "userExample",
            "Enabled",
            "Admin",
            "Peter Mac Anderson",
            "Password123!"
    );

    public static final User EDITED_USER = new User(
            "userEdited",
            "Disabled",
            "ESS",
            "Peter Mac Anderson",
            ""
    );
}
