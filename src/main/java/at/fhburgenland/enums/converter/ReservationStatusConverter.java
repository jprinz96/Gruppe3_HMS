package at.fhburgenland.enums.converter;

import at.fhburgenland.enums.ReservationStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ReservationStatusConverter implements AttributeConverter<ReservationStatus, String> {

    @Override
    public String convertToDatabaseColumn(ReservationStatus status) {
        return status == null ? null : status.getDbValue();
    }

    @Override
    public ReservationStatus convertToEntityAttribute(String dbValue) {
        return dbValue == null ? null : ReservationStatus.fromString(dbValue);
    }
}
