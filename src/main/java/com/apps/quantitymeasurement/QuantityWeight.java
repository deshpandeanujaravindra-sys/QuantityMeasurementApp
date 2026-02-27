package com.apps.quantitymeasurement;


import java.util.Objects;

public class QuantityWeight  {

    private final double value;
    private final WeightUnit unit;
    public static final double EPSILON= 0.0001;

    public QuantityWeight(double value, WeightUnit unit) {
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

    public WeightUnit getUnit() {
        return unit;
    }

    public static QuantityWeight convert(QuantityWeight weight, WeightUnit targetUnit) {
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = weight.unit.convertToBaseUnit(weight.value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);
        return new QuantityWeight(converted, targetUnit);
    }

    public static QuantityWeight add(QuantityWeight w1,
                                     QuantityWeight w2,
                                     WeightUnit targetUnit) {

        if (w1 == null || w2 == null || targetUnit == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        double base1 = w1.unit.convertToBaseUnit(w1.value);
        double base2 = w2.unit.convertToBaseUnit(w2.value);

        double sumBase = base1 + base2;
        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new QuantityWeight(result, targetUnit);
    }

    public static QuantityWeight add(QuantityWeight w1,
                                     QuantityWeight w2) {

        if (w1 == null || w2 == null )
            throw new IllegalArgumentException("Arguments cannot be null");

        double base1 = w1.unit.convertToBaseUnit(w1.value);
        double base2 = w2.unit.convertToBaseUnit(w2.value);

        double sumBase = base1 + base2;
        double result = w1.getUnit().convertFromBaseUnit(sumBase);

        return new QuantityWeight(result, w1.getUnit());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityWeight)) return false;

        QuantityWeight other = (QuantityWeight) obj;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1-base2)<EPSILON;
    }

    @Override
    public int hashCode() {
        double baseValue = unit.convertToBaseUnit(value);
        return Objects.hash(baseValue);
    }

    public  QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        if (other == null || targetUnit == null)
            throw new IllegalArgumentException("Arguments cannot be null");
        double baseValue1 = this.unit.convertToBaseUnit(this.value);
        double baseValue2 = other.unit.convertToBaseUnit(other.value);
        double sumInBase = baseValue1 + baseValue2;
        double finalValue = targetUnit.convertFromBaseUnit(sumInBase);
        return new QuantityWeight(finalValue, targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
