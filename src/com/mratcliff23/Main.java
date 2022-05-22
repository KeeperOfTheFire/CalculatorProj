package com.mratcliff23;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static ArrayList<Matrix> ans = new ArrayList<>();

    static Matrix matA = new Matrix(0, 0);
    static Matrix matB = new Matrix(0, 0);

    public static void main(String[] args) {

        Matrix result = new Matrix(0, 0);
        boolean matsInitialized = false;
        String input;

        System.out.println("Initialize matrices A and B. these can always be changed using the command 'mat' or 'matrix'");
        try {
            initMatrices();
            matsInitialized = true;
        } catch (Exception e) {
            System.out.println("something happened and the matrices arent initialized \n" +
                    "please run 'mat or 'matrix' before attempting any operations\n");
            in.nextLine();
        }

        System.out.println("enter your input, it can be a matrix operation 'matA * matB', or a command like 'ans', 'mat', or 'help'");
        do {
            System.out.print("in: ");
            input = in.nextLine();
            Parser parsed = new Parser(input);



            if (parsed.matrixOperations()) {
                if (!matsInitialized) {
                    System.out.println("the matrices haven't been initialized yet \n" +
                            "please run 'mat' or 'matrix' to initialize them.");
                    continue;
                }

                if (parsed.getParsed()[0].equalsIgnoreCase("mata")) {
                    if (parsed.getParsed()[2].equalsIgnoreCase("matb")) {
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
                            continue;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }else if (parsed.getParsed()[2].equalsIgnoreCase("mata")) {
                        try {
                            switch (parsed.getParsed()[1]) {
                                case ("+"):
                                    result = new Matrix(matA.addOrSubMatrices(matA.getMat(), true));
                                case ("-"):
                                    result = new Matrix(matA.addOrSubMatrices(matA.getMat(), false));
                                case ("*"):
                                    result = new Matrix(matA.multiplyMatrices(matA.getMat()));

                            }
                            ans.add(result);
                            System.out.println(result);
                            continue;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } else if (parsed.getParsed()[0].equalsIgnoreCase("matb")) {
                    if (parsed.getParsed()[2].equalsIgnoreCase("mata")) {
                        try {
                            switch (parsed.getParsed()[1]) {
                                case ("+"):
                                    result = new Matrix(matB.addOrSubMatrices(matA.getMat(), true));
                                case ("-"):
                                    result = new Matrix(matB.addOrSubMatrices(matA.getMat(), false));
                                case ("*"):
                                    result = new Matrix(matB.multiplyMatrices(matA.getMat()));

                            }
                            ans.add(result);
                            System.out.println(result);
                            continue;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (parsed.getParsed()[2].equalsIgnoreCase("matb")) {
                        try {
                            switch (parsed.getParsed()[1]) {
                                case ("+"):
                                    result = new Matrix(matB.addOrSubMatrices(matB.getMat(), true));
                                case ("-"):
                                    result = new Matrix(matB.addOrSubMatrices(matB.getMat(), false));
                                case ("*"):
                                    result = new Matrix(matB.multiplyMatrices(matB.getMat()));

                            }
                            ans.add(result);
                            System.out.println(result);
                            continue;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                if (parsed.getParsed()[1].equalsIgnoreCase("*")) {

                    if(parsed.getParsed()[0].equalsIgnoreCase("mata")) {
                        try {
                            result = new Matrix(matA.multiplyMatrix(Integer.parseInt(parsed.getParsed()[2])));
                            ans.add(result);
                            System.out.println(result);
                        } catch (Exception e) {
                            System.out.println("please multiply the matrix by another matrix or by a number");
                        }
                    }else if (parsed.getParsed()[0].equalsIgnoreCase("matb")) {
                        try {
                            result = new Matrix(matB.multiplyMatrix(Integer.parseInt(parsed.getParsed()[2])));
                            ans.add(result);
                            System.out.println(result);
                        } catch (Exception e) {
                            System.out.println("please multiply the matrix by another matrix or by a number");
                        }
                    }else if(parsed.getParsed()[2].equalsIgnoreCase("mata")) {
                        try {
                            result = new Matrix(matA.multiplyMatrix(Integer.parseInt(parsed.getParsed()[0])));
                            ans.add(result);
                            System.out.println(result);
                        } catch (Exception e) {
                            System.out.println("please multiply the matrix by another matrix or by a number");
                        }
                    }else if (parsed.getParsed()[2].equalsIgnoreCase("matb")) {
                        try {
                            result = new Matrix(matB.multiplyMatrix(Integer.parseInt(parsed.getParsed()[0])));
                            ans.add(result);
                            System.out.println(result);
                        } catch (Exception e) {
                            System.out.println("please multiply the matrix by another matrix or by a number");
                        }
                    }
                }

            } else if (parsed.getParsed().length == 1 && parsed.getParsed()[0].equalsIgnoreCase("ans")) {
                getAns();
            } else if (parsed.getParsed().length == 1 && (parsed.getParsed()[0].equalsIgnoreCase("mat")
                    || parsed.getParsed()[0].equalsIgnoreCase("matrix"))) {
                try {
                    initMatrices();
                    matsInitialized = true;
                } catch (Exception e) {
                    System.out.println("something happened and the matrices arent initialized \n" +
                            "please run 'mat' or 'matrix' before attempting any operations");
                    in.nextLine();
                }
            } else if (parsed.getParsed().length == 1 && parsed.getParsed()[0].toLowerCase().contains("mat")) {
                if (!matsInitialized) {
                    System.out.println("the matrices haven't been initialized yet \n" +
                            "please run 'mat' or 'matrix' to initialize them.");
                    continue;
                }

                if (parsed.getParsed()[0].equalsIgnoreCase("mata")) {
                    System.out.println(matA);
                } else {
                    System.out.println(matB);
                }

            } else if (parsed.getParsed().length == 1 && parsed.getParsed()[0].equalsIgnoreCase("help")) {
                help();
            }

        } while (!input.equalsIgnoreCase("q") && !input.equalsIgnoreCase("quit"));//while

        System.out.println("shutting down...");

    }//main

    static void initMatrices() {
        System.out.println("initialize matA: ");

        //initializes the first matrix
        System.out.print("Enter the number of rows matA should have: ");
        int rows = in.nextInt();
        in.nextLine();
        System.out.print("Enter the number of columns matA should have: ");
        int cols = in.nextInt();
        in.nextLine();
        matA = new Matrix(rows, cols);

        matA.fillMatrix();


        //initializes the second matrix
        System.out.println("\n" +
                "initialize matB: ");
        System.out.print("Enter the number of rows matB should have: ");
        rows = in.nextInt();
        in.nextLine();
        System.out.print("Enter the number of columns matB should have: ");
        cols = in.nextInt();
        in.nextLine();
        matB = new Matrix(rows, cols);

        matB.fillMatrix();
    }

    static void getAns(){
        System.out.println("\n\n" +
                "which previous answer do you want: (e.x. 0 to go to the previous one");
        System.out.print("Enter your choice: ");
        int backward = in.nextInt();
        in.nextLine();
        try {
            System.out.println(ans.get(ans.size() - (backward + 1)));
        } catch (Exception e) {
            System.out.println("something went wrong \n" +
                    "You either haven't performed any operations yet, or went too far back");
        }
    }

    static void help(){
        System.out.println("This Calculator supports most matrix operations!!\n" +
                "here's a quick list of the commands:" +
                "\n\tmatrix * matrix - the columns of the first matrix must be equal to the rows of the second. \n" +
                "\t\tthe result will have the rows of the first matrix and the columns of the second " +
                "(ex. [3 by 2] * [2 by 4] = [3 by 4])" +
                "\n\tmatrix + matrix - the matrices must have the same dimensions (ex. [2 by 2] + [2 by 2])" +
                "\n\tmatrix - matrix - the matrices must have the same dimensions (ex. [2 by 2] + [2 by 2])" +
                "\n\tmatrix * constant - the constant must be a number. (ex. matrix * 2) " +
                "\n\tconstant * matrix - the constant must be a number. (ex. 2 * matrix)" +
                "\n\tans - fetches a previous result" +
                "\n\tmat or matrix - re-initializes the matrices" +
                "\n\thelp - displays this menu" +
                "\n\n");
        System.out.println("there are also some unsupported commands\n" +
                "here's a quick list:" +
                "\n\tdividing by a constant" +
                "\n\tperforming functions (ex. determinant)" +
                "\n\tanything that's otherwise impossible to do with matrices" +
                "\n\n");
    }
} //class
