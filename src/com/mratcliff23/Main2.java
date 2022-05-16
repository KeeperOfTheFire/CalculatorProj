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

            }








        }//while

    }//main

} //class
