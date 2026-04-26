package org.example.task0Junior;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Условие задачи 1.4 (Stream API: фильтрация и сумма)
 * Дан список целых чисел. С помощью Stream API:
 * <p>
 * Отфильтровать только положительные числа (больше 0).
 * <p>
 * Каждое положительное число преобразовать в его квадрат.
 * <p>
 * Вычислить сумму полученных квадратов.
 * <p>
 * Напишите метод, который принимает List<Integer> и возвращает int (или long, если сумма может быть большой). Если в списке нет положительных чисел, сумма должна быть 0.
 * <p>
 * Пример:
 * Вход: [1, -2, 3, -4, 5]
 * Положительные: 1, 3, 5 → квадраты: 1, 9, 25 → сумма: 35.
 **/


public class StreamAPIExt {

    public int sumOfPositiveSquares(ArrayList<Integer> list) {
        return list
                .stream()
                .filter(c -> c > 0)
                .map(c -> c * c)
                .mapToInt(Integer::intValue)
                .sum();

    }


    /*
Задача S1. Фильтрация строк по длине
Дан список строк. Оставить только те, длина которых больше 3 символов, перевести их в верхний регистр, собрать в новый список.
["cat", "elephant", "dog", "hippopotamus"] → ["ELEPHANT", "HIPPOPOTAMUS"]
 */

    public ArrayList<String> lengthSorter(ArrayList<String> incomingList) {
        return incomingList
                .stream()
                .filter(c -> c.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    /*
  Задача S2. Среднее значение списка
  Дан список целых чисел. Найти среднее арифметическое (как double) с помощью Stream API. Если список пуст — вернуть 0.0.
  [1, 2, 3, 4] → 2.5
   */
    public double arithmeticMean(ArrayList<Double> incomingList) {
        if (incomingList.isEmpty()) {
            return 0.0;
        }
        return (incomingList
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum()
                / incomingList.size());

    }

      /*
 Задача S3. Максимальный элемент по остатку от деления
Дан список целых чисел и число n. Найти максимальный элемент, который при делении на n даёт остаток 0 (т.е. кратен n). Если таких нет — вернуть null. Использовать стримы.
[10, 15, 20, 25], n=5 → 25
[10, 15, 20, 25], n=7 → null
   */

    public Optional<Integer> maxDivider(ArrayList<Integer> incomingList, int divider) {
        if (incomingList == null || divider == 0) return Optional.empty();
        return incomingList
                .stream()
                .filter(c -> c % divider == 0)
                .max(Integer::compareTo);
    }

      /*
 Условие задачи S4 (Преобразование в Map: имя → длина)
Дан список строк. Создать Map<String, Integer>, где:
ключ — сама строка
значение — её длина (количество символов)
Пример:
Вход: ["apple", "banana", "cherry"]
Выход: {apple=5, banana=6, cherry=6}
   */

    public Map<String, Integer> nameToNameSizeMapper(List<String> incomingStrings) throws NullPointerException {
        if (incomingStrings == null) throw new NullPointerException("Incoming list is null");
        Map<String, Integer> outputMap = new HashMap<>();
        List<String> nonNullList = incomingStrings.stream().filter(Objects::nonNull).collect(Collectors.toList());
        if (nonNullList.size() != incomingStrings.size()) {
            System.out.println("Incoming list contained null elements, which were removed");
        }
        nonNullList.forEach(c -> outputMap.put(c, c.length()));
        return outputMap;
    }

    /*
Условие задачи S5 (Сортировка с пропуском null)
Дан список строк, содержащий возможные значения null.
Требования:
Отфильтровать null (удалить их из потока).
Отсортировать оставшиеся строки в обратном алфавитном порядке (от Z до A, с учётом регистра? обычно достаточно естественного порядка с Comparator.reverseOrder()).
Собрать результат в новый List<String>.
Пример:
Вход: ["b", null, "a", "c", null]
Выход: ["c", "b", "a"]
  */
    public List<String> sortWithoutNulls(List<String> list) {
        return list.stream().
                filter(Objects::nonNull).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
    }


}




