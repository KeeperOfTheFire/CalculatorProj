package com.mratcliff23;

public class Parser {
    private final String[] parsed;

    public Parser(String input) {
        // https://www.baeldung.com/java-split-string-keep-delimiters
        this.parsed = input.replace(" ", "").split("((?=[+*-])|(?<=[+*-]))");
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
