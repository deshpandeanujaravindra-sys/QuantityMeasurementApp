package com.app.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        Length length = new Length(12, Length.LengthUnit.FEET);
        Length length1 = new Length(36, Length.LengthUnit.INCHES);
        double result = Length.add(length, length1, Length.LengthUnit.FEET);
        additionDemonstration(length,length1);
    }

    public static Length additionDemonstration(Length lengthOne, Length lengthTwo ) {
        double result = Length.add(lengthOne,lengthTwo,lengthOne.getUnit());
        System.out.println("Addition of " + lengthOne.getValue() + " "+ lengthOne.getUnit() + " and " + lengthTwo.getValue() +" "+ lengthTwo.getUnit()+ " is " + result + " "+lengthOne.getUnit());
        Length lengthResult = new Length(result,lengthOne.getUnit());
        return lengthResult;
    }
}