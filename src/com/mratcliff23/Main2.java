package com.mratcliff23;

import java.util.Scanner;

public class Main2 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
       String input = "";
        while (!input.equalsIgnoreCase("q") && !input.equalsIgnoreCase("quit")) {
            input = in.nextLine();
            Parser parsed = new Parser(input);
            if(parsed.isExpression()){

            }else if(parsed.containMatrix()) {
                int rows, cols;
                System.out.print("enter the number of rows for the Matrix " + parsed.getParsed()[0] + ": ");
                rows = in.nextInt();
                in.nextLine();
                System.out.print("\n" + "enter the number of columns for the matrix " + parsed.getParsed()[0] + ": ");
                cols = in.nextInt();
                in.nextLine();

                Matrix mat1 = new Matrix(rows, cols, parsed.getParsed()[0]);
                System.out.println("now filling the matrix...");
                mat1.fillMatrix();
            }else{
                System.out.println("This input is not an expression");
            }








        }//while

    }//main

} //class
