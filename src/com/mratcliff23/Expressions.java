package com.mratcliff23;

import java.util.ArrayList;
import java.util.Arrays;

public class Expressions {
    private final ArrayList<String> expression;

    public Expressions(String expression) {
        String[] temp = expression.split(" ");
        this.expression = new ArrayList<>();
        for (String i : temp) {
            this.expression.add(i);
        }
    }

    public double solve(){

        //gets the index of multiplication and division so that I can do pemdas
        ArrayList<Integer> indexOfMultandDiv = new ArrayList<>();
        for(int i = 0; i < expression.size(); i++){
            if(expression.get(i).equals("*") || expression.get(i).equals("/")){
                indexOfMultandDiv.add(i);
            }
        }

        System.out.println(expression);
        System.out.println(indexOfMultandDiv);


        //for(int i = 0; i < indexOfMultandDiv.size(); i++){
            int num1, num2;
            String operator;
            num1 = Integer.parseInt(expression.get(indexOfMultandDiv.get(0)-1));
            //expression.remove(indexOfMultandDiv.get(0)-1);
            operator = expression.get(indexOfMultandDiv.get(0));
            //expression.remove(indexOfMultandDiv.get(0));
            num2 = Integer.parseInt(expression.get(indexOfMultandDiv.get(0)+1));
            //expression.remove(indexOfMultandDiv.get(0)+1);

            if(operator.equals("*"))
                expression.add(indexOfMultandDiv.get(0)-1, String.valueOf((num1 * num2)));
            if(operator.equals("/"))
                expression.add(indexOfMultandDiv.get(0)-1, String.valueOf((double)(num1 / num2)));
        //}

        System.out.println(expression);


//
//        for(int i = 0; i < expression.length; i++){
//            System.out.print(expression[i] + ", ");
//        }
//
//        System.out.println("\n" + indexOfMultandDiv);

        return 0;
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)` | number
            //        | functionName `(` expression `)` | functionName factor
            //        | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return +parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
