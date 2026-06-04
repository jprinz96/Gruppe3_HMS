package at.fhburgenland.enums;

public enum PaymentStatus {
    OPEN("open"),
    OVERDUE("overdue"),
    PAID("paid"),
    CANCELLED("cancelled");

    private final String dbValue;

    PaymentStatus(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static PaymentStatus fromString(String value) {
        if (value == null || value.isBlank()) {
            return OPEN;
        }
        for (PaymentStatus paymentStatus : values()) {
            if (paymentStatus.name().equalsIgnoreCase(value)
                    || paymentStatus.dbValue.equalsIgnoreCase(value)) {
                return paymentStatus;
            }
        }

        throw new IllegalArgumentException(
                "Ungültige Payment-Status: " + value
        );
    }
}