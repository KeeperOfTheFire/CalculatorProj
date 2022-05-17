package com.mratcliff23;

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
            switch(n){
                case "Mat1":
                case "Mat2":
                case "MatA":
                case "MatB":
                    return true;
            }
        }
        return false;
    }



    public String[] getParsed() {
        return parsed;
    }
}
