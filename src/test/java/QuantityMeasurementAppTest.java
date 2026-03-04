import com.apps.quantitymeasurement.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

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

    @Test
    public void testEquality_LitreToMillilitre_EquivalentValue() {
        assertEquals(
                new Quantity<>(1, VolumeUnit.LITRE),
                new Quantity<>(1000, VolumeUnit.MILLILITRE)
        );
    }

    @Test
    public void testEquality_LitreToGallon_EquivalentValue() {
        assertEquals(
                new Quantity<>(3.78541, VolumeUnit.LITRE),
                new Quantity<>(1, VolumeUnit.GALLON)
        );
    }

    @Test
    public void testEquality_MillilitreToGallon_EquivalentValue() {
        assertEquals(
                new Quantity<>(3785.41, VolumeUnit.MILLILITRE),
                new Quantity<>(1, VolumeUnit.GALLON)
        );
    }

    @Test
    public void testEquality_ZeroVolume() {
        assertEquals(
                new Quantity<>(0, VolumeUnit.LITRE),
                new Quantity<>(0, VolumeUnit.GALLON)
        );
    }

    @Test
    public void testEquality_NegativeVolume() {
        assertEquals(
                new Quantity<>(-1, VolumeUnit.LITRE),
                new Quantity<>(-1000, VolumeUnit.MILLILITRE)
        );
    }


    @Test
    public void testAddition_SameUnit_LitrePlusLitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(2, VolumeUnit.LITRE)
                        .add(new Quantity<>(3, VolumeUnit.LITRE), VolumeUnit.LITRE);

        assertEquals(5, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_CrossUnit_LitrePlusMillilitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1, VolumeUnit.LITRE)
                        .add(new Quantity<>(500, VolumeUnit.MILLILITRE), VolumeUnit.LITRE);

        assertEquals(1.5, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_CrossUnit_GallonPlusLitre() {
        Quantity<VolumeUnit> result =
                new Quantity<>(1, VolumeUnit.GALLON)
                        .add(new Quantity<>(1, VolumeUnit.LITRE), VolumeUnit.GALLON);

        assertEquals(1.26417, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_Commutativity_Volume() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(1000, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> r1 = q1.add(q2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> r2 = q2.add(q1, VolumeUnit.LITRE);

        assertEquals(r1.getValue(), r2.getValue(), EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_NullQuantity_Volume() {
        new Quantity<>(1, VolumeUnit.LITRE)
                .add(null, VolumeUnit.LITRE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddition_NullTargetUnit_Volume() {
        new Quantity<>(1, VolumeUnit.LITRE)
                .add(new Quantity<>(1, VolumeUnit.LITRE), null);
    }

    @Test
    public void testGenericHashCodeConsistency_Volume() {
        Quantity<VolumeUnit> q1 = new Quantity<>(1, VolumeUnit.GALLON);
        Quantity<VolumeUnit> q2 = new Quantity<>(3.78541, VolumeUnit.LITRE);

        assertEquals(q1.hashCode(), q2.hashCode());
    }

    @Test
    public void testDifferentCategoryEquality_VolumeAndWeight() {
        Quantity<VolumeUnit> volume =
                new Quantity<>(1, VolumeUnit.LITRE);

        Quantity<WeightUnit> weight =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        assertFalse(volume.equals(weight));
    }

    // 24. Ratio > 1.0
    @Test
  public   void testDivision_RatioGreaterThanOne() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(5.0, result, 0.01);
    }

    // 25. Ratio < 1.0
    @Test
    public void testDivision_RatioLessThanOne() {
        Quantity<LengthUnit> q1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(0.5, result, 0.01);
    }

    // 26. Ratio == 1.0
    @Test
    public void testDivision_RatioEqualToOne() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(10.0, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(1.0, result, 0.01);
    }

    /* -------------------- ADD -------------------- */

    @Test
    public void testAdd_SameUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.add(q2);

        assertEquals(15.0, result.getValue(), 0.0001);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAdd_DifferentUnits() {
        Quantity<LengthUnit> feet = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.add(inches);

        assertEquals(2.0, result.getValue(), 0.0001);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    /* -------------------- SUBTRACT -------------------- */

    @Test
    public void testSubtract() {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2, LengthUnit.FEET);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(8.0, result.getValue(), 0.0001);
    }

    @Test
    public void testSubtract_DifferentUnits() {
        Quantity<LengthUnit> q1 = new Quantity<>(2, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result = q1.subtract(q2);

        assertEquals(1.0, result.getValue(), 0.0001);
    }

    /* -------------------- DIVIDE -------------------- */

    @Test
    public void testDivide() {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2, LengthUnit.FEET);

        double result = q1.divide(q2);

        assertEquals(5.0, result, 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0, LengthUnit.FEET);

        q1.divide(q2);
    }

    /* -------------------- CROSS CATEGORY -------------------- */

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_CrossCategory_ShouldFail() {
        Quantity<LengthUnit> length = new Quantity<>(10, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(5, WeightUnit.KILOGRAM);

        length.add((Quantity) weight); // force raw type for test
    }

    /* -------------------- IMMUTABILITY -------------------- */

    @Test
    public void testImmutability_AfterAdd() {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5, LengthUnit.FEET);

        q1.add(q2);

        assertEquals(10.0, q1.getValue(), 0.0001);
        assertEquals(5.0, q2.getValue(), 0.0001);
    }

    /* -------------------- ENUM DIRECT TEST -------------------- */

    @Test
    public void testArithmeticOperation_ADD() {
        double result = Quantity.ArithmeticOperation.ADD.compute(7, 3);
        assertEquals(10.0, result, 0.0001);
    }

    @Test
    public void testArithmeticOperation_SUBTRACT() {
        double result = Quantity.ArithmeticOperation.SUBTRACT.compute(7, 3);
        assertEquals(4.0, result, 0.0001);
    }

    @Test
    public void testArithmeticOperation_DIVIDE() {
        double result = Quantity.ArithmeticOperation.DIVIDE.compute(6, 2);
        assertEquals(3.0, result, 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testArithmeticOperation_DIVIDE_ByZero() {
        Quantity.ArithmeticOperation.DIVIDE.compute(6, 0);
    }

    /* -------------------- NULL VALIDATION -------------------- */

    @Test(expected = IllegalArgumentException.class)
    public void testAdd_NullOperand() {
        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        q1.add(null);
    }

}
