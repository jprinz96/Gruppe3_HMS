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
}