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
        this.display = "";
        this.currentTerm = "";
    }

    // adds new input digit to both display and currentTerm
    public void appendDigit(char digit) {
        this.display += digit;
        this.currentTerm += digit;
    }

    // creates new item in que for addition/subtraction, immediately applies multiplication/division to first item in que
    public void appendTerm(char operator) {
        if (this.stack == null) {
            this.stack = new Term(currentTerm, operator);
            this.display += operator;
            this.currentTerm = "";
            System.out.println("Stack created, first value is " + this.stack.value);
        } else {
            stack.append(this.currentTerm, operator);
            this.display += operator;
            this.currentTerm = "";
        }
    }

    // clears all class data
    public void clear() {
        this.display = "";
        this.currentTerm = "";
        this.stack = null;
        this.total = 0;
    }

    // ensures user can only input 1 decimal per term
    public boolean decimalCheck() {
        for (int i = currentTerm.length()-1; i >= 0; i--) {
            if (currentTerm.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    // trims ".0" off of displayed totals after being converted from double to string
    public String formatTotal(double total) {
        String temp = Double.toString(total);
        if (temp.charAt(temp.length() - 2) == '.' && temp.charAt(temp.length() - 1) == '0') {
            return temp.substring(0, temp.length()-2);
        } else {
            return temp;
        }
    }

    // returns stack object to be stored in previousExpressions
    public Term getExpression() {
        stack.combine(0, '+');
        return this.stack;
    }
    // returns total from stack after stack.combine() has been called
    public double returnTotal(Term stack) {
        if (stack.next != null) {
            return returnTotal(stack.next);
        } else {
            return stack.value;
        }
    }

    /* retrieves total, converts from double to string, and sets it as the value of both display and currentTerm.
       This allows the user to continue working with their total after pressing the '=' key as if they had entered
       the number themselves.
     */
    public void equals() {
        double total = returnTotal(this.stack);
        this.display = formatTotal(total);
        this.currentTerm = formatTotal(total);
        this.stack = null;
        this.total = 0;
    }
}
