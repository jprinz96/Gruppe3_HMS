package at.fhburgenland.enums.converter;

import at.fhburgenland.enums.RoomCategory;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoomCategoryConverter implements AttributeConverter<RoomCategory, String> {

    @Override
    public String convertToDatabaseColumn(RoomCategory category) {
        return category == null ? null : category.getDbValue();
    }

    @Override
    public RoomCategory convertToEntityAttribute(String dbValue) {
        return dbValue == null ? null : RoomCategory.fromString(dbValue);
    }
}

