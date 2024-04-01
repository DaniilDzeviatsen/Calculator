package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {


        System.out.println("Enter an arithmetic expression consisting of two numbers (Romanian or Arabic) from 1 to 10 (I to X) and an operator between them");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        calc(input);
    }

    public static boolean isAppropriateArabic(char a, char b) {
        boolean isArabic = false;
        if (a >= 'I' && a <= 'X' && b >= 'I' && b <= 'X') {
            isArabic = true;
        } else throw new IllegalArgumentException("Numbers should be Arabic or Romanian from 1 to 10");
        return isArabic;
    }

    public static boolean isAppropriateRomanian(char a, char b) {
        boolean isRomanian = false;
        if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
            isRomanian = true;
        } else throw new IllegalArgumentException("Numbers should be Arabic or Romanian from 1 to 10");
        return isRomanian;
    }

    public static boolean isAppropriateStr(String input) {
        String finalString = input.trim().replaceAll("\\s+", " ");
        Pattern pattern = Pattern.compile("");
        return true;
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
    }


    public static String calc(String input) {
        String finalString = input.trim().replaceAll("\\s+", " ");
        String[] str = finalString.split(" ");
        if (str.length != 3) {
            throw new IllegalArgumentException("строка не соответствует требованиям");
        }
        if (str[0].length() == 1 && str[2].length() == 1) {
            char a = str[0].charAt(0);
            char b = str[2].charAt(2);
            if (isAppropriateArabic(a, b)) {

            }
        }
        try {
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[2]);
            if (a >= 0 && a <= 10 & b >= 0 && b <= 10) {
                int result = switch (str[1]) {
                    case "+" -> result = a + b;
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> result = a / b;
                    default -> throw new IllegalArgumentException("Неверный знак операции");
                };
                System.out.println(result);
            } else throw new IllegalArgumentException("Числа не соответствуют требованиям");

        } catch (NumberFormatException numberFormatException) {
            System.out.println("Number format exception:" + numberFormatException.getMessage());
        }


        char[] arr = finalString.toCharArray();
        //System.out.println(arr);
        // if (isAppropriateRomanian(arr[0], arr[4])) ;

        return "dd";
    }
}