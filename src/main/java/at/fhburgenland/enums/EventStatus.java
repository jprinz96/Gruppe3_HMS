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
}