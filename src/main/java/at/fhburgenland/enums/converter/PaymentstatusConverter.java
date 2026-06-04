package at.fhburgenland.enums.converter;

import at.fhburgenland.enums.PaymentStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PaymentstatusConverter implements AttributeConverter<PaymentStatus, String> {

    @Override
    public String convertToDatabaseColumn(PaymentStatus status) {
        return status == null ? null : status.getDbValue();
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String dbValue) {
        return dbValue == null ? null : PaymentStatus.fromString(dbValue);
    }

}
