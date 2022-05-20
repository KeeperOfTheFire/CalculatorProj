package com.mratcliff23;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    static Scanner in = new Scanner(System.in);

    public static ArrayList<Result> ans = new ArrayList();

    public static void main(String[] args) {
        Matrix matA = new Matrix(-1, -1);
        Matrix matB = new Matrix(-1, -1);
        Matrix result = new Matrix(-1,-1);
        boolean matsInitialized = false;
        String input = "";
        System.out.println("enter your input, it can be an expression like '1+1' or 'matA * matB'," +
                " or a command like 'ans' or 'mat'");
        while (!input.equalsIgnoreCase("q") && !input.equalsIgnoreCase("quit")) {
            System.out.print("in: ");
            input = in.nextLine();
            Parser parsed = new Parser(input);


            if(parsed.containMatrix()){
                System.out.println("initialize matA: ");

                //initializes the first matrix
                System.out.print("\n" +
                        "Enter the number of rows matA should have: ");
                int rows = in.nextInt();
                in.nextLine();
                System.out.print("\n" +
                        "Enter the number of columns matA should have: ");
                int cols = in.nextInt();
                matA = new Matrix(rows, cols);
                in.nextLine();

                matA.fillMatrix();


                //initializes the second matrix
                System.out.println("\n\n" +
                        "initialize matB: ");
                System.out.print("\n" +
                        "Enter the number of rows matB should have: ");
                rows = in.nextInt();
                System.out.print("\n" +
                        "Enter the number of columns matB should have: ");
                cols = in.nextInt();
                matB = new Matrix(rows, cols);
                in.nextLine();

                matB.fillMatrix();

                matsInitialized = true;

            }else if(parsed.isExpression()){
                if(parsed.matrixOperations()){
                    if(!matsInitialized){
                        System.out.println("you haven't initialized any matrices yet please run the command 'matrix'");
                        continue;
                    }

                    if(parsed.getParsed()[0].equalsIgnoreCase("mata")){
                        if(parsed.getParsed()[2].equalsIgnoreCase("matb")){
                            try {
                                switch (parsed.getParsed()[1]) {
                                    case ("+"):
                                        result = new Matrix(matA.addOrSubMatrices(matB.getMat(), true));
                                    case ("-"):
                                        result = new Matrix(matA.addOrSubMatrices(matB.getMat(), false));
                                    case ("*"):
                                        result = new Matrix(matA.multiplyMatrices(matB.getMat()));

                                }
                                ans.add(result);
                                System.out.println(result);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }else if(parsed.getParsed()[2].compareTo("0") >= 0){

                        }
                    }

                }else{
                    Expressions exp = new Expressions(input);

                    try {
                        exp.doEval();
                        ans.add(exp);
                        System.out.println(exp);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }


            }else if(parsed.getParsed()[0].equalsIgnoreCase("ans")){
                System.out.println("\n\n" +
                        "which previous answer do you want: (e.x. 0 to go to the previous one");
                System.out.print("Enter your choice: ");
                int backward = in.nextInt();
                in.nextLine();
                try {
                    System.out.println(ans.get(ans.size() - (backward + 1)));
                }catch(Exception e){
                    System.out.println(e);
                }
            }

        }//while

    }//main

} //class
