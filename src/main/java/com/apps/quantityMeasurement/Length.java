package com.apps.quantityMeasurement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Optional;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12),
        INCHES(1),
        YARDS(36),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }

        public double toInches(double value) {
            double convertedValue = value * conversionFactor;
            BigDecimal result= new BigDecimal(convertedValue).setScale(2, RoundingMode.DOWN);
            return result.doubleValue();
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit==null){
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return unit.toInches(value);

    }

    private Object obj;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;
        Length someObj = (Length) obj;
        return Double.compare(this.convertToBaseUnit(), someObj.convertToBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }
}
