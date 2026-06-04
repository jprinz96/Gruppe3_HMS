package at.fhburgenland.enums;

public enum MaintenanceStatus {
    OPEN("open"),
    COMPLETED("completed");

    private final String dbValue;

    MaintenanceStatus(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static MaintenanceStatus fromString(String value) {
        if (value == null || value.isBlank()) {
            return OPEN;
        }
        for (MaintenanceStatus status : MaintenanceStatus.values()) {
            if (status.name().equalsIgnoreCase(value)
                    || status.dbValue.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Ungültiger Wert für MaintenanceStatusConverter: " + value);
    }
}