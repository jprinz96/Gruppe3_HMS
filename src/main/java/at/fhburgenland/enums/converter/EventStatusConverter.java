package at.fhburgenland.enums.converter;

import at.fhburgenland.enums.EventStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EventStatusConverter implements AttributeConverter<EventStatus, String> {
    @Override
    public String convertToDatabaseColumn(EventStatus eventStatus) {
        return eventStatus == null ? null : eventStatus.getDbValue();
    }
    @Override
    public EventStatus convertToEntityAttribute(String dbValue) {
        return dbValue == null ? null : EventStatus.fromString(dbValue);
    }
}
