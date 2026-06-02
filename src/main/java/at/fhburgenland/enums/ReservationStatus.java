package at.fhburgenland.enums;

public enum ReservationStatus {
    BOOKED("booked"),
    CHECKED_IN("checked-in"),
    CHECKED_OUT("checked-out"),
    CANCELLED("cancelled");

    private final String dbValue;

    ReservationStatus(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }
}