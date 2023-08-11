// ICaltulatorXAidlInterface.aidl
package com.example.calculatorservice;

// Declare any non-default types here with import statements

interface ICaltulatorXAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    double evaluateExpression(String expression);
}