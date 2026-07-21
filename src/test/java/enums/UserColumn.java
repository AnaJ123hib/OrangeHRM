package enums;

public enum UserColumn{
    USERNAME,
    ROLE,
    STATUS;
    public static UserColumn from(String value) {
        return switch(value.toLowerCase()) {
            case "username" -> USERNAME;
            case "role" -> ROLE;
            case "status" -> STATUS;
            default -> throw new IllegalArgumentException("Invalid column: " + value);
        };
    }
}
