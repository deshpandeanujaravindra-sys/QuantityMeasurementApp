package com.app.quantitymeasurement;

public class quantityMeasurementApp {
    public static void main(String[] args) {
        demonstrateConvert(12, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        demonstrateConvert(03, Length.LengthUnit.YARDS, Length.LengthUnit.FEET);
        demonstrateConvert(26, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);
        demonstrateConvert(1, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        demonstrateConvert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

    }

    public static void demonstrateConvert(double value, Length.LengthUnit unit, Length.LengthUnit unit2) {
        double result = Length.convert(value, unit, unit2);
        System.out.println("Converted Value of "+value+" from " + unit + " to "+ unit2 +" is: "+result );
    }

}
