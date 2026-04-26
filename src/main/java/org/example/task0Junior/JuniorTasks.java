package org.example.task0Junior;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class JuniorTasks {
//    Задачи джуниор
//    Задача 1: Простой калькулятор
//    Напишите метод calculate, который принимает два числа a и b и оператор (+, -, *, /). Метод должен вернуть результат операции. Обработайте случай деления на ноль.

    //  Решение 1 :
    public void task1() throws IOException {
        int var1 = 0;
        int var2 = 0;
        InputStream iS = System.in;
        Reader iSR = new InputStreamReader(iS);
        BufferedReader reader = new BufferedReader(iSR);
        System.out.println("Enter the fist argument");
        String readFirstArg = reader.readLine();
        try {
            var1 = Integer.parseInt(readFirstArg);
        } catch (NumberFormatException parseException) {
            System.out.println("Incorrect argument");
            return;
        }
        System.out.println("Enter math operation");
        String readMathSign = reader.readLine();
        if (!readMathSign.equals("+") && !readMathSign.equals("-") && !readMathSign.equals("*") && !readMathSign.equals("/")) {
            System.out.println("Incorrect sign");
            return;
        }
        System.out.println("Enter the second argument");
        String readSecondArg = reader.readLine();
        try {
            var2 = Integer.parseInt(readSecondArg);
        } catch (NumberFormatException parseException) {
            System.out.println("Incorrect argument");
            return;
        }
        reader.close();

        switch (readMathSign) {
            case "+":
                System.out.println(var1 + var2);
                break;
            case "-":
                System.out.println(var1 - var2);
                break;
            case "*":
                System.out.println(var1 * var2);
                break;
            case "/":
                if (var2 == 0) {
                    System.out.println("Division by zero is not allowed");
                } else {
                    System.out.println(var1 / var2);
                }
                break;
            default:
                System.out.println("Incorrect math operation");
        }
    }


//    Задача 2:
//    Поиск максимального
//    элемента в
//    массиве
//    Напишите метод
//    findMax,
//    который принимает
//    массив целых
//    чисел и
//    возвращает его
//    максимальный элемент.
//    Не используйте
//    Arrays.sort.
//            Решение 2:

    public static void task2d1(ArrayList<Integer> list) {
        if (list == null) {
            System.out.println("Massive is null");
            return;
        }
        if (list.isEmpty()) {
            System.out.println("Massive is empty");
            return;
        }
        if (list.size() < 2) {
            System.out.println("Massive contains just 1 element" + " " + list);
            return;

        }

        boolean[] sorted = {false};
        while (!sorted[0]) {
            sorted[0] = true;
            IntStream.range(0, list.size() - 1).forEach(i ->
            {
                int temp = list.get(i);
                if (list.get(i) > list.get(i + 1)) {
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted[0] = false;
                }
            });
        }
        System.out.println("Sorted list: " + list);
    }

//    Задача 3:
//    Проверка палиндрома
//    Напишите метод
//    isPalindrome,
//    который принимает
//    строку и
//    возвращает true,
//    если строка
//
//    является палиндромом(игнорируя регистр и пробелы).Пример:"А роза упала на лапу Азора".
//    Решение 3:

    public static void isPalindrome(String enteredMessage) {
        if (enteredMessage.isBlank()) {
            System.out.println("Incoming string is blank");
            return;
        }
        enteredMessage = enteredMessage.replaceAll("\\s", "");
        String reversedMessage = new StringBuilder(enteredMessage).reverse().toString();
        if (enteredMessage.equalsIgnoreCase(reversedMessage)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
//
//    Задача 4:
//    Сумма четных
//    чисел
//    Напишите метод
//    sumEvenNumbers,
//    который принимает
//    массив целых
//    чисел и
//    возвращает сумму
//    всех четных
//    чисел.
//            Решение 4:

    public static void sumEvenNumbers(ArrayList<Integer> list) {
        if (list == null) {
            System.out.println("Incoming list is null!");
            return;
        }
        if (list.isEmpty()) {
            System.out.println("Incoming list is empty!");
            return;
        }
        int buffer = 0;
        int counter = 0;
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                buffer += integer;
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("There is no even elements! ");
        } else {
            System.out.println("Sum of every even elements: " + buffer);
        }
    }

//    Задача 5:
//    Конвертер температуры
//    Создайте класс
//    TemperatureConverter с
//    методами celsiusToFahrenheit
//    и fahrenheitToCelsius.
//    Решение 5:

    public class TemperatureConverter {

        public double celsiusToFahrenheit(double celsius) {
            return (celsius * 9 / 5) + 32;
        }

        public double fahrenheitToCelsius(double fahrenheit) {
            return (fahrenheit - 32) * 5 / 9;
        }
    }

//    Задача 6:
//    Переворот строки
//    Напишите метод, который
//
//    переворачивает строку(например, "hello" ->"olleh").
//    Не используйте
//    встроенные методы
//
//    reverse().
//    Решение 6:

    public static String stringReversing(String incoming) {
        if (incoming == null) {
            return "";
        }

        char[] chars = incoming.toCharArray();
        char[] reversed = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }

        return new String(reversed);
    }

//    Задача 7:
//    Поиск минимального
//    и максимального
//    Напишите метод, который
//    принимает массив
//    целых чисел
//    и выводит
//    в консоль
//    наименьший и
//    наибольший элемент.
//    Не используйте Arrays.sort().
//    решение 7:

    public static String minMax(ArrayList<Integer> incoming) {
        if (incoming == null || incoming.isEmpty()) {
            return "Incoming array is empty or null";
        }
        int bufferMin = incoming.get(0);
        int bufferMax = incoming.get(0);
        for (int number : incoming) {
            if (number > bufferMax) {
                bufferMax = number;
            } else if (number < bufferMin)
                bufferMin = number;
        }

        return "Max== " + bufferMax + " Min== " + bufferMin;
    }

//    Задача 8
//    Среднее значение
//    массива
//    Напишите метод, который
//    вычисляет и
//    возвращает среднее
//    арифметическое всех
//    элементов массива
//    чисел с
//    плавающей точкой.
//    Решение 8:

    public static String arithmeticMean(ArrayList<Double> incoming) {
        if (incoming == null || incoming.isEmpty()) {
            return "incoming is null";
        }

        double sum = 0.0;
        for (double eachElem : incoming) {
            sum += eachElem;
        }
        return "Mean == " + sum / incoming.size();
    }

//    Задача 9:
//    Проверка на
//    простое число
//    Напишите метод, который
//    проверяет,
//    является ли
//    переданное число
//    простым.
//            Решение 9:

    public static boolean isSimple(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
//
//    Задача 10:
//    Поиск дубликатов
//    в массиве
//    Напишите метод, который
//    принимает массив
//    строк и
//    возвращает true,
//    если в
//    массиве есть
//    повторяющиеся элементы, и false —
//    если все
//    элементы уникальны.
//    Решение 10:

    public static boolean isUniq(String[] incoming) {
        if (incoming == null || incoming.length == 0) {
            System.out.println("incoming mas is null or empty");
            return false;
        }
        List<String> incomingAsList = new ArrayList<>(Arrays.asList(incoming));
        HashSet<String> incomingAsHashSet = new HashSet<>(incomingAsList);
        if (incomingAsHashSet.size() == incomingAsList.size()) {
            return false;
        } else return true;
    }


//    Задача 11:FizzBuzz
//    Классическая задача.
//    Выведите числа
//    от 1до 100.
//    Но если
//    число делится
//    на 3,выведите "Fizz",
//    если на 5 — "Buzz",
//    а если
//    и на 3,
//    и на 5 — "FizzBuzz".
//    решение 11:

    public static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }


}
