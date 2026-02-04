package com.app.quantitymeasurement;

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

    }

    public Length(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public static double convert(double value, LengthUnit unitOne, LengthUnit unitTwo) {

        if (unitOne == null || unitTwo == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }

        double valueInInches = value * unitOne.getConversionFactor();
        // System.out.println("value" + value + "  unitOne  "+unitOne.conversionFactor);
        double convertedValue = valueInInches / unitTwo.getConversionFactor();
        return convertedValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Length other = (Length) obj;

        double thisInFeet = this.value * this.unit.getConversionFactor();
        double otherInFeet = other.value * other.unit.getConversionFactor();

        return Double.compare(thisInFeet, otherInFeet) == 0;
    }


    public static double add(Length length, Length length2, LengthUnit targetUnit) {
        double firstConvertedValue = convert(length.value, length.unit, targetUnit);
        double secondConvertedValue = convert(length2.value, length2.unit, targetUnit);
        return (firstConvertedValue + secondConvertedValue);
    }
}
