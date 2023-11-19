import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Calculator {
    public static void main(String[] args) {

        System.out.println("Калькулятор умеет выполнять операции сложения,\n" +
                "вычитания, умножения и деления с двумя числами\n\n" +
                "Введите арифметическое выражение\n");
        System.out.println("Input:");
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        System.out.println("Output:");
        System.out.println(Main.calc(expression));
    }
}

class Main {





    public static String calc(String input) {
        boolean romanOrArab = false;
        String[] term = input.split(" ");



        String resultString = null;
        String answer = null;



        if (term.length != 3) {

            try {
                throw new MyException("Введено неверное выражение");
            } catch (MyException e) {

                return e.toString();
            }
        }

        Integer a = 0;
        Integer b = 0;



        try {
            a = parseInt(term[0]);
            b = parseInt(term[2]);

        } catch (NumberFormatException e) {
            try {
                RomanNumber roman1 = RomanNumber.valueOf(term[0]);
                RomanNumber roman2 = RomanNumber.valueOf(term[2]);
                a = roman1.getArabic();
                b = roman2.getArabic();
                romanOrArab = true;
            } catch (NumberFormatException ex){
                ex.toString();
            }
        }



        if ((a < 1) || (a > 10) || (b < 1) || (b > 10)) {
            try {
                throw new MyException("Введены числа больше 10 или меньше 1");
            } catch (MyException e) {

                return e.toString();
            }

        }

        switch (term[1]) {
            case "+":
                int result = a + b;


                answer = String.valueOf(result);
                break;
            case "/":
                int result2 = a / b;
                answer = String.valueOf(result2);
                break;
            case "-":
                int result3 = a - b;
                answer = String.valueOf(result3);
                break;

            case "*":
                int result4 = a * b;
                answer = String.valueOf(result4);

                break;
            default:
                try {
                    throw new MyException("Введен не арифметический знак");
                } catch (MyException e) {

                    return e.toString();
                }
        }
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        if(romanOrArab){

            String answer1 = roman[parseInt(answer)];
            int answer0 = parseInt(answer);
            if (answer0<1){
                try {
                    throw new MyException("Ответ в римских числах < 1");
                } catch (MyException e) {

                    return e.toString();
                }

            } else {
                return  answer1;            }

        }
        return  answer;


        }

    }


