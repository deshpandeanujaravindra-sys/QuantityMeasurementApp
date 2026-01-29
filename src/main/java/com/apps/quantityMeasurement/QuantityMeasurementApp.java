package com.apps.quantityMeasurement;

public class QuantityMeasurementApp {

    public static class Feet{

        private final double value;

        public Feet(double value){
           this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
           if (this == obj) return true;
           if (obj==null ||  getClass()!= this.getClass()) return false;
           Feet feet = (Feet) obj;
            System.out.println(feet.value +"kk"+value);

            return Double.compare(feet.value, value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    public static void main(String[] args) {

        Feet feet = new Feet(7.0);
        Feet feet1 = new Feet(7.0);
        Feet feet2 = new Feet(8.0);

        System.out.println(feet.equals(feet1));
        System.out.println(feet1.equals(feet2));

    }
}
