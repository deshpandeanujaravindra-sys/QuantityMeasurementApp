package com.apps.quantityMeasurement;
import com.apps.quantityMeasurement.Length;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        additionDemonstration(new Length(72, Length.LengthUnit.INCHES),new Length(6, Length.LengthUnit.FEET), Length.LengthUnit.YARDS);

    }

    public static Length additionDemonstration(Length lengthOne, Length lengthTwo, Length.LengthUnit targetUnit) {
        Length result = Length.add(lengthOne,lengthTwo,targetUnit);
        System.out.println("Addition of " + lengthOne.getValue() + " "+ lengthOne.getUnit() + " and " + lengthTwo.getValue() +" "+ lengthTwo.getUnit()+ " is " + result.getValue() + " "+result.getUnit());
        //  Length lengthResult = new Length(result,lengthOne.getUnit());
        return result;
    }
}
