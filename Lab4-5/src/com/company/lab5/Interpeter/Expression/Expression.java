package com.company.lab5.Interpeter.Expression;

import com.company.lab5.Interpeter.Context;

public class Expression {

    protected void startInterpret(Context context, String regex, String replacement){
        String temp = context.getResult();
        temp = temp.replaceAll(regex, replacement);
        context.setResult(temp);
    }

    public void start(Context context){
        new SpaceExpression().interpret(context);
        new DashExpression().interpret(context);
        new BracketExpression().interpret(context);
        new QuotesExpression().interpret(context);
        new NextLineExpression().interpret(context);
    }

    public void interpret(Context context){}
}
