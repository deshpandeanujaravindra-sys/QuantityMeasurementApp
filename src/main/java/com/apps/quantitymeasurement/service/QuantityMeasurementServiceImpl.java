package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService{

    @Override
    public boolean compare(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2) {

        double base1 = q1.getUnit().convertToBaseUnit(q1.getValue());
        double base2 = q2.getUnit().convertToBaseUnit(q2.getValue());

        return Double.compare(base1, base2) == 0;
    }

    @Override
    public double convert(QuantityMeasurementEntity quantity) {

        return quantity.getUnit().convertToBaseUnit(quantity.getValue());
    }

    @Override
    public QuantityMeasurementEntity add(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2) {

        double base1 = q1.getUnit().convertToBaseUnit(q1.getValue());
        double base2 = q2.getUnit().convertToBaseUnit(q2.getValue());

        double result = base1 + base2;

        return new QuantityMeasurementEntity(result, q1.getUnit());
    }

    @Override
    public QuantityMeasurementEntity subtract(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2) {

        double base1 = q1.getUnit().convertToBaseUnit(q1.getValue());
        double base2 = q2.getUnit().convertToBaseUnit(q2.getValue());

        double result = base1 - base2;

        return new QuantityMeasurementEntity(result, q1.getUnit());
    }

}
