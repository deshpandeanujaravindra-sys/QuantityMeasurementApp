package com.apps.quantitymeasurement;

import java.util.function.Function;

public enum TemperatureuUnit implements IMeasureable {

    CELSIUS(false),
    FAHRENHEIT(true),
    KELVIN(false);

    // Functional Interface for Fahrenheit to Celsius conversion
    final Function<Double, Double> FAHRENHEIT_TO_CELSIUS =
            (fahrenheit) -> (fahrenheit - 32) * 5 / 9;

    // Functional Interface for Celsius to Celsius conversion
    final Function<Double, Double> CELSIUS_TO_CELSIUS =
            (celsius) -> celsius;

    Function<Double, Double> conversionValue;

    SupportsArithmetic supportsArithmetic = () -> false;

    TemperatureuUnit(boolean isFahrenheit) {

        if (isFahrenheit) {
            conversionValue = FAHRENHEIT_TO_CELSIUS;
        } else {
            conversionValue = CELSIUS_TO_CELSIUS;
        }
    }

    @Override
    public double convertToBaseUnit(double value) {

        if (this == KELVIN) {
            return value - 273.15;
        }

        return conversionValue.apply(value);
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {

        if (this == FAHRENHEIT) {
            return (baseValue * 9 / 5) + 32;
        }

        if (this == KELVIN) {
            return baseValue + 273.15;
        }

        return baseValue;
    }

    @Override
    public SupportsArithmetic supportsArithmetic() {
        return supportsArithmetic;
    }
}
