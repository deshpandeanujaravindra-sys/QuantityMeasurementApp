package com.apps.quantitymeasurement;

import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasureable> {

    private final double value;
    private final U unit;

    private static final double EPSILON = 0.0001;

    public Quantity(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }


    private void validateArithmeticOperands(Quantity<U> other,
                                            U targetUnit,
                                            boolean targetUnitRequired) {

        if (other == null)
            throw new IllegalArgumentException("Other quantity cannot be null");

        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");

        if (!Double.isFinite(other.value))
            throw new IllegalArgumentException("Value must be finite");

        if (targetUnitRequired && targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
    }

    /* Core Helper Method */


    private double performBaseArithmetic(Quantity<U> other,
                                         ArithmeticOperation operation) {

        double baseValue1 = unit.convertToBaseUnit(value);
        double baseValue2 = other.unit.convertToBaseUnit(other.value);

        return operation.compute(baseValue1, baseValue2);
    }

    private double roundToTwoDecimals(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    // ADD (implicit target unit)
    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    // ADD (explicit target unit)
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);

        double baseResult = performBaseArithmetic(other, ArithmeticOperation.ADD);
        double converted = targetUnit.convertFromBaseUnit(baseResult);

        return new Quantity<>(roundToTwoDecimals(converted), targetUnit);
    }

    // SUBTRACT (implicit target unit)
    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    // SUBTRACT (explicit target unit)
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);

        double baseResult = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        double converted = targetUnit.convertFromBaseUnit(baseResult);

        return new Quantity<>(roundToTwoDecimals(converted), targetUnit);
    }

    // DIVIDE (returns scalar)
    public double divide(Quantity<U> other) {
        validateArithmeticOperands(other, null, false);

        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }


    public double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        if (!unit.getClass().equals(other.unit.getClass()))
            return false;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toBaseUnit() / EPSILON));
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }

    public enum ArithmeticOperation {

        ADD((a, b) -> a + b),

        SUBTRACT((a, b) -> a - b),

        DIVIDE((a, b) -> {
            if (b == 0)
                throw new ArithmeticException("Division by zero");
            return a / b;
        });

        private final DoubleBinaryOperator operation;

        ArithmeticOperation(DoubleBinaryOperator operation) {
            this.operation = operation;
        }

        public double compute(double a, double b) {
            return operation.applyAsDouble(a, b);
        }
    }
}