package com.apps.quantitymeasurement;

import com.apps.quantityMeasurement.Length;
import com.apps.quantityMeasurement.QuantityMeasurementApp;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class QuantityMeasurementTest {
    @Test
    public void testFeetEquality_sameValue() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(7.0);
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(7.0);
        Assert.assertEquals(feet, feet1);
    }

    @Test
    public void testFeetEquality_differentValue() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(7.0);
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(8.0);
        Assert.assertNotEquals(feet, feet1);
    }

    @Test
    public void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(7.0);
        Assert.assertNotEquals(null, feet);
    }


    @Test
    public void testFeetEquality_nonNumericValue() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(Double.NaN);
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(6.0);
        Assert.assertNotEquals(feet, feet1);
    }

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        Length l1 = new Length(5, Length.LengthUnit.FEET);
        Length l2 = new Length(5, Length.LengthUnit.FEET);
        Assert.assertEquals(l1, l2);
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        Length l1 = new Length(5, Length.LengthUnit.INCHES);
        Length l2 = new Length(5, Length.LengthUnit.INCHES);
        Assert.assertEquals(l1, l2);
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        Length feet = new Length(1, Length.LengthUnit.FEET);
        Length inch = new Length(12, Length.LengthUnit.INCHES);
        Assert.assertEquals(feet, inch);
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        Length inch = new Length(24, Length.LengthUnit.INCHES);
        Length feet = new Length(2, Length.LengthUnit.FEET.FEET);
        Assert.assertEquals(inch, feet);
    }

    @Test
    public void testInequality_DifferentValues() {
        Length feet = new Length(1, Length.LengthUnit.FEET);
        Length inch = new Length(10, Length.LengthUnit.INCHES);
        Assert.assertNotEquals(feet, inch);
    }

    @Test
    public void testUnsupportedComparison_ReturnsFalse() {
        Length length = new Length(1, Length.LengthUnit.FEET);
        String otherObject = "1 FEET";
        Assert.assertNotEquals(otherObject, length);
    }

    @Test
    public void testEqualsIsSymmetric() {
        Length feet = new Length(3, Length.LengthUnit.FEET);
        Length inch = new Length(36, Length.LengthUnit.INCHES);
        Assert.assertTrue(feet.equals(inch));
        Assert.assertTrue(inch.equals(feet));
    }
}
