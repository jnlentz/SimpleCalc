package com.jesselentz.simplecalc;

import android.widget.EditText;

import static java.lang.Double.parseDouble;

public class Expression {
    public EditText view;
    protected String display; // contains full expression for display purposes only
    protected String currentTerm; // contains term currently being entered
    protected Term stack; // contains data for all terms and operations entered, FIFO
    protected double total;

    public Expression() {
        this.display = new String();
        this.currentTerm = new String();
    }

    public void appendDigit(char digit) {
        this.display += digit;
        this.currentTerm += digit;
    }

    public void displayOperator(char operator) {
        this.display += operator;
    }

    // creates new item in que for addition/subtraction, immediately applies multiplication/division to first item in que
    public void appendTerm(char operator) {
        if (this.stack == null) {
            this.stack = new Term(currentTerm, operator);
            this.display += operator;
            this.currentTerm = new String();
            System.out.println("Stack created, first value is " + this.stack.value);
        } else {
            stack.append(this.currentTerm, operator);
            this.display += operator;
            this.currentTerm = new String();
        }
    }

    public void clear() {
        this.display = new String();
        this.currentTerm = new String();
        this.stack = null;
        this.total = 0;
    }

    public boolean decimalCheck() {
        for (int i = currentTerm.length()-1; i >= 0; i--) {
            if (currentTerm.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    public double returnTotal(Term stack) {
        if (stack.next != null) {
            return returnTotal(stack.next);
        } else {
            return stack.value;
        }
    }

    public String formatTotal(double total) {
        String temp = Double.toString(total);
        if (temp.charAt(temp.length() - 2) == '.' && temp.charAt(temp.length() - 1) == '0') {
            return temp.substring(0, temp.length()-2);
        } else {
            return temp;
        }
    }
    public void equals() {
        stack.combine(0, '+');
        double total = returnTotal(this.stack);
        this.display = formatTotal(total);
        this.currentTerm = formatTotal(total);
        this.stack = null;
        this.total = 0;
    }
}
