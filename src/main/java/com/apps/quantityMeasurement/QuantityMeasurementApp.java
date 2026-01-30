package com.apps.quantityMeasurement;

public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;
        public Feet(double value) {
            this.value = value;
        }
        public double getValue() {
            return value;
        }

        public double toInches() {
            return value * 12;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != this.getClass()) return false;
            Feet feet = (Feet) obj;
            System.out.println(feet.value + "kk" + value);
            return Double.compare(feet.value, value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != this.getClass()) return false;
            Inches inches = (Inches) obj;
            System.out.println(inches.value + "kk" + value);
            return Double.compare(inches.value, value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }

        public double toInches() {
            return value;
        }
    }

    public static void main(String[] args) {

        Feet feet = new Feet(7.0);
        Feet feet1 = new Feet(7.0);
        Feet feet2 = new Feet(8.0);

        System.out.println(feet.equals(feet1));
        System.out.println(feet1.equals(feet2));

        Double.compare(feet.toInches(),feet1.toInches());
        Double.compare(feet.toInches(),feet1.toInches());

        System.out.println(compareInchesAndFeet(2.0, 24.0)+"nowwwww");

        Length lengthInFeet = new Length(2, Length.LengthUnit.FEET);
        Length lengthInInches = new Length(24, Length.LengthUnit.INCHES);

        System.out.println(lengthInFeet.equals(lengthInInches)+"Thissss");
        demonstrateFeetEqulity();
        demonstrateInchesEqulity();
        demonstrateFeetAndInchesEqulity();
    }

    static boolean compareInchesAndFeet(double feetValue, double inchValue) {
        Feet feet = new Feet(feetValue);
        Inches inches = new Inches(inchValue);
        return Double.compare(feet.toInches(), inches.toInches()) == 0;
    }

    public static void demonstrateFeetEqulity(){
        Length firstLengthInFeet = new Length(2, Length.LengthUnit.FEET);
        Length secondLengthInFeet = new Length(2, Length.LengthUnit.FEET);
        System.out.println("Lengths in feet are :(true for equal, false for not equal)"+firstLengthInFeet.equals(secondLengthInFeet));
    }

    public static void demonstrateInchesEqulity(){
        Length firstLengthInFeet = new Length(2, Length.LengthUnit.INCHES);
        Length secondLengthInFeet = new Length(2, Length.LengthUnit.INCHES);
        System.out.println("Lengths in Inches are :(true for equal, false for not equal)"+firstLengthInFeet.equals(secondLengthInFeet));
    }

    public static void demonstrateFeetAndInchesEqulity(){
        Length firstLengthInFeet = new Length(2, Length.LengthUnit.FEET);
        Length secondLengthInFeet = new Length(24, Length.LengthUnit.INCHES);
        System.out.println("Lengths in feet and Inches are :(true for equal, false for not equal)"+firstLengthInFeet.equals(secondLengthInFeet));
    }


}

