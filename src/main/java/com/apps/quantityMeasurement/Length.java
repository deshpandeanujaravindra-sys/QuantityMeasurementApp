package com.apps.quantityMeasurement;

import java.util.Objects;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12),
        INCHES(1);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }

        public double toInches(double value) {
            System.out.println(conversionFactor + "Conversion Factor" + value);
            return value * conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        System.out.println(value + "value from convertToBaseUnit");
        return unit.toInches(value);
    }

    private Object obj;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length)) return false;
        Length someObj = (Length) obj;
        System.out.println(this.value + " both" + someObj.value);
        System.out.println(this.convertToBaseUnit() + " both" + someObj.convertToBaseUnit());
        return Double.compare(this.convertToBaseUnit(), someObj.convertToBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }
}
