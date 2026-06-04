package at.fhburgenland.enums;

public enum RoomCategory {

    STANDARD("Standard"),
    DELUXE("Deluxe"),
    SUITE("Suite");

    private final String dbValue;

    RoomCategory(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static RoomCategory fromString(String value) {
        for (RoomCategory category : values()) {
            if (category.name().equalsIgnoreCase(value)
                    || category.dbValue.equalsIgnoreCase(value)) {
                return category;
            }
        }

        throw new IllegalArgumentException(
                "Ungültige Zimmerkategorie: " + value
        );
    }
}