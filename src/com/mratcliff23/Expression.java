package com.mratcliff23;

public class Expression extends Ans {
    private String[] parsed;
    private double result;

    public Expression(String input) {
        // https://www.baeldung.com/java-split-string-keep-delimiters
        this.parsed = input.replace(" ", "").split("((?=[+*^()/-])|(?<=[+*^()/-]))");
    }

    public Expression(String[] input){
        this.parsed = input;
    }

    public void eval(){
        while(parsed.length>1) {

            for (int i = 0; i < parsed.length; i++) {
                if (parsed[i].equals("(")) {
                    for (int n = i; n < parsed.length; n++) {
                        if (parsed[n].equals(")")) {
                            parsed = doParentheses(i+1, n);
                        }
                        if(n == parsed.length-1 && !parsed[n].equals(")")){
                            throw new IllegalArgumentException("no closing parentheses");
                        }
                    }
                }
            }

            for (int i = 0; i < parsed.length; i++) {
                if (parsed[i].equals("^")) {
                    parsed = doExponent(i);
                }
            }

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


        result = Double.parseDouble(parsed[0]);
    }


    public String[] doParentheses(int startIndex, int endIndex){
        String[] result = new String[parsed.length-(endIndex-startIndex)];
        for(int i = 0; i < startIndex-1; i++){
            result[i] = parsed[i];
        }

        String[] temp = new String[endIndex-(startIndex)];
        for(int i = 0, n = startIndex; i < temp.length; i++, n++){
            temp[i] = parsed[n];
        }

        Expression exp = new Expression(temp);
        exp.eval();
        result[startIndex-1] = String.valueOf(exp);


        for(int i = endIndex; i < result.length; i++){
            result[i] = parsed[i+2];
        }

        return result;
    }
    public String[] doExponent(int index){
        String[] result = new String[parsed.length-2];
        for(int i = 0; i < index-1; i++){
            result[i] = parsed[i];
        }

        result[index-1] = String.valueOf(Math.pow(Double.parseDouble(parsed[index-1]), Double.parseDouble(parsed[index+1])));

        for(int i = index; i < result.length; i++){
            result[i] = parsed[i+2];
        }
        return result;
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

    public String toString(){
        if((int)result == result){
            return String.valueOf((int)result);
        }else{
            return String.valueOf(result);
        }
    }

}
