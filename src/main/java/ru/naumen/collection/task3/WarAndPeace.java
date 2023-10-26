package ru.naumen.collection.task3;

import java.nio.file.Path;
import java.util.HashMap;

/**
 * <p>Написать консольное приложение, которое принимает на вход произвольный текстовый файл в формате txt.
 * Нужно собрать все встречающийся слова и посчитать для каждого из них количество раз, сколько слово встретилось.
 * Морфологию не учитываем.</p>
 * <p>Вывести на экран наиболее используемые (TOP) 10 слов и наименее используемые (LAST) 10 слов</p>
 * <p>Проверить работу на романе Льва Толстого “Война и мир”</p>
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class WarAndPeace {

    private static final Path WAR_AND_PEACE_FILE_PATH = Path.of("src/main/resources",
            "Лев_Толстой_Война_и_мир_Том_1,_2,_3,_4_(UTF-8).txt");



    public static void main(String[] args) {

        Map<String, Integer> count = new HashMap<>();
        new WordParser(WAR_AND_PEACE_FILE_PATH).forEachWord(word -> {
            count.put(word, count.getOrDefault(word, 0) + 1);
        });
        Queue<String> pqTop = new PriorityQueue<>((w1, w2) -> count.get(w2) - count.get(w1));
        Queue<String> pqLast = new PriorityQueue<>(Comparator.comparingInt(count::get));
        for (String word : count.keySet()) {
            pqTop.offer(word);
            pqLast.offer(word);
        }
        System.err.println("Первые 10");
        for (int i = 0; i < 10; i++) {
            String word = pqTop.poll();
            System.err.println(word + " " + count.get(word));
        }

        System.err.println(" Последние 10");
        for (int i = 0; i < 10; i++) {
            String word = pqLast.poll();
            System.err.println(word + " " + count.get(word));
        }
    }
}
