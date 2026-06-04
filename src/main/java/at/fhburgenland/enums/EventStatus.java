package at.fhburgenland.enums;

public enum EventStatus {
    PLANNED("planned"),
    CONFIRMED("confirmed"),
    CANCELLED("cancelled"),
    COMPLETED("completed");

    private final String dbValue;

    EventStatus(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static EventStatus fromString(String value) {
        if (value == null || value.isBlank()) {
            return PLANNED;
        }
        for (EventStatus eventStatus : values()) {
            if (eventStatus.name().equalsIgnoreCase(value)
                    || eventStatus.dbValue.equalsIgnoreCase(value)) {
                return eventStatus;
            }
        }

        throw new IllegalArgumentException(
                "Ungültige Event-Status: " + value
        );
    }
}