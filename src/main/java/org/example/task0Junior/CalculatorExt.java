package org.example.task0Junior;

import java.io.*;
import java.util.ArrayList;

public class CalculatorExt {
    /**
     * 1.1 Калькулятор с историей (тема: «Простой калькулятор»)
     * Условие
     * Модифицируйте консольный калькулятор так, чтобы он запоминал последние 5 операций (каждая операция – это строка вида "2 + 3 = 5"). Добавьте команду history для вывода всех сохранённых операций. Если операций меньше пяти – выводить все.
     **/

    ArrayList<String> memBuffer = new ArrayList<>();


    public void task11CalculatorWithMemory() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("Enter first number (or 'history' / 'exit'): ");
                String readFirstArg = reader.readLine();
                if (readFirstArg == null) break;
                if (readFirstArg.equalsIgnoreCase("exit")) break;
                if (readFirstArg.equalsIgnoreCase("history")) {
                    System.out.println("Operation history:");
                    history();
                    continue;
                }
                int var1, var2;
                try {
                    var1 = Integer.parseInt(readFirstArg);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Try again.");
                    continue;
                }
                System.out.print("Enter math operation (+, -, *, /): ");
                String readMathSign = reader.readLine();
                if (!readMathSign.matches("[+\\-*/]")) {
                    System.out.println("Invalid operation. Try again.");
                    continue;
                }
                System.out.print("Enter second number: ");
                String readSecondArg = reader.readLine();
                try {
                    var2 = Integer.parseInt(readSecondArg);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Try again.");
                    continue;
                }
                String operationBuffer;
                switch (readMathSign) {
                    case "+":
                        operationBuffer = var1 + "+" + var2 + "=" + (var1 + var2);
                        break;
                    case "-":
                        operationBuffer = var1 + "-" + var2 + "=" + (var1 - var2);
                        break;
                    case "*":
                        operationBuffer = var1 + "*" + var2 + "=" + (var1 * var2);
                        break;
                    case "/":
                        if (var2 == 0) {
                            System.out.println("Division by zero is not allowed.");
                            continue;
                        }
                        operationBuffer = var1 + "/" + var2 + "=" + ((double) var1 / var2);
                        break;
                    default:
                        System.out.println("Unexpected error.");
                        continue;
                }
                System.out.println(operationBuffer);
                memBuffer.add(operationBuffer);
                if (memBuffer.size() > 5) {
                    memBuffer.remove(0);
                }
            }
        }
    }


    public void history() {
        int start = Math.max(0, memBuffer.size() - 5);
        for (int i = memBuffer.size() - 1; i >= start; i--) {
            System.out.println(memBuffer.get(i));
        }
    }

}



