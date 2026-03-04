package com.apps.quantitymeasurement;

public class QuantityMeasurementApp{

    public static void main(String[] args) {


        Quantity<LengthUnit> feet10 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> inch24 =
                new Quantity<>(24.0, LengthUnit.INCHES);

        Quantity<LengthUnit> feet2 =
                new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> feet5 =
                new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> feet10b =
                new Quantity<>(10.0, LengthUnit.FEET);

        // ADD
        System.out.println("10 ft + 24 in = " +
                feet10.add(inch24));

        System.out.println("10 ft + 24 in (in YARD) = " +
                feet10.add(inch24, LengthUnit.YARDS));

        // SUBTRACT
        System.out.println("10 ft - 24 in = " +
                feet10.subtract(inch24));

        // DIVISION CASES
        System.out.println("10 ft / 2 ft = " +
                feet10.divide(feet2) + "  (Ratio > 1)");

        System.out.println("5 ft / 10 ft = " +
                feet5.divide(feet10) + "  (Ratio < 1)");

        System.out.println("10 ft / 10 ft = " +
                feet10.divide(feet10b) + "  (Ratio = 1)");

        // EQUALITY
        Quantity<LengthUnit> oneFoot =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> twelveInch =
                new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("1 ft equals 12 in ? " +
                oneFoot.equals(twelveInch));


        /*
           VOLUME OPERATIONS
            */
        System.out.println("\n---- VOLUME OPERATIONS ----");

        Quantity<VolumeUnit> litre1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml1000 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> gallon1 =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        System.out.println("1 L equals 1000 mL ? " +
                litre1.equals(ml1000));

        System.out.println("1 gallon in litre = " +
                gallon1.add(new Quantity<>(0, VolumeUnit.LITRE)));



        System.out.println("\n---- WEIGHT OPERATIONS ----");

        Quantity<WeightUnit> kg1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gm1000 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("1 kg equals 1000 gm ? " +
                kg1.equals(gm1000));


        System.out.println("\n---- EXCEPTION HANDLING ----");

        try {
            feet10.divide(new Quantity<>(0.0, LengthUnit.FEET));
        } catch (Exception e) {
            System.out.println("Division by zero handled: " + e.getMessage());
        }

        try {
            feet10.add((Quantity) litre1);
        } catch (Exception e) {
            System.out.println("Cross-category handled: " + e.getMessage());
        }
    }
}

