package com.apps.quantityMeasurement;

import com.app.quantitymeasurement.Length;
import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementAppTest {


    private static final double DIFFERENCE = 1e-6;

    @Test
    public void testConversion_FeetToInches() {

        double result = Length.convert(1.0, Length.LengthUnit.FEET.FEET, Length.LengthUnit.INCHES);
        Assert.assertEquals(12.0, result, DIFFERENCE);

    }


    @Test
    public void testConversion_InchesToFeet() {

        double result = Length.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);

        Assert.assertEquals(2.0, result, DIFFERENCE);

    }


    @Test
    public void testConversion_YardsToInches() {

        double result = Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES);
        Assert.assertEquals(36.0, result, DIFFERENCE);
    }


    @Test
    public void testConversion_InchesToYards() {
        double result = Length.convert(72.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);
        Assert.assertEquals(2.0, result, DIFFERENCE);
    }


    @Test
    public void testConversion_CentimeterToInches() {
        double result = Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);
        Assert.assertEquals(1.0, result, DIFFERENCE);

    }

    @Test
    public void testConversion_FeetToYard() {
        double result = Length.convert(6.0, Length.LengthUnit.FEET, Length.LengthUnit.YARDS);
        Assert.assertEquals(2.0, result, DIFFERENCE);
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double original = 5.0;
        double converted = Length.convert(
                Length.convert(original, Length.LengthUnit.YARDS, Length.LengthUnit.FEET),
                Length.LengthUnit.FEET, Length.LengthUnit.YARDS
        );
        Assert.assertEquals(original, converted, DIFFERENCE);
    }

    @Test
    public void testConversion_ZeroValue() {
        double result = Length.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        Assert.assertEquals(0.0, result, DIFFERENCE);
    }


    @Test
    public void testConversion_NegativeValue() {
        double result = Length.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        Assert.assertEquals(-12.0, result, DIFFERENCE);
    }


    @Test
    public void testConversion_InvalidUnit_Throws() {
        Assert.assertThrows(IllegalArgumentException.class, () ->
                Length.convert(1.0, null, Length.LengthUnit.FEET)
        );
        Assert.assertThrows(IllegalArgumentException.class, () ->
                Length.convert(1.0, Length.LengthUnit.FEET, null)
        );
    }


    @Test
    public void testConversion_NaNOrInfinite_Throws() {

        Assert.assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.NaN, Length.LengthUnit.FEET, Length.LengthUnit.INCHES)

        );


        Assert.assertThrows(IllegalArgumentException.class, () ->
                Length.convert(Double.POSITIVE_INFINITY, Length.LengthUnit.FEET, Length.LengthUnit.INCHES)
        );

    }


    @Test
    public void testConversion_PrecisionTolerance() {
        double result = Length.convert(1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.FEET);
        double expected = 1.0 / 30.48;
        Assert.assertEquals(expected, result, DIFFERENCE);

    }

}