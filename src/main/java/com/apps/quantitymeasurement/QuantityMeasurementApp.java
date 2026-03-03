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

        Quantity<VolumeUnit> litre = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> gallon = new Quantity<>(1, VolumeUnit.GALLON);

        System.out.println("1 L == 1000 ML : " + litre.equals(ml));
        System.out.println("1 Gallon == 3.78541 L : " +
                gallon.equals(new Quantity<>(3.78541, VolumeUnit.LITRE)));

        Quantity<VolumeUnit> result = litre.add(gallon,litre.getUnit());
        System.out.println("1 L + 1 Gallon = " + result);

        System.out.println("------ Unit Conversion ------");

        System.out.println(
                new Quantity<>(1.0, VolumeUnit.LITRE)
                        .convert(VolumeUnit.MILLILITRE));

        System.out.println(
                new Quantity<>(2.0, VolumeUnit.GALLON)
                        .convert(VolumeUnit.LITRE));

        System.out.println(
                new Quantity<>(500.0, VolumeUnit.MILLILITRE)
                        .convert(VolumeUnit.GALLON));

        System.out.println(
                new Quantity<>(0.0, VolumeUnit.LITRE)
                        .convert(VolumeUnit.MILLILITRE));

        System.out.println(
                new Quantity<>(1.0, VolumeUnit.LITRE)
                        .convert(VolumeUnit.LITRE));


        System.out.println("\nAddition (Implicit Target Unit)");

        System.out.println(
                new Quantity<>(1.0, VolumeUnit.LITRE)
                        .add(new Quantity<>(2.0, VolumeUnit.LITRE)));


        System.out.println(
                new Quantity<>(1.0, VolumeUnit.LITRE)
                        .add(new Quantity<>(1000.0, VolumeUnit.MILLILITRE)));

        System.out.println(
                new Quantity<>(500.0, VolumeUnit.MILLILITRE)
                        .add(new Quantity<>(0.5, VolumeUnit.LITRE)));

        System.out.println(
                new Quantity<>(2.0, VolumeUnit.GALLON)
                        .add(new Quantity<>(3.78541, VolumeUnit.LITRE)));


        System.out.println("\n Addition (Explicit Target Unit)");

        System.out.println(
                new Quantity<>(1.0, VolumeUnit.LITRE)
                        .add(new Quantity<>(1000.0, VolumeUnit.MILLILITRE),
                                VolumeUnit.MILLILITRE));

        System.out.println(
                new Quantity<>(1.0, VolumeUnit.GALLON)
                        .add(new Quantity<>(3.78541, VolumeUnit.LITRE),
                                VolumeUnit.GALLON));

        System.out.println(
                new Quantity<>(500.0, VolumeUnit.MILLILITRE)
                        .add(new Quantity<>(1.0, VolumeUnit.LITRE),
                                VolumeUnit.GALLON));

        System.out.println(
                new Quantity<>(2.0, VolumeUnit.LITRE)
                        .add(new Quantity<>(4.0, VolumeUnit.GALLON),
                                VolumeUnit.LITRE));


        System.out.println("\nCategory Incompatibility ");

        System.out.println(
                new Quantity<>(1.0, VolumeUnit.LITRE)
                        .equals(new Quantity<>(1.0, LengthUnit.FEET)));

        System.out.println(
                new Quantity<>(1.0, VolumeUnit.LITRE)
                        .equals(new Quantity<>(1.0, WeightUnit.KILOGRAM)));

      //  -----------------------------------------------------------------------------
        System.out.println(
                new Quantity<>(10.0, LengthUnit.FEET)
                        .subtract(new Quantity<>(6.0, LengthUnit.INCHES)));

        System.out.println(
                new Quantity<>(10.0, WeightUnit.KILOGRAM)
                        .subtract(new Quantity<>(5000.0, WeightUnit.GRAM)));

        System.out.println(
                new Quantity<>(5.0, VolumeUnit.LITRE)
                        .subtract(new Quantity<>(500.0, VolumeUnit.MILLILITRE)));

        System.out.println(
                new Quantity<>(10.0, LengthUnit.FEET)
                        .subtract(new Quantity<>(6.0, LengthUnit.INCHES),
                                LengthUnit.INCHES));

        System.out.println(
                new Quantity<>(5.0, VolumeUnit.LITRE)
                        .subtract(new Quantity<>(2.0, VolumeUnit.LITRE),
                                VolumeUnit.MILLILITRE));


        System.out.println(
                new Quantity<>(10.0, WeightUnit.KILOGRAM)
                        .subtract(new Quantity<>(5000.0, WeightUnit.GRAM),
                                WeightUnit.GRAM));

        System.out.println(
                new Quantity<>(5.0, LengthUnit.FEET)
                        .subtract(new Quantity<>(10, LengthUnit.FEET)));

        System.out.println(
                new Quantity<>(2.0, WeightUnit.KILOGRAM)
                        .subtract(new Quantity<>(5.0, WeightUnit.KILOGRAM)));


        System.out.println(
                new Quantity<>(2.0, LengthUnit.FEET)
                        .subtract(new Quantity<>(24, LengthUnit.INCHES)));

        System.out.println(
                new Quantity<>(10.0, LengthUnit.FEET)
                        .divide(new Quantity<>(24, LengthUnit.INCHES)));

        System.out.println(
                new Quantity<>(10.0, LengthUnit.FEET)
                        .divide(new Quantity<>(5, LengthUnit.FEET)));

        System.out.println(
                new Quantity<>(24.0, LengthUnit.INCHES)
                        .divide(new Quantity<>(2, LengthUnit.FEET)));

        System.out.println(
                new Quantity<>(10.0, WeightUnit.KILOGRAM)
                        .divide(new Quantity<>(5, WeightUnit.KILOGRAM)));

        System.out.println(
                new Quantity<>(5.0, VolumeUnit.LITRE)
                        .divide(new Quantity<>(10, VolumeUnit.LITRE)));

        System.out.println(
                new Quantity<>(12.0, LengthUnit.INCHES)
                        .divide(new Quantity<>(1, LengthUnit.FEET)));

        System.out.println(
                new Quantity<>(2000.0, WeightUnit.GRAM)
                        .divide(new Quantity<>(1, WeightUnit.KILOGRAM)));

        System.out.println(
                new Quantity<>(1000, VolumeUnit.MILLILITRE)
                        .divide(new Quantity<>(1, VolumeUnit.LITRE)));

    }


    public static void demonstrateEquality(
            Quantity<?> q1,
            Quantity<?> q2) {

        System.out.println("Equal? " + q1.equals(q2));
    }

}
