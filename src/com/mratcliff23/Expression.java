package com.mratcliff23;

public class Expression {
    private String[] parsed;

    public Expression(String input) {
        // https://www.baeldung.com/java-split-string-keep-delimiters
        this.parsed = input.replace(" ", "").split("((?=[+*/-])|(?<=[+*/-]))");
    }

    public double eval(){
        while(parsed.length>1) {
            for (int i = 0; i < parsed.length; i++) {
                if (parsed[i].equals("*") || parsed[i].equals("/")) {
                    if (parsed[i].equals("*")) {
                        parsed = doMultiplication(i);
                    } else if (parsed[i].equals("/")) {
                        parsed = doDivision(i);
                    }
                }
            }

            for (int i = 0; i < parsed.length; i++) {
                if (parsed[i].equals("+") || parsed[i].equals("-")) {
                    if (parsed[i].equals("+")) {
                        parsed = doAddition(i);
                    } else if (parsed[i].equals("-")) {
                        parsed = doSubtraction(i);
                    }
                }
            }
        }

        return Double.parseDouble(parsed[0]);
    }

    public String[] doMultiplication(int index){
        String[] result = new String[parsed.length-2];
        for(int i = 0; i < index-1; i++){
            result[i] = parsed[i];
        }

        result[index-1] = String.valueOf(Double.parseDouble(parsed[index-1]) * Double.parseDouble(parsed[index+1]));

        for(int i = index; i < result.length; i++){
            result[i] = parsed[i+2];
        }
        return result;
    }

    public String[] doDivision(int index){
        String[] result = new String[parsed.length-2];
        for(int i = 0; i < index-1; i++){
            result[i] = parsed[i];
        }

        result[index-1] = String.valueOf(Double.parseDouble(parsed[index-1]) / Double.parseDouble(parsed[index+1]));

        for(int i = index; i < result.length; i++){
            result[i] = parsed[i+2];
        }
        return result;
    }

    public String[] doAddition(int index){
        String[] result = new String[parsed.length-2];
        for(int i = 0; i < index-1; i++){
            result[i] = parsed[i];
        }

        result[index-1] = String.valueOf(Double.parseDouble(parsed[index-1]) + Double.parseDouble(parsed[index+1]));

        for(int i = index; i < result.length; i++){
            result[i] = parsed[i+2];
        }
        return result;
    }

    public String[] doSubtraction(int index){
        String[] result = new String[parsed.length-2];
        for(int i = 0; i < index-1; i++){
            result[i] = parsed[i];
        }

        result[index-1] = String.valueOf(Double.parseDouble(parsed[index-1]) - Double.parseDouble(parsed[index+1]));

        for(int i = index; i < result.length; i++){
            result[i] = parsed[i+2];
        }
        return result;
    }

    public String[] getParsed(){
        return parsed;
    }

}
