//package com.apps.quantitymeasurement;
//
//import java.util.Objects;
//import java.util.function.DoubleBinaryOperator;
//import com.apps.quantitymeasurement.Quantity;
//
//public enum ArithmeticOperation {
//
//    ADD((a, b) -> a + b),
//
//    SUBTRACT((a, b) -> a - b),
//
//    DIVIDE((a, b) -> {
//        if (b == 0)
//            throw new ArithmeticException("Division by zero");
//        return a / b;
//    });
//
//    private final DoubleBinaryOperator operation;
//
//    ArithmeticOperation(DoubleBinaryOperator operation) {
//        this.operation = operation;
//    }
//
//    public double compute(double a, double b) {
//        return operation.applyAsDouble(a, b);
//    }
//
//
//}