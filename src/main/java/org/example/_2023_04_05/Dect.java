package org.example._2023_04_05;

/**
 * @author Sergii Bugaienko
 */

public class Dect {
    public static void main(String[] args) {
        int i = 0b0000_0001;

        System.out.println("Сдвиг вправо:");
        System.out.println(i >> 1);

        System.out.println("Сдвиг влево:");
        System.out.println(i << 1);

        int b1 = 0b00001001;
        int b2 = 0b00001010;

        System.out.println("Побитовое И(AND)");
        printBinary(b1);
        printBinary(b2);
        printBinary(b1 & b2);
        System.out.println("-----------");

        System.out.println("Побитовое ИЛИ(OR)");
        printBinary(b1);
        printBinary(b2);
        printBinary(b1 | b2);
        System.out.println("-----------");

        System.out.println("Побитовое исключающее ИЛИ(XOR)");
        printBinary(b1);
        printBinary(b2);
        printBinary(b1 ^ b2);
        System.out.println("-----------");

        System.out.println("Побитовая инверсия (NOT)");
        printBinary(b1);
        printBinary(~b1);
        System.out.println("-----------");


        System.out.println("Установка разряда на второе место");
        int test = 0b11010000;
        printBinary(test);
        printBinary(test  | 0b10);
        System.out.println("-----------------");

        System.out.println("Сброс разряда");
        int test1 = 0b11111111;
        printBinary(test1);
        printBinary(test1 & 0b11111011 );


        System.out.println("Проверка значения разряда");
        printBinary(test);
        System.out.println((test & 0b00010000) > 0 ? 1 : 0);

        System.out.println("-----------------");

        int r = 64;
        int g = 128;
        int b = 32;

        int al = 255;
        int c = al << 24 | r << 16 | g << 8 | b;
        System.out.println(Integer.toBinaryString(c));

    }

//    public static void printBinary(int x){
//        System.out.println(Integer.toBinaryString(x));
//    }

    public static void printBinary(int b) {
        System.out.println("0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1));
    }

    public static String binaryStr(int b) {
        return "0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1);
    }
}
