package com.company.lab5.Interpeter.Expression;

import com.company.lab5.Interpeter.Context;

public class BracketExpression extends Expression {
    @Override
    public void interpret(Context context) {
        startInterpret(context, "\\Q(\\E ", "(");
        startInterpret(context, " \\Q)\\E", ")");
        startInterpret(context, " \\Q,\\E", ",");
        startInterpret(context, " \\Q.\\E", ".");
    }

}
