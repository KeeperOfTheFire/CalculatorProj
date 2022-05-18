package com.mratcliff23;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    static Scanner in = new Scanner(System.in);

    public static ArrayList<Result> ans = new ArrayList();

    public static void main(String[] args) {
       String input = "";
        while (!input.equalsIgnoreCase("q") && !input.equalsIgnoreCase("quit")) {
            System.out.print("enter your input, it can be an expression like '1+1', or a command like 'ans' or 'mat': ");
            input = in.nextLine();
            Parser parsed = new Parser(input);

            if(parsed.containMatrix()){
                int rows, cols;
                System.out.println("Initializing Matrix 'MatA':");
                System.out.print("enter the number of rows for the Matrix " + parsed.getParsed()[0] + ": ");
                rows = in.nextInt();
                in.nextLine();
                System.out.print("\n" + "enter the number of columns for the matrix " + parsed.getParsed()[0] + ": ");
                cols = in.nextInt();
                in.nextLine();

                Matrix matA = new Matrix(rows, cols, parsed.getParsed()[0]);
                System.out.println("now filling 'MatB'...");
                matA.fillMatrix();


                System.out.println("Initializing Matrix 'MatB':");
                System.out.print("enter the number of rows for the Matrix " + parsed.getParsed()[0] + ": ");
                rows = in.nextInt();
                in.nextLine();
                System.out.print("\n" + "enter the number of columns for the matrix " + parsed.getParsed()[0] + ": ");
                cols = in.nextInt();
                in.nextLine();

                Matrix matB = new Matrix(rows, cols, parsed.getParsed()[0]);
                System.out.println("now filling 'MatB'...");
                matB.fillMatrix();



            }else if(parsed.matrixOperations()) {
                ans.add(parsed.matrixEvaluate());
                System.out.println(ans.get(ans.size()-1));
            }else{
                System.out.println("This input is invalid");
            }








        }//while

    }//main

} //class
