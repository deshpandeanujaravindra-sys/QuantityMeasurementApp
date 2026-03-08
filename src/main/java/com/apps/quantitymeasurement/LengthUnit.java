package com.apps.quantitymeasurement;


public enum LengthUnit implements IMeasureable {

    FEET(12),
    INCHES(1),
    YARDS(36),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double factor) {
        this.conversionFactor = factor;
    }

    public double getConversionFactor(){
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value){
        return value * getConversionFactor();
    }

    @Override
    public double convertFromBaseUnit(double baseValue){
        return baseValue / getConversionFactor();
    }

}
