package com.apps.quantitymeasurement;


import com.apps.quantityMeasurement.Length;
import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-5;

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = Length.add(length1, length2, Length.LengthUnit.FEET);
        Assert.assertEquals(2.0, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = Length.add(length1, length2, Length.LengthUnit.INCHES);
        Assert.assertEquals(24.0, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_YARDS() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = Length.add(length1, length2, Length.LengthUnit.YARDS);
        Assert.assertEquals(0.6666667, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);

        Length result = Length.add(length1, length2, Length.LengthUnit.CENTIMETERS);

        Assert.assertEquals(5.08, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.CENTIMETERS, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        Length length1 = new Length(2.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);

        Length result = Length.add(length1, length2, Length.LengthUnit.YARDS);

        Assert.assertEquals(3.0, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        Length length1 = new Length(2.0, Length.LengthUnit.YARDS);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);

        Length result = Length.add(length1, length2, Length.LengthUnit.FEET);

        Assert.assertEquals(9.0, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {
        Length r1 = Length.add(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS);

        Length r2 = Length.add(
                new Length(12.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.FEET),
                Length.LengthUnit.YARDS);

        Assert.assertEquals(r1.getValue(), r2.getValue(), EPSILON);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {
        Length result = Length.add(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(0.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS);

        Assert.assertEquals(1.6666667, result.getValue(), EPSILON);
    }


    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {
        Length result = Length.add(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(-2.0, Length.LengthUnit.FEET),
                Length.LengthUnit.INCHES);

        Assert.assertEquals(36.0, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        Assert.assertThrows(IllegalArgumentException.class, () ->
                Length.add(
                        new Length(1.0, Length.LengthUnit.FEET),
                        new Length(12.0, Length.LengthUnit.INCHES),
                        null)
        );
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        Length result = Length.add(
                new Length(1000.0, Length.LengthUnit.FEET),
                new Length(500.0, Length.LengthUnit.FEET),
                Length.LengthUnit.INCHES);

        Assert.assertEquals(18000.0, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
        Length result = Length.add(
                new Length(12.0, Length.LengthUnit.INCHES),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS);

        Assert.assertEquals(0.6666667, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_AllUnitCombinations() {
        Length result = Length.add(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(24.0, Length.LengthUnit.INCHES), // 2 feet
                Length.LengthUnit.FEET);

        Assert.assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_PrecisionTolerance() {
        Length result = Length.add(
                new Length(2.54, Length.LengthUnit.CENTIMETERS),
                new Length(2.54, Length.LengthUnit.CENTIMETERS),
                Length.LengthUnit.INCHES);

        Assert.assertEquals(2.0, result.getValue(), EPSILON);
    }
}
