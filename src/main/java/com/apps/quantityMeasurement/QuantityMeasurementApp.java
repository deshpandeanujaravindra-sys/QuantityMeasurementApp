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

        System.out.println(compareInchesAndFeet(1.0, 24.0)+"nowwwww");
    }

    static boolean compareInchesAndFeet(double feetValue, double inchValue) {
        Feet feet = new Feet(feetValue);
        Inches inches = new Inches(inchValue);
        return Double.compare(feet.toInches(), inches.toInches()) == 0;

    }

}

