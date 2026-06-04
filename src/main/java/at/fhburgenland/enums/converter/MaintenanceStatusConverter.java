package at.fhburgenland.enums.converter;

import at.fhburgenland.enums.MaintenanceStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MaintenanceStatusConverter implements AttributeConverter<MaintenanceStatus, String> {

    @Override
    public String convertToDatabaseColumn(MaintenanceStatus status) {
        return status == null ? null : status.getDbValue();
    }

    @Override
    public MaintenanceStatus convertToEntityAttribute(String dbValue) {
        return dbValue == null ? null : MaintenanceStatus.fromString(dbValue);
    }

}
