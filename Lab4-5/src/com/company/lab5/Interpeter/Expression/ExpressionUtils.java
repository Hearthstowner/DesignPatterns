package com.company.lab5.Interpeter.Expression;

import com.company.lab5.Interpeter.Context;

public class ExpressionUtils {
    public static void doInterpret(Context context){
        new SpaceExpression().interpret(context);
        new DashExpression().interpret(context);
        new BracketExpression().interpret(context);
        new QuotesExpression().interpret(context);
        new NextLineExpression().interpret(context);
    }
}
