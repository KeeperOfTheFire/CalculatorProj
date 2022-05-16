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
}
