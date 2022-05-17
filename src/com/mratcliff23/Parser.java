package com.mratcliff23;

import java.util.Locale;

public class Parser {
    private String[] parsed;

    public Parser(String input) {
        this.parsed = input.split(" ");
    }

    public boolean isExpression(){
        for(String n : parsed){
            switch(n){
                case "*":
                case "+":
                case "-":
                    return true;
            }
        }
        return false;
    }

    public boolean containMatrix(){
        for(String n : parsed){
            if(n.toLowerCase().indexOf("mat") >= 0){
                return true;
            }
        }
        return false;
    }



    public String[] getParsed() {
        return parsed;
    }
}
