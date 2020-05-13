package com.company.lab5.Interpeter;

import com.company.lab5.Interpeter.Expression.*;

public class Main {
    public static void main(String[] args) {
        String source = "abc    -     def . Def( \"def\" ) , \"ghj\" . xyz \n\n xyz";
        Context context = new Context(source);
        System.out.println("Source: " + source);
        new Expression().start(context);
        System.out.println(context.getResult());
    }
}
