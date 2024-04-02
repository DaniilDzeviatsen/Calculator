package org.example;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {


        System.out.println("Enter an arithmetic expression consisting of two numbers (Romanian or Arabic) from 1 to 10 (I to X) and an operator between them");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        calc(input);
    }

    public static boolean isAppropriateRomanian(String a, String b) {
        TreeMap<String, Integer> romanianMap = new TreeMap<>();
        romanianMap.put("I", 1);
        romanianMap.put("II", 2);
        romanianMap.put("III", 3);
        romanianMap.put("IV", 4);
        romanianMap.put("V", 5);
        romanianMap.put("VI", 6);
        romanianMap.put("VII", 7);
        romanianMap.put("VIII", 8);
        romanianMap.put("IX", 9);
        romanianMap.put("X", 10);

        return romanianMap.containsKey(a) && romanianMap.containsKey(b);
    }

    public static boolean isAppropriateArabic(String firstNum, String secondNum) {
        int a = Integer.parseInt(firstNum);
        int b = Integer.parseInt(secondNum);
        boolean isArabic = false;
        if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
            isArabic = true;
        } //else throw new IllegalArgumentException("Numbers should be Arabic or Romanian from 1 to 10");
        return isArabic;
    }

    public static int convertToArabic(String romanianNum) {
        int arabicNum = switch (romanianNum) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new IllegalArgumentException("Числа не соответствуют требованиям");
        };
        return arabicNum;
    }
    public static int calculate(int a, int b, String c){
        int result = switch (c) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Неверный знак операции");
        };
        System.out.println(result);
        return result;
    }


    public static String calc(String input) {
        //разделяем всю введенную строку на массив из 3х частей и проверяем валидность введенных данных
        String finalString = input.trim().replaceAll("\\s+", " ");
        char [] charArray=finalString.toCharArray();
        for (int i=0; i<10; i++){
            //если равно знаку дейтсвия соединяем
        }
        String[] str = finalString.split(" ");
        if (str.length != 3) {
            throw new IllegalArgumentException("строка не соответствует требованиям");
        }
        //калькулятор для арабских цифр и проверка на соответствие заданию (числа должны быть от 1 до 10)
        int a;
        int b;

        if (!isAppropriateRomanian(str[0], str[2])) {
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[2]);

            return String.valueOf(calculate(a,b, str[1]));

        } else if (isAppropriateRomanian(str[0], str[2])) {
            a = convertToArabic(str[0]);
            b = convertToArabic(str[2]);
            int result=calculate(a, b, str[1]);
            if (result>0) {
                return String.valueOf(result);
            } else throw new IllegalArgumentException("Римские числа не могут быть отрицателными");
        } else throw new IllegalArgumentException("Числа не соответствуют требованиям");

    }
}