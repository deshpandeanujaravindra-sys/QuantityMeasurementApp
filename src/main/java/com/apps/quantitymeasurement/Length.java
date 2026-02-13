package com.apps.quantitymeasurement;

import java.util.Objects;

public class Length {
    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON = 1e-6;


    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
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


    public static Length add(Length l1, Length l2, LengthUnit targetUnit) {

        if (l1 == null || l2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        double base1 = l1.unit.convertToBaseUnit(l1.value);
        double base2 = l2.unit.convertToBaseUnit(l2.value);
        double sumInFeet = base1 + base2;
        double resultValue = targetUnit.convertFromBaseUnit(sumInFeet);
        return new Length(resultValue, targetUnit);
    }



    public Length convert(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException();
        }
        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);
        return new Length(converted, targetUnit);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Length other)) return false;
        double thisInFeet = this.unit.convertToBaseUnit(this.value);
        double otherInFeet = other.unit.convertToBaseUnit(other.value);
        return Math.abs(thisInFeet - otherInFeet) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(unit.convertToBaseUnit(value)));
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
