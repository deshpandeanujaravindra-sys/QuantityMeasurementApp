package com.apps.quantitymeasurement.model;

import com.apps.quantitymeasurement.IMeasureable;

public class QuantityModel <U extends IMeasureable> {

    private double value;
    private U unit;

    public QuantityModel(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public double getBaseValue() {
        return unit.convertToBaseUnit(value);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        QuantityModel<?> other = (QuantityModel<?>) obj;

        return Double.compare(
                this.unit.convertToBaseUnit(this.value),
                other.unit.convertToBaseUnit(other.value)
        ) == 0;
    }
}