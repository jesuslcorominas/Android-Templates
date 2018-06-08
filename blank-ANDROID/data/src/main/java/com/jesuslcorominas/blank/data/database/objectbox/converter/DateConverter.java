package com.jesuslcorominas.blank.data.database.objectbox.converter;

import org.joda.time.DateTime;

import io.objectbox.converter.PropertyConverter;

/**
 * @author Jesús López Corominas
 */
public class DateConverter implements PropertyConverter<DateTime, Long> {

    @Override
    public DateTime convertToEntityProperty(Long databaseValue) {
        if (databaseValue == null) {
            return null;
        }

        return new DateTime(databaseValue);
    }

    @Override
    public Long convertToDatabaseValue(DateTime entityProperty) {
        return entityProperty.getMillis();
    }
}
