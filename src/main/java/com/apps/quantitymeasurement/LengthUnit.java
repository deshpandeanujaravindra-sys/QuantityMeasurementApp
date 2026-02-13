package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(12),
    INCHES(1),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertToBaseUnit(double value) {
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Value cannot be NaN");
        }
        return value * conversionFactor;
    }

    public double convertFromBaseUnit(double baseValueInFeet) {
        if (Double.isNaN(baseValueInFeet)) {
            throw new IllegalArgumentException("Value cannot be NaN");
        }
        return baseValueInFeet / conversionFactor;
    }
}
