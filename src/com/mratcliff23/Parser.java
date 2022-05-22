package com.mratcliff23;

import java.util.ArrayList;
import java.util.Locale;

public class Parser {
    private String[] parsed;

    public Parser(String input) {
        this.parsed = input.split("((?=[+*-])|(?<=[+*-]))");
    }

    public boolean matrixOperations(){
        for(int i = 1; i < parsed.length-1; i++){
            if(parsed[i].equals("*") || parsed[i].equals("+") || parsed[i].equals("-")){
                if(parsed[i-1].equalsIgnoreCase("mata")  || parsed[i+1].equalsIgnoreCase("mata")) {
                    return true;
                }else if(parsed[i-1].equalsIgnoreCase("matb")  || parsed[i+1].equalsIgnoreCase("matb")){
                    return true;
                }
            }
        }
        return false;
    }


    public String[] getParsed() {
        return parsed;
    }
}
