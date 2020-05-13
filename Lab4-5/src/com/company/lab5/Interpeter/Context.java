package com.company.lab5.Interpeter;

public class Context {
    private String source;
    private StringBuilder result;

    public Context(String source) {
        this.source = source;
        result = new StringBuilder();
    }

    public String getResult() {
        if(result.toString().equals(""))
            return source;
        else
            return result.toString();
    }

    public void setResult(String result) {
        this.result.replace(0, this.result.length(), result);
    }

}
