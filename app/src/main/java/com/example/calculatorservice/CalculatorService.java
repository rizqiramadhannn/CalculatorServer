package com.example.calculatorservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.example.calculatorservice.ICaltulatorXAidlInterface;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

// CalculatorService.java in the server app
public class CalculatorService extends Service {
    private ScriptEngine mScriptEngine;

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the ScriptEngine here, when the service is created
        mScriptEngine = new ScriptEngineManager().getEngineByName("rhino");
    }

    private final ICaltulatorXAidlInterface.Stub mBinder = new ICaltulatorXAidlInterface.Stub() {
        @Override
        public double evaluateExpression(String expression) {
            return performEvaluation(expression);
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private double performEvaluation(String expression) {
        if (mScriptEngine == null) {
            return Double.NaN;  // Handle initialization error
        }

        expression = expression.replace('x', '*');
        try {
            return (double) mScriptEngine.eval(expression);
        } catch (ScriptException e) {
            return Double.NaN;  // Handle script evaluation error
        }
    }
}