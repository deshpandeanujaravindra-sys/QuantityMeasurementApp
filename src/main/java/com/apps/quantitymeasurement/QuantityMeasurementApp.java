package com.apps.quantitymeasurement;

public class QuantityMeasurementApp{

    public static void main(String[] args) {


        QuantityWeight quantityWeight = new QuantityWeight(2,WeightUnit.KILOGRAM);
        QuantityWeight secondquantityWeight = new QuantityWeight(2000,WeightUnit.GRAM);
        System.out.println(quantityWeight.equals(secondquantityWeight));
        System.out.println(new QuantityWeight(1,WeightUnit.KILOGRAM).equals(new QuantityWeight(1,WeightUnit.KILOGRAM)));
        System.out.println(new QuantityWeight(1,WeightUnit.KILOGRAM).equals(new QuantityWeight(1000,WeightUnit.GRAM)));
        System.out.println(new QuantityWeight(2,WeightUnit.POUND).equals(new QuantityWeight(2,WeightUnit.POUND)));
        System.out.println(new QuantityWeight(1,WeightUnit.KILOGRAM).equals(new QuantityWeight(2.20462,WeightUnit.POUND)));
        System.out.println(new QuantityWeight(500,WeightUnit.GRAM).equals(new QuantityWeight(0.5,WeightUnit.KILOGRAM)));
        System.out.println(new QuantityWeight(1,WeightUnit.POUND).equals(new QuantityWeight(453.592,WeightUnit.GRAM)));


        System.out.println(QuantityWeight.add(new QuantityWeight(1,WeightUnit.KILOGRAM),(new QuantityWeight(1000,WeightUnit.GRAM)),WeightUnit.GRAM).toString());
        System.out.println(QuantityWeight.add(new QuantityWeight(1,WeightUnit.POUND),(new QuantityWeight(453.592,WeightUnit.GRAM)),WeightUnit.POUND).toString());
        System.out.println(QuantityWeight.add(new QuantityWeight(2,WeightUnit.KILOGRAM),(new QuantityWeight(4,WeightUnit.POUND)),WeightUnit.KILOGRAM).toString());

        System.out.println(QuantityWeight.convert(new QuantityWeight(1,WeightUnit.KILOGRAM),WeightUnit.GRAM));
        System.out.println(QuantityWeight.convert(new QuantityWeight(2,WeightUnit.POUND),WeightUnit.KILOGRAM));
        System.out.println(QuantityWeight.convert(new QuantityWeight(500,WeightUnit.GRAM),WeightUnit.POUND));
        System.out.println(QuantityWeight.convert(new QuantityWeight(0,WeightUnit.KILOGRAM),WeightUnit.GRAM));

        System.out.println(QuantityWeight.add(new QuantityWeight(1,WeightUnit.KILOGRAM),(new QuantityWeight(2,WeightUnit.KILOGRAM))).toString());
        System.out.println(QuantityWeight.add(new QuantityWeight(1,WeightUnit.KILOGRAM),(new QuantityWeight(1000,WeightUnit.GRAM))).toString());
        System.out.println(QuantityWeight.add(new QuantityWeight(500,WeightUnit.GRAM),(new QuantityWeight(0.5,WeightUnit.KILOGRAM))).toString());


        System.out.println("Length Equality:");
        System.out.println(
                new Quantity<>(1.0, LengthUnit.FEET)
                        .equals(new Quantity<>(12.0, LengthUnit.INCHES))
        );

        System.out.println("\nLength Conversion:");
        System.out.println(
                new Quantity<>(1.0, LengthUnit.FEET)
                        .convert(LengthUnit.INCHES)
        );

        System.out.println("\nLength Addition:");
        System.out.println(
                new Quantity<>(1.0, LengthUnit.FEET)
                        .add(new Quantity<>(12.0, LengthUnit.INCHES),
                                LengthUnit.FEET)
        );


        System.out.println("\nWeight Equality:");
        System.out.println(
                new Quantity<>(1.0, WeightUnit.KILOGRAM)
                        .equals(new Quantity<>(1000.0, WeightUnit.GRAM))
        );

        System.out.println("\nWeight Conversion:");
        System.out.println(
                new Quantity<>(1.0, WeightUnit.KILOGRAM)
                        .convert(WeightUnit.GRAM)
        );

        System.out.println("\nWeight Addition:");
        System.out.println(
                new Quantity<>(1.0, WeightUnit.KILOGRAM)
                        .add(new Quantity<>(1000.0, WeightUnit.GRAM),
                                WeightUnit.KILOGRAM)
        );


        System.out.println("\nCross Category Equality:");
        System.out.println(
                new Quantity<>(1.0, LengthUnit.FEET)
                        .equals(new Quantity<>(1.0, WeightUnit.KILOGRAM))
        );


        System.out.println("\nGeneric Demonstration:");

        demonstrateEquality(
                new Quantity<>(2.0, LengthUnit.FEET),
                new Quantity<>(24.0, LengthUnit.INCHES)
        );

        demonstrateEquality(
                new Quantity<>(2.0, WeightUnit.KILOGRAM),
                new Quantity<>(2000.0, WeightUnit.GRAM)
        );

        demonstrateEquality(
                new Quantity<>(1.0, LengthUnit.FEET),
                new Quantity<>(1.0, WeightUnit.KILOGRAM)
        );
    }


    public static void demonstrateEquality(
            Quantity<?> q1,
            Quantity<?> q2) {

        System.out.println("Equal? " + q1.equals(q2));
    }
}
