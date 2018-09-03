package com.jesselentz.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Expression current = new Expression();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        current.view = findViewById(R.id.editText);
    }

    public void oneKey (View view) {
        current.appendDigit('1');
        current.view.setText(current.display);
    }

    public void twoKey (View view) {
        current.appendDigit('2');
        current.view.setText(current.display);
    }

    public void threeKey (View view) {
        current.appendDigit('3');
        current.view.setText(current.display);
    }

    public void fourKey (View view) {
        current.appendDigit('4');
        current.view.setText(current.display);
    }

    public void fiveKey (View view) {
        current.appendDigit('5');
        current.view.setText(current.display);
    }

    public void sixKey (View view) {
        current.appendDigit('6');
        current.view.setText(current.display);
    }

    public void sevenKey (View view) {
        current.appendDigit('7');
        current.view.setText(current.display);
    }

    public void eightKey (View view) {
        current.appendDigit('8');
        current.view.setText(current.display);
    }

    public void nineKey (View view) {
        current.appendDigit('9');
        current.view.setText(current.display);
    }

    public void zeroKey (View view) {
        current.appendDigit('0');
        current.view.setText(current.display);
    }

    public void decimalKey (View view) {
       if (current.decimalCheck() == false) {
           current.appendDigit('.');
       }
        current.view.setText(current.display);
    }

    public void clearKey (View view) {
        current.clear();
        current.view.setText(current.display);
    }

    public void plusKey (View view) {
        if (current.currentTerm.length() > 0) {
            current.appendTerm('+');
            current.view.setText(current.display);
        }
    }

    public void minusKey (View view) {
        if (current.currentTerm.length() > 0) {
            current.appendTerm('-');
            current.view.setText(current.display);
        }
    }

    public void multiplicationKey (View view) {
        if (current.currentTerm.length() > 0) {
            current.appendTerm('x');
            current.view.setText(current.display);
        }
    }

    public void divisionKey (View view) {
        if (current.currentTerm.length() > 0) {
            current.appendTerm('/');
            current.view.setText(current.display);
        }
    }

    public void equalsKey (View view) {
        if (current.currentTerm.length() > 0) {
            current.appendTerm('=');
            current.equals();
            current.view.setText(current.display);
        }
    }
}
