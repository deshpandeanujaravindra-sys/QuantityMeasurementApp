package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasureable> {

    private static final double EPSILON = 0.0001;

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

public double toBaseUnit(){
        return unit.convertToBaseUnit(value);
}
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Quantity<?>)) return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (!unit.getClass().equals(other.unit.getClass()))
            return false;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public int hashCode() {
        double baseValue = unit.convertToBaseUnit(value);
        long rounded = Math.round(baseValue / EPSILON);
        return Objects.hash(rounded);
    }

    public Quantity<U> convert(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        if (other == null || targetUnit == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sum = base1 + base2;

        double finalValue = targetUnit.convertFromBaseUnit(sum);

        return new Quantity<>(finalValue, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {

        if (other == null )
            throw new IllegalArgumentException("Arguments cannot be null");

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sum = base1 + base2;

        double finalValue = other.getUnit().convertFromBaseUnit(sum);

        return new Quantity<>(finalValue, other.getUnit());
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validateQuantity(other);
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double thisBase = unit.convertToBaseUnit(this.value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double baseResult = thisBase - otherBase;

        double converted = targetUnit.convertFromBaseUnit(baseResult);
        double rounded = round(converted);

        return new Quantity<>(rounded, targetUnit);
    }

    public double divide(Quantity<U> other) {
        validateQuantity(other);

        double thisBase = unit.convertToBaseUnit(this.value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        if (otherBase == 0.0)
            throw new ArithmeticException("Division by zero");

        double result = thisBase / otherBase;
        return round(result);
    }


    private void validateQuantity(Quantity<U> other) {
        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (!Double.isFinite(other.value))
            throw new IllegalArgumentException("Other value must be finite");

        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
