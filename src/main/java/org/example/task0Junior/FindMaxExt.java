package org.example.task0Junior;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class FindMaxExt {
    /**
     * Условие задачи 1.3 (Поиск двух максимальных элементов)
     * Дан массив целых чисел (не отсортирован). Найдите два наибольших различных элемента за один проход по массиву (без сортировки). Если все элементы одинаковые – вернуть этот элемент и null.
     * Примеры:
     * [3, 7, 2, 7, 5] → (7, 5)
     * [4, 4, 4, 4] → (4, null)
     */

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
        int buf1 = Integer.MIN_VALUE;
        int buf2 = Integer.MIN_VALUE;
        for (Integer integer : list) {
            if (buf1 < integer) {
                buf2 = buf1;
                buf1 = integer;
            } else if (integer > buf2 && integer != buf1) {
                buf2 = integer;
            }
        }
        if (buf1 == buf2) {
            System.out.println(buf1 + " null");
        } else {
            System.out.println(buf1 + " " + buf2);
        }
    }
}
