package com.jesselentz.simplecalc;

import static java.lang.Double.parseDouble;

public class Term {
    protected double value;
    protected char operator; // operation to be applied to next term
    protected Term next;

    public Term(double total) {
        this.value = total;
    }

    public Term(String currentTerm, char operator) {
        this.value = parseDouble(currentTerm);
        this.operator = operator;
    }

    public void append(String currentTerm, char operator) {
          if (this.next != null) {
              this.next.append(currentTerm, operator);
          } else if  (this.operator == 'x') {
              this.value *= parseDouble(currentTerm);
              this.operator = operator;
          } else if (this.operator == '/') {
              this.value /= parseDouble(currentTerm);
              this.operator = operator;
          } else if (operator == '=') {
              this.next = new Term(currentTerm, operator);
          } else {
              this.next = new Term(currentTerm, operator);
          }
    }

    public void combine(double total, char operator) {
        double temp = total;
        if (operator == '+') {
            temp += this.value;
        } else if (operator == '-'){
            temp -= this.value;
        }

        if (this.operator == '=') {
            this.next = new Term(temp);
        } else {
            this.next.combine(temp, this.operator);
        }
    }
}
