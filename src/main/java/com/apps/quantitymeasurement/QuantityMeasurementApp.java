package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.controller.QuantityMeasurementController;
import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.service.IQuantityMeasurementService;
import com.apps.quantitymeasurement.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

//        System.out.println("========= SUBTRACTION (Implicit Target Unit) =========");
//
//        Quantity<LengthUnit> feet10 = new Quantity<>(10.0, LengthUnit.FEET);
//        Quantity<LengthUnit> inches6 = new Quantity<>(6.0, LengthUnit.INCHES);
//
//        System.out.println("Input: 10 FEET - 6 INCH");
//        System.out.println("Output: " + feet10.subtract(inches6));
//
//        Quantity<VolumeUnit> litre5 = new Quantity<>(5.0, VolumeUnit.LITRE);
//        Quantity<VolumeUnit> ml500 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);
//
//        System.out.println("Input: 5 LITRE - 500 MILLILITRE");
//        System.out.println("Output: " + litre5.subtract(ml500));
//
//
//        System.out.println("\n========= SUBTRACTION (Explicit Target Unit) =========");
//
//        System.out.println("Input: 10 FEET - 6 INCH (INCH)");
//        System.out.println("Output: " +
//                feet10.subtract(inches6, LengthUnit.INCHES));
//
//        Quantity<WeightUnit> kg10 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
//        Quantity<WeightUnit> g5000 = new Quantity<>(5000.0, WeightUnit.GRAM);
//
//        System.out.println("Input: 10 KG - 5000 GRAM (GRAM)");
//        System.out.println("Output: " +
//                kg10.subtract(g5000, WeightUnit.GRAM));
//
//
//        System.out.println("\n========= SUBTRACTION (Negative Result) =========");
//
//        Quantity<LengthUnit> feet5 = new Quantity<>(5.0, LengthUnit.FEET);
//        Quantity<LengthUnit> feet10b = new Quantity<>(10.0, LengthUnit.FEET);
//
//        System.out.println("Input: 5 FEET - 10 FEET");
//        System.out.println("Output: " + feet5.subtract(feet10b));
//
//
//        System.out.println("\n========= SUBTRACTION (Zero Result) =========");
//
//        Quantity<LengthUnit> feet10c = new Quantity<>(10.0, LengthUnit.FEET);
//        Quantity<LengthUnit> inches120 = new Quantity<>(120.0, LengthUnit.INCHES);
//
//        System.out.println("Input: 10 FEET - 120 INCH");
//        System.out.println("Output: " + feet10c.subtract(inches120));
//
//
//        System.out.println("\n========= DIVISION =========");
//
//        Quantity<LengthUnit> tenFeet = new Quantity<>(10.0, LengthUnit.FEET);
//        Quantity<LengthUnit> twoFeet = new Quantity<>(2.0, LengthUnit.FEET);
//
//        System.out.println("Input: 10 FEET / 2 FEET");
//        System.out.println("Output: " + tenFeet.divide(twoFeet));
//
//        System.out.println("Input: 5 FEET / 10 FEET");
//        System.out.println("Output: " +
//                new Quantity<>(5.0, LengthUnit.FEET)
//                        .divide(new Quantity<>(10.0, LengthUnit.FEET)));
//
//        System.out.println("Input: 24 INCH / 2 FEET");
//        System.out.println("Output: " +
//                new Quantity<>(24.0, LengthUnit.INCHES)
//                        .divide(new Quantity<>(2.0, LengthUnit.FEET)));
//
//
//        System.out.println("\n========= CROSS CATEGORY ERROR =========");
//
//        try {
//            Quantity<WeightUnit> kg5 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
//            tenFeet.subtract((Quantity) kg5);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//
//        System.out.println("\n========= DIVIDE BY ZERO =========");
//
//        try {
//            tenFeet.divide(new Quantity<>(0.0, LengthUnit.FEET));
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//
//        System.out.println("\n========= UC14 ARITHMETIC SUPPORT CHECK =========");
//
//        try {
//            Quantity<TemperatureuUnit> temp1 =
//                    new Quantity<>(30.0, TemperatureuUnit.CELSIUS);
//
//            Quantity<TemperatureuUnit> temp2 =
//                    new Quantity<>(20.0, TemperatureuUnit.CELSIUS);
//
//            System.out.println(temp1.subtract(temp2));
//        } catch (Exception e) {
//            System.out.println("Arithmetic Not Supported: " + e.getMessage());
//        }
//
//        System.out.println("\n========= APPLICATION COMPLETED =========");
//
//
//        Quantity<TemperatureuUnit> length1 = new Quantity<>(0.0, TemperatureuUnit.CELSIUS);
//        Quantity<TemperatureuUnit> length2 = new Quantity<>(32.0, TemperatureuUnit.FAHRENHEIT);
//
//        System.out.println("0 Celsius== 32 Fahrenheit: " + length1.equals(length2));
//
//        Quantity<TemperatureuUnit> length3 = new Quantity<>(0.0, TemperatureuUnit.CELSIUS);
//        Quantity<TemperatureuUnit> length4 = new Quantity<>(273.15, TemperatureuUnit.KELVIN);
//
//        System.out.println(" " + length3.equals(length4));

        IQuantityMeasurementService service = new QuantityMeasurementServiceImpl();
        QuantityMeasurementController controller = new QuantityMeasurementController(service);

        QuantityMeasurementEntity length1 =
                new QuantityMeasurementEntity(1, LengthUnit.FEET);

        QuantityMeasurementEntity length2 =
                new QuantityMeasurementEntity(12, LengthUnit.INCHES);

        boolean result = controller.compare(length1, length2);

        System.out.println("1 Feet == 12 Inch ? " + result);

        QuantityMeasurementEntity sum =
                controller.add(length1, length2);

        System.out.println("Addition Result : " + sum.getValue());
    }
    }