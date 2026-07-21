package enums;

public enum LeavesColumn {
    EMPLOYEE,
    STATUS;
    public static LeavesColumn from(String value) {
        return switch(value.toLowerCase()) {
            case "employee" -> EMPLOYEE;
            case "status" -> STATUS;
            default -> throw new IllegalArgumentException("Invalid column: " + value);
        };
    }
}
