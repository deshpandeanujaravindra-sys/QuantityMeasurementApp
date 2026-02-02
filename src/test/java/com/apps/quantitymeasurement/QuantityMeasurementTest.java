package com.apps.quantitymeasurement;

import com.apps.quantityMeasurement.Length;
import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementTest {

    @Test
    public void testEquality_YardToYard_SameValue() {
        Assert.assertEquals(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(1.0, Length.LengthUnit.YARDS)
        );
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        Assert.assertNotEquals(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(2.0, Length.LengthUnit.YARDS)
        );
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        Assert.assertEquals(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET)
        );
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        Assert.assertEquals(
                new Length(3.0, Length.LengthUnit.FEET),
                new Length(1.0, Length.LengthUnit.YARDS)
        );
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        Assert.assertEquals(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(36.0, Length.LengthUnit.INCHES)
        );
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        Assert.assertEquals(
                new Length(36.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.YARDS)
        );
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        Assert.assertNotEquals(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(2.0, Length.LengthUnit.FEET)
        );
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {
        Assert.assertEquals(
                new Length(0.393701, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.CENTIMETERS)
        );
    }

    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue() {
        Assert.assertNotEquals(
                new Length(1.0, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.FEET)
        );
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length A = new Length(1.0, Length.LengthUnit.YARDS);
        Length B = new Length(3.0, Length.LengthUnit.FEET);
        Length C = new Length(36.0, Length.LengthUnit.INCHES);

        Assert.assertEquals(A, B);
        Assert.assertEquals(B, C);
        Assert.assertEquals(A, C);
    }

    @Test
    public void testEquality_YardWithNullUnit() {
        Assert.assertThrows(IllegalArgumentException.class, () ->
                new Length(1.0, null)
        );
    }

    @Test
    public void testEquality_YardSameReference() {
        Length length = new Length(1.0, Length.LengthUnit.YARDS);
        Assert.assertEquals(length, length);
    }

    @Test
    public void testEquality_YardNullComparison() {
        Length length = new Length(1.0, Length.LengthUnit.YARDS);
        Assert.assertNotEquals(length, null);
    }

    @Test
    public void testEquality_CentimetersWithNullUnit() {
        Assert.assertThrows(IllegalArgumentException.class, () ->
                new Length(5.0, null)
        );
    }

    @Test
    public void testEquality_CentimetersSameReference() {
        Length length = new Length(10.0, Length.LengthUnit.CENTIMETERS);
        Assert.assertEquals(length, length);
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        Length length = new Length(10.0, Length.LengthUnit.CENTIMETERS);
        Assert.assertNotEquals(length, null);
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        Length yard = new Length(2.0, Length.LengthUnit.YARDS); // 6 feet
        Length feet = new Length(6.0, Length.LengthUnit.FEET);
        Length inches = new Length(72.0, Length.LengthUnit.INCHES);

        Assert.assertEquals(yard, feet);
        Assert.assertEquals(feet, inches);
        Assert.assertEquals(yard, inches);
    }
}

