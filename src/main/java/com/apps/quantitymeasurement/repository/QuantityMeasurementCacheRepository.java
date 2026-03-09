package com.apps.quantitymeasurement.repository;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {


        private static QuantityMeasurementCacheRepository instance;

        private List<QuantityMeasurementEntity> measurements;

        private QuantityMeasurementCacheRepository() {
            measurements = new ArrayList<>();
        }

        public static QuantityMeasurementCacheRepository getInstance() {
            if (instance == null) {
                instance = new QuantityMeasurementCacheRepository();
            }
            return instance;
        }

        @Override
        public void save(QuantityMeasurementEntity entity) {
            measurements.add(entity);
        }

        @Override
        public List<QuantityMeasurementEntity> getAllMeasurements() {
            return measurements;
        }
    }
