package com.mratcliff23;

public class test {
    public static void main(String[] args) {
        Expression exp = new Expression("1+2*3+4*2+5/4+2*16");
        for(String i: exp.getParsed()){
            System.out.print(i + ", ");
        }
        double result = exp.eval();

        System.out.println();
        System.out.println();
        System.out.println();

        if((int)result == result){
            System.out.println((int)result);
        }else{
            System.out.println(result);
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for(String i: exp.getParsed()){
            System.out.print(i + ", ");
        }



    }
}
