package com.apps.quantitymeasurement;

import com.apps.quantityMeasurement.QuantityMeasurementApp;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class QuantityMeasurementTest {
    @Test
    public void testFeetEquality_sameValue(){
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(7.0);
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(7.0);
        Assert.assertEquals(feet,feet1);
    }

    @Test
    public void testFeetEquality_differentValue(){
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(7.0);
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(8.0);
        Assert.assertNotEquals(feet,feet1);
    }

    @Test
    public void testFeetEquality_NullComparison(){
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(7.0);
        Assert.assertNotEquals(feet,null);
    }


    @Test
    public void testFeetEquality_nonNumericValue(){
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(Double.NaN);
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(6.0);
        Assert.assertNotEquals(feet,feet1);
    }
}
