package com.jesselentz.simplecalc;
// Stores expressions for future use, currently inaccessible from the app
public class History {
    protected Term expression;
    protected History next;


    public History() {}
    public History(Term expression) {
        this.expression = expression;
    }


    public void appendExpression(Term expression) {
        if (this.expression == null) {
            this.expression = expression;
            System.out.println("First expression added");
        } else if (this.next == null) {
            this.next = new History(expression);
            System.out.println("Expression added");
        } else {
            this.next.appendExpression(expression);
        }
    }

}