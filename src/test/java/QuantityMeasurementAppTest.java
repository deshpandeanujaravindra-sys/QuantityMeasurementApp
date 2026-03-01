import com.apps.quantitymeasurement.LengthUnit;
import com.apps.quantitymeasurement.Quantity;
import com.apps.quantitymeasurement.QuantityWeight;
import com.apps.quantitymeasurement.WeightUnit;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.0001;

    @Test
    public void testEquality_KilogramToKilogram_SameValue() {
        assertEquals(new QuantityWeight(1, WeightUnit.KILOGRAM),
                new QuantityWeight(1, WeightUnit.KILOGRAM));
    }

    @Test
    public void testEquality_KilogramToKilogram_DifferentValue() {
        assertNotEquals(new QuantityWeight(1, WeightUnit.KILOGRAM),
                new QuantityWeight(2, WeightUnit.KILOGRAM));
    }

    @Test
    public void testEquality_KilogramToGram_EquivalentValue() {
        assertEquals(new QuantityWeight(1, WeightUnit.KILOGRAM),
                new QuantityWeight(1000, WeightUnit.GRAM));
    }

    @Test
    public void testEquality_GramToKilogram_EquivalentValue() {
        assertEquals(new QuantityWeight(1000, WeightUnit.GRAM),
                new QuantityWeight(1, WeightUnit.KILOGRAM));
    }

    @Test
    public void testEquality_KilogramToPound_EquivalentValue() {
        assertEquals(new QuantityWeight(1, WeightUnit.KILOGRAM),
                new QuantityWeight(2.20462, WeightUnit.POUND));
    }

    @Test
    public void testEquality_NullComparison() {
        assertNotEquals(new QuantityWeight(1, WeightUnit.KILOGRAM), null);
    }

    @Test
    public void testEquality_SameReference() {
        QuantityWeight q = new QuantityWeight(5, WeightUnit.KILOGRAM);
        assertEquals(q, q);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEquality_NullUnit() {
        new QuantityWeight(1, null);
    }

    @Test
    public void testEquality_ZeroValue() {
        assertEquals(new QuantityWeight(0, WeightUnit.KILOGRAM),
                new QuantityWeight(0, WeightUnit.GRAM));
    }

    @Test
    public void testEquality_NegativeWeight() {
        assertEquals(new QuantityWeight(-1, WeightUnit.KILOGRAM),
                new QuantityWeight(-1000, WeightUnit.GRAM));
    }

    @Test
    public void testConversion_PoundToKilogram() {
        QuantityWeight result =
                QuantityWeight.convert(new QuantityWeight(1,WeightUnit.POUND),WeightUnit.KILOGRAM);
        assertEquals(0.45359, result.getValue(), EPSILON);
    }

    @Test
    public void testConversion_KilogramToPound() {
        QuantityWeight result =
                QuantityWeight.convert(new QuantityWeight(1,WeightUnit.KILOGRAM),WeightUnit.POUND);
        assertEquals(2.20462, result.getValue(), EPSILON);
    }

    @Test
    public void testConversion_SameUnit() {
        QuantityWeight result =
                QuantityWeight.convert(new QuantityWeight(5,WeightUnit.KILOGRAM),WeightUnit.KILOGRAM);
        assertEquals(5, result.getValue(), EPSILON);
    }

    @Test
    public void testConversion_ZeroValue() {
        QuantityWeight result =
                QuantityWeight.convert(new QuantityWeight(0,WeightUnit.KILOGRAM),WeightUnit.GRAM);
        assertEquals(0, result.getValue(), EPSILON);
    }

    @Test
    public void testConversion_RoundTrip() {
        QuantityWeight original =
                new QuantityWeight(1.5, WeightUnit.KILOGRAM);

        QuantityWeight convertedFirst =
                original.convert(original,WeightUnit.GRAM);
        QuantityWeight converted=convertedFirst.convert(original,WeightUnit.KILOGRAM);
        assertEquals(original.getValue(), converted.getValue(), EPSILON);
    }


    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram() {
        QuantityWeight result =
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(2, WeightUnit.KILOGRAM),
                                WeightUnit.KILOGRAM);

        assertEquals(3, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() {
        QuantityWeight result =
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000, WeightUnit.GRAM),
                                WeightUnit.KILOGRAM);

        assertEquals(2, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram() {
        QuantityWeight result =
                new QuantityWeight(2.20462, WeightUnit.POUND)
                        .add(new QuantityWeight(1, WeightUnit.KILOGRAM),
                                WeightUnit.POUND);

        assertEquals(4.40924, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram() {
        QuantityWeight result =
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000, WeightUnit.GRAM),
                                WeightUnit.GRAM);

        assertEquals(2000, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_Commutativity() {
        QuantityWeight q1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000, WeightUnit.GRAM);

        QuantityWeight r1 = q1.add(q2, WeightUnit.KILOGRAM);
        QuantityWeight r2 = q2.add(q1, WeightUnit.KILOGRAM);

        assertEquals(r1.getValue(), r2.getValue(), EPSILON);
    }

    @Test
    public void testAddition_WithZero() {
        QuantityWeight result =
                new QuantityWeight(5, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(0, WeightUnit.GRAM),
                                WeightUnit.KILOGRAM);

        assertEquals(5, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_NegativeValues() {
        QuantityWeight result =
                new QuantityWeight(5, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(-2000, WeightUnit.GRAM),
                                WeightUnit.KILOGRAM);

        assertEquals(3, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_LargeValues() {
        QuantityWeight result =
                new QuantityWeight(1_000_000, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1_000_000, WeightUnit.KILOGRAM),
                                WeightUnit.KILOGRAM);

        assertEquals(2_000_000, result.getValue(), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_NullQuantity() {
        QuantityWeight q = new QuantityWeight(1, WeightUnit.KILOGRAM);
        q.add(null, WeightUnit.KILOGRAM);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_NullTargetUnit() {
        QuantityWeight q = new QuantityWeight(1, WeightUnit.KILOGRAM);
        q.add(new QuantityWeight(1, WeightUnit.KILOGRAM), (QuantityWeight) null);
    }

    @Test
    public void testGenericLengthTypeSafety() {
        Quantity<LengthUnit> length = new Quantity<>(5, LengthUnit.FEET);
        assertTrue(length.getUnit() instanceof LengthUnit);
    }

    @Test
    public void testGenericWeightTypeSafety() {
        Quantity<WeightUnit> weight = new Quantity<>(5, WeightUnit.KILOGRAM);
        assertTrue(weight.getUnit() instanceof WeightUnit);
    }

    @Test
    public void testDifferentCategoryEqualityShouldFail() {
        Quantity<LengthUnit> length = new Quantity<>(5, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(5, WeightUnit.KILOGRAM);
        assertFalse(length.equals(weight));
    }

    @Test
    public void testAdditionMaintainsGenericTypeLength() {
        Quantity<LengthUnit> result =
                new Quantity<>(2, LengthUnit.FEET)
                        .add(new Quantity<>(3, LengthUnit.FEET),LengthUnit.FEET);

        assertTrue(result.getUnit() instanceof LengthUnit);
    }

    @Test
    public void testAdditionMaintainsGenericTypeWeight() {
        Quantity<WeightUnit> result =
                new Quantity<>(1, WeightUnit.KILOGRAM)
                        .add(new Quantity<>(1, WeightUnit.KILOGRAM),WeightUnit.KILOGRAM);

        assertTrue(result.getUnit() instanceof WeightUnit);
    }

    @Test
    public void testInterfaceBaseConversionLength() {
        Quantity<LengthUnit> length = new Quantity<>(1, LengthUnit.YARDS);
        assertEquals(36, length.toBaseUnit(), EPSILON);
    }

    @Test
    public void testInterfaceBaseConversionWeight() {
        Quantity<WeightUnit> weight = new Quantity<>(1, WeightUnit.KILOGRAM);
         assertEquals(1, weight.toBaseUnit(), EPSILON);
    }

    @Test
    public void testGenericHashCodeConsistencyLength() {
        Quantity<LengthUnit> q1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12, LengthUnit.INCHES);
        assertEquals(q1.hashCode(), q2.hashCode());
    }

    @Test
    public void testGenericHashCodeConsistencyWeight() {
        Quantity<WeightUnit> q1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(2.20462, WeightUnit.POUND);
        assertEquals(q1.hashCode(), q2.hashCode());
    }
}
