package com.company.lab5.Interpeter.Expression;

import com.company.lab5.Interpeter.Context;

public class SpaceExpression extends Expression {
    @Override
    public void interpret(Context context) {
        startInterpret(context, " +", " ");
    }
}
