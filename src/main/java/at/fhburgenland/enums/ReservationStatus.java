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

    public static ReservationStatus fromString(String value) {
        if (value == null || value.isBlank()) {
            return BOOKED;
        }
        for (ReservationStatus reservationStatus : values()) {
            if (reservationStatus.name().equalsIgnoreCase(value)
                    || reservationStatus.dbValue.equalsIgnoreCase(value)) {
                return reservationStatus;
            }
        }

        throw new IllegalArgumentException(
                "Ungültige Reservation-Status: " + value
        );
    }
}