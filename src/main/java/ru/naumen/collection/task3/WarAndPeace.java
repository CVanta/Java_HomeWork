package ru.naumen.collection.task3;

import java.nio.file.Path;
import java.util.*;

/**
 * <p>Написать консольное приложение, которое принимает на вход произвольный текстовый файл в формате txt.
 * Нужно собрать все встречающийся слова и посчитать для каждого из них количество раз, сколько слово встретилось.
 * Морфологию не учитываем.</p>
 * <p>Вывести на экран наиболее используемые (TOP) 10 слов и наименее используемые (LAST) 10 слов</p>
 * <p>Проверить работу на романе Льва Толстого “Война и мир”</p>
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 *
 *
 *
 * 1) Я выбрал HashMap потому что добавление и поиск выполняются за O(1). PriorityQueue потому что элементы автоматически
 * упорядочиваются по своему естественному порядку или по компаратору, предоставляемому при инициализации PriorityQueue.
 * Добавление в PriorityQueue работает за O(logN)
 * 2) Сложность (NlogN)
 * 3) Мы получили такую сложность, потому что мы проходим по всем словам и записываем их в Hashmap(сложность O(N)), так как запись в HashMap O(1).
 * Затем мы добовляем в очередь, сложность O(logN). В итоге получаем O(NlogN)
 *
 */
public class WarAndPeace {

    private static final Path WAR_AND_PEACE_FILE_PATH = Path.of("src/main/resources",
            "Лев_Толстой_Война_и_мир_Том_1,_2,_3,_4_(UTF-8).txt");



    public static void main(String[] args) {

        Map<String, Integer> count = new HashMap<>();
        new WordParser(WAR_AND_PEACE_FILE_PATH).forEachWord(word -> {
            count.put(word, count.getOrDefault(word, 0) + 1);
        });
        Queue<String> first = new PriorityQueue<>((w1, w2) -> count.get(w2) - count.get(w1));
        Queue<String> last = new PriorityQueue<>(Comparator.comparingInt(count::get));
        for (String word : count.keySet()) {
            first.offer(word);
            last.offer(word);
        }

        printResult(first, count, "Первые 10");
        printResult(last, count, "Последние 10");

    }

    public static void printResult(Queue<String> element, Map<String, Integer> count, String str){
        System.err.println(str);
        for (int i = 0; i < 10; i++) {
            String word = element.poll();
            System.err.println(word + " " + count.get(word));
        }
    }
}
