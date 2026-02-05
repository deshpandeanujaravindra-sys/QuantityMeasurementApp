package com.app.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        additionDemonstration(new Length(1, Length.LengthUnit.FEET),new Length(12, Length.LengthUnit.INCHES));
        additionDemonstration(new Length(1, Length.LengthUnit.FEET),new Length(2, Length.LengthUnit.FEET));
        additionDemonstration(new Length(1, Length.LengthUnit.FEET),new Length(12, Length.LengthUnit.INCHES));
        additionDemonstration(new Length(12, Length.LengthUnit.INCHES),new Length(1, Length.LengthUnit.FEET));
        additionDemonstration(new Length(1, Length.LengthUnit.YARDS),new Length(3, Length.LengthUnit.FEET));
        additionDemonstration(new Length(36, Length.LengthUnit.INCHES),new Length(1, Length.LengthUnit.YARDS));
        additionDemonstration(new Length(2.54, Length.LengthUnit.CENTIMETERS),new Length(1, Length.LengthUnit.INCHES));
        additionDemonstration(new Length(5, Length.LengthUnit.FEET),new Length(0, Length.LengthUnit.INCHES));
        additionDemonstration(new Length(5, Length.LengthUnit.FEET),new Length(-2.0, Length.LengthUnit.FEET));

    }

    public static Length additionDemonstration(Length lengthOne, Length lengthTwo ) {
        Length result = Length.add(lengthOne,lengthTwo,lengthOne.getUnit());
        System.out.println("Addition of " + lengthOne.getValue() + " "+ lengthOne.getUnit() + " and " + lengthTwo.getValue() +" "+ lengthTwo.getUnit()+ " is " + result.getValue() + " "+result.getUnit());
      //  Length lengthResult = new Length(result,lengthOne.getUnit());
        return result;
    }
}