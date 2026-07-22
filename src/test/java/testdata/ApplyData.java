package testdata;

import models.Apply;

import java.time.LocalDate;

public class ApplyData {
    public static Apply DEFAULT = new Apply(
            "CAN - Vacation",
            LocalDate.of(2026,10,7),
            LocalDate.of(2026,10,8),
            "test comment",
            "Full Day"
    );
}
