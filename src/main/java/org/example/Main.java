package org.example;

import java.util.Arrays;
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

    public static boolean isAppropriateRomanian(String a) {
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

        return romanianMap.containsKey(a);
    }

    public static boolean isAppropriateArabic(int a, int b) {
        boolean isArabic = false;
        if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
            isArabic = true;
        } else throw new IllegalArgumentException("Numbers should be Arabic or Romanian from 1 to 10");
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

    public static int calculate(int a, int b, String c) {
        int result = switch (c) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Неверный знак операции");
        };
        return result;
    }


    public static String calc(String input) {
        //разделяем всю введенную строку на массив из 3х частей и проверяем валидность введенных данных
        String finalString = input.trim().replaceAll("\\s+", "");
        char[] charArray = finalString.toCharArray();
        boolean isOperatorCorrect = false;
        for (int i = 0; i < charArray.length - 1; i++) {

            if (charArray[i] == '-' || charArray[i] == '+' || charArray[i] == '*' || charArray[i] == '/') {
                isOperatorCorrect = true;
            }
        }
        if (!isOperatorCorrect) throw new IllegalArgumentException("Не введен верный знак математической операции");
        String fNum = "";
        String sNum = "";
        String operator = "";
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == '+' || charArray[i] == '*' || charArray[i] == '-' || charArray[i] == '/') {
                char[] firstNum = Arrays.copyOfRange(charArray, 0, i);
                operator = String.valueOf(charArray[i]);
                char[] secondNum = Arrays.copyOfRange(charArray, i + 1, charArray.length);
                fNum = String.valueOf(firstNum);
                sNum = String.valueOf(secondNum);
            }
        }
        int a;
        int b;
        int result = 0;
        if (!isAppropriateRomanian(fNum) && !isAppropriateRomanian(sNum)) {
            a = Integer.parseInt(fNum);
            b = Integer.parseInt(sNum);
            if (isAppropriateArabic(a, b))
                result = calculate(a, b, operator);

        } else if (isAppropriateRomanian(fNum) && isAppropriateRomanian(sNum)) {
            a = convertToArabic(fNum);
            b = convertToArabic(sNum);
            result = calculate(a, b, operator);
            if (result < 1) throw new IllegalArgumentException("Римские числа не могут быть отрицателными");

        } else throw new IllegalArgumentException("Числа не соответствуют требованиям");
        System.out.println(result);
        return String.valueOf(result);
    }
}