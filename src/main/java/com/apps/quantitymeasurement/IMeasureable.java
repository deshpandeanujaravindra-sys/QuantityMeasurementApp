package com.apps.quantitymeasurement;

public interface IMeasureable {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    default SupportsArithmetic supportsArithmetic(){
        return() ->true;
    };

}

