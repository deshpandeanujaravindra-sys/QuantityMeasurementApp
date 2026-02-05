package com.apps.quantitymeasurement;

import com.app.quantitymeasurement.Length;
import org.junit.Assert;
import org.junit.Test;


public class QuantityMeasurementTest {

    public static final Double EPSILON = 1e-5;

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        Length q1 = new Length(1.0, Length.LengthUnit.FEET);
        Length q2 = new Length(2.0, Length.LengthUnit.FEET);

        Length result = Length.add(q1, q2, q1.getUnit());

        Assert.assertEquals(3.0, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch() {
        Length q1 = new Length(6.0, Length.LengthUnit.INCHES);
        Length q2 = new Length(6.0, Length.LengthUnit.INCHES);

        Length result = Length.add(q1, q2, q1.getUnit());

        Assert.assertEquals(12.0, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        Length q1 = new Length(1.0, Length.LengthUnit.FEET);
        Length q2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = Length.add(q1, q2, q1.getUnit());

        Assert.assertEquals(2.0, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        Length q1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length q2 = new Length(1.0, Length.LengthUnit.FEET);

        Length result = Length.add(q1, q2, q1.getUnit());

        Assert.assertEquals(24.0, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        Length q1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length q2 = new Length(3.0, Length.LengthUnit.FEET);
        Length result = Length.add(q1, q2, q1.getUnit());
        Assert.assertEquals(2.0, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {
        Length q1 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length q2 = new Length(1.0, Length.LengthUnit.INCHES);
        Length result = Length.add(q1, q2, q1.getUnit());
        Assert.assertEquals(5.08, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.CENTIMETERS, result.getUnit());
    }

    @Test
    public void testAddition_Commutativity() {
        Length q1 = new Length(1.0, Length.LengthUnit.FEET);
        Length q2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length r1 = Length.add(q1, q2, q1.getUnit());
        Length r2 = Length.add(q2, q1, q1.getUnit());

        // Convert r2 to feet for comparison (since unit differs)
        double r2InFeet = Length.convert(
                r2.getValue(), r2.getUnit(), Length.LengthUnit.FEET);
        Assert.assertEquals(r1.getValue(), r2InFeet, EPSILON);
    }

    @Test
    public void testAddition_WithZero() {
        Length q1 = new Length(5.0, Length.LengthUnit.FEET);
        Length q2 = new Length(0.0, Length.LengthUnit.INCHES);

        Length result = Length.add(q1, q2, q1.getUnit());

        Assert.assertEquals(5.0, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_NegativeValues() {
        Length q1 = new Length(5.0, Length.LengthUnit.FEET);
        Length q2 = new Length(-2.0, Length.LengthUnit.FEET);

        Length result = Length.add(q1, q2, q1.getUnit());

        Assert.assertEquals(3.0, result.getValue(), EPSILON);
        Assert.assertEquals(Length.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_NullSecondOperand_Throws() {
        Length q1 = new Length(1.0, Length.LengthUnit.FEET);
        Assert.assertThrows(IllegalArgumentException.class,
                () -> Length.add(q1, null, q1.getUnit()));
    }

    @Test
    public void testAddition_LargeValues() {
        Length q1 = new Length(1e6, Length.LengthUnit.FEET);
        Length q2 = new Length(1e6, Length.LengthUnit.FEET);
        Length result = Length.add(q1, q2, q1.getUnit());
        Assert.assertEquals(2e6, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_SmallValues() {
        Length q1 = new Length(0.001, Length.LengthUnit.FEET);
        Length q2 = new Length(0.002, Length.LengthUnit.FEET);

        Length result = Length.add(q1, q2, q1.getUnit());

        Assert.assertEquals(0.003, result.getValue(), EPSILON);
    }
}

