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
}