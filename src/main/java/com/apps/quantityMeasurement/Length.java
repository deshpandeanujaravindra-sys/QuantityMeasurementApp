package com.apps.quantityMeasurement;

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


    @Override

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Length other = (Length) obj;
        double thisInFeet = this.value * this.unit.getConversionFactor();
        double otherInFeet = other.value * other.unit.getConversionFactor();
        return Double.compare(thisInFeet, otherInFeet) == 0;
    }

    public static Length add(Length length, Length length2, LengthUnit targetUnit) {
        if (length == null || length2 == null) {
            throw new IllegalArgumentException("Operands cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double base1 = length.getUnit().convertToBaseUnit(length.getValue());
        double base2 = length2.getUnit().convertToBaseUnit(length2.getValue());
        double sumInBase = base1 + base2;
        double resultValue = targetUnit.convertFromBaseUnit(sumInBase);
        return new Length(resultValue, targetUnit);
    }
}
