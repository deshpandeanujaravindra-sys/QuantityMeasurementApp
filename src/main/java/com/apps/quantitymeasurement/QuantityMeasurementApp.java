package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        Length oneFoot = new Length(1, LengthUnit.FEET);
        Length twelveInches = new Length(12, LengthUnit.INCHES);

        System.out.println("Equality: " + demonstrateLengthEquality(oneFoot, twelveInches));
        System.out.println("Comparison: " + demonstrateLengthComparison(oneFoot.getValue(), oneFoot.getUnit(), twelveInches.getValue(), twelveInches.getUnit()));
        System.out.println("Equality: " + demonstrateLengthConversion(oneFoot.getValue(),oneFoot.getUnit(), twelveInches.getUnit()));
        System.out.println("Connversion: " + demonstrateLengthComparison(oneFoot.getValue(), oneFoot.getUnit(), twelveInches.getValue(), twelveInches.getUnit()));
        System.out.println("Connversion: " + demonstrateLengthConversion(oneFoot, twelveInches.getUnit()));
        System.out.println("Addition: " + demonstrateLengthAddition(oneFoot, twelveInches,LengthUnit.CENTIMETERS));
        demonstrateLengthAddition(new Length(12, LengthUnit.FEET), new Length(12, LengthUnit.INCHES));

    }

    public static Length demonstrateLengthAddition(Length length, Length length1) {
        Length addition = Length.add(length, length1, length.getUnit());
        System.out.println(addition.getValue() + "  " + addition.getUnit());
        return addition;
    }

//    public static Length demonstrateLengthAddition(Length length, Length length1) {
//        Length addition = Length.add(length, length1, length.getUnit());
//        System.out.println(addition.getValue() + "  " + addition.getUnit());
//        return addition;
//    }


    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException();
        }
        return length1.equals(length2);
    }

    public static boolean demonstrateLengthComparison(double value1, LengthUnit unit1,
                                                      double value2, LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);
        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(double value,
                                                     LengthUnit fromUnit,
                                                     LengthUnit toUnit) {

        Length length = new Length(value, fromUnit);
        return length.convert(toUnit);
    }

    public static Length demonstrateLengthConversion(Length length, LengthUnit toUnit) {

        if (length == null) {
            throw new IllegalArgumentException();
        }
        return length.convert(toUnit);
    }


    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {
        return Length.add(length1, length2, targetUnit);
    }
}
