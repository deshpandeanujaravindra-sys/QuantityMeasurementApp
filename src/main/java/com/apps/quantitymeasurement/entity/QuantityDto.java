package com.apps.quantitymeasurement.entity;

public class QuantityDto {
        private double value;
        private String unitName;
        private String measurementType;

        public QuantityDto(double value, String unitName, String measurementType) {
            this.value = value;
            this.unitName = unitName;
            this.measurementType = measurementType;
        }

        public double getValue() {
            return value;
        }

        public String getUnitName() {
            return unitName;
        }

        public String getMeasurementType() {
            return measurementType;
        }
    }

