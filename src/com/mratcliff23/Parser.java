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
            switch(n.toLowerCase()){
                case "matrix":
                case "mat":
                    return true;
            }
        }
        return false;
    }

    public boolean matrixOperations(){
        for(int i = 1; i < parsed.length-1; i++){
            if(parsed[i].equals("*") || parsed[i].equals("/") || parsed[i].equals("+") || parsed[i].equals("-")){
                if(parsed[i-1].equalsIgnoreCase("mata")  || parsed[i+1].equalsIgnoreCase("mata")) {
                    return true;
                }else if(parsed[i-1].equalsIgnoreCase("matb")  || parsed[i+1].equalsIgnoreCase("matab")){
                    return true;
                }
            }
        }
        return false;
    }

    public Matrix matrixEvaluate(){
        Matrix result = new Matrix(1, 1);

        return result;
    }



    public String[] getParsed() {
        return parsed;
    }
}
