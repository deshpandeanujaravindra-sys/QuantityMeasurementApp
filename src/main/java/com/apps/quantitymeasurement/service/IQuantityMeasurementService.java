package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

    boolean compare(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2);

    double convert(QuantityMeasurementEntity quantity);

    QuantityMeasurementEntity add(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2);

    QuantityMeasurementEntity subtract(QuantityMeasurementEntity q1, QuantityMeasurementEntity q2);
}
