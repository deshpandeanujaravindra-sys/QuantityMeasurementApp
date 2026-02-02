package com.apps.quantityMeasurement;

import java.math.BigDecimal;
import java.util.Optional;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        demonstreateLengthComparison(1, Length.LengthUnit.FEET, 12, Length.LengthUnit.INCHES);
        demonstreateLengthComparison(1, Length.LengthUnit.YARDS, 36, Length.LengthUnit.INCHES);
        demonstreateLengthComparison(100, Length.LengthUnit.CENTIMETERS, 39.3701, Length.LengthUnit.INCHES);
        demonstreateLengthComparison(3, Length.LengthUnit.FEET, 1, Length.LengthUnit.YARDS);
        demonstreateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS, 1.0, Length.LengthUnit.FEET);

    }

    public static void demonstreateLengthComparison(double value, Length.LengthUnit lengthUnit, double value2, Length.LengthUnit lengthunit2) {
        if (lengthunit2 != null && lengthUnit != null){
        boolean status = (new Length(value, lengthUnit).equals(new Length(value2, lengthunit2))) ? true : false;
        System.out.println("Equality status for "+value +" "+lengthUnit+" and "+ value2+ " "+lengthunit2+" : "+ status);}
    }
}

