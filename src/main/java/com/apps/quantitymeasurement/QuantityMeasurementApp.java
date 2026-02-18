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

    }


}
