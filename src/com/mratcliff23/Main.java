package com.mratcliff23;

import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String choice = " ";
        while(!choice.equalsIgnoreCase("q")){
            choice = menu();

            //expressions
            if(choice.equalsIgnoreCase("1")){
                System.out.print("\n\n" +
                        "Enter an expression with each term separated by a space " +
                        "(ex: 1 + 1):");
                String expression = in.nextLine();
                Expressions exp = new Expressions(expression);
                exp.solve();

            //matrix operations
            }else if(choice.equalsIgnoreCase("2")) {
                //initializes the first matrix
                System.out.print("\n\n" +
                        "Enter the number of rows matrix A should have: ");
                int rows = in.nextInt();
                System.out.print("\n" +
                        "Enter the number of columns matrix A should have: ");
                int cols = in.nextInt();
                Matrix mat = new Matrix(rows, cols);
                in.nextLine();

                mat.fillMatrix();


                //initializes the second matrix
                System.out.print("\n\n" +
                        "Enter the number of rows matrix B should have: ");
                rows = in.nextInt();
                System.out.print("\n" +
                        "Enter the number of columns matrix B should have: ");
                cols = in.nextInt();
                Matrix mat2 = new Matrix(rows, cols);
                in.nextLine();

                mat2.fillMatrix();


                while (!choice.equalsIgnoreCase("6")) {
                    System.out.println("\n\n" +
                            "What would you like to do with your matrices:\n" +
                            "1) Add\n" +
                            "2) Subtract\n" +
                            "3) Multiply\n" +
                            "4) Multiply by a constant\n" +
                            "5) Print matrix\n" +
                            "6) Stop matrix operations");
                    System.out.print("Enter your choice: ");
                    choice = in.nextLine();


                    int[][] result;
                    if (choice.equalsIgnoreCase("1")) {
                        try{
                            result = mat.addOrSubMatrices(mat2.getMat(), true);
                            Matrix.printMat(result);
                        }catch (Exception e){
                            System.out.println("These matrices don't have the same dimensions");
                        }

                    } else if (choice.equalsIgnoreCase("2")) {
                        try{
                            result = mat.addOrSubMatrices(mat2.getMat(), true);
                            Matrix.printMat(result);
                        }catch (Exception e){
                            System.out.println("These matrices don't have the same dimensions");
                        }
                    } else if (choice.equalsIgnoreCase("3")) {
                        try{
                            result = mat.multiplyMatrices(mat2.getMat());
                            Matrix.printMat(result);
                        }catch (Exception e){
                            System.out.println("These matrices don't have the right dimensions\n" +
                                    "please make sure the number of columns in the first matrix " +
                                    "is equal to the number of rows in the second matrix");
                        }
                    } else if (choice.equalsIgnoreCase("4")) {
                        System.out.print("Which matrix would you like to multiply (A/B): ");
                        choice = in.nextLine();
                        if (choice.equalsIgnoreCase("a")) {
                            System.out.print("What number would you like to multiply it by: ");
                            choice = in.nextLine();
                            result = mat.multiplyMatrix(Integer.parseInt(choice));
                            Matrix.printMat(result);
                        } else if (choice.equalsIgnoreCase("b")) {
                            System.out.print("What number would you like to multiply it by: ");
                            choice = in.nextLine();
                            result = mat2.multiplyMatrix(Integer.parseInt(choice));
                            Matrix.printMat(result);
                        }
                    } else if (choice.equalsIgnoreCase("5")) {
                        System.out.print("Which matrix would you like to print (A/B): ");
                        choice = in.nextLine();
                        if (choice.equalsIgnoreCase("a")) {
                            Matrix.printMat(mat.getMat());
                        } else if (choice.equalsIgnoreCase("b")) {
                            Matrix.printMat(mat2.getMat());
                        }
                    }
                }
                }

        }
    }

    public static String menu(){
        String choice;
        System.out.println(
                "\n\n" +
                "Enter the character corresponding to your choice: \n" +
                "1) Simplify Expression \n" +
                "2) Matrix Operations \n" +
                "2) Solve Equation \n" +
                "3) Convert between Number Systems \n" +
                "4) Get Previous Result \n" +
                "Q) Quit program");
        System.out.print("Enter your choice here: ");
        choice = in.nextLine();
        return choice;
    }
}
