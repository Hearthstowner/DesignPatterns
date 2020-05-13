package com.company.lab5.Interpeter.Expression;

import com.company.lab5.Interpeter.Context;

public class QuotesExpression extends Expression {
    @Override
    public void interpret(Context context) {
        int count = 1;
        String temp = context.getResult();
        StringBuilder builder = new StringBuilder();
        builder.append(context.getResult());
        char[] src = temp.toCharArray();
        for (int i = 0; i < src.length; i++) {
            if(src[i] == '"' && count < 2){
                src[i] = '«';
                count++;
            }else if(src[i] == '"'){
                src[i] = '»';
                count = 1;
            }
        }
        context.setResult(String.valueOf(src));
    }
}

