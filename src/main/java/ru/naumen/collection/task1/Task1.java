package ru.naumen.collection.task1;

import ru.naumen.collection.task2.Ticket;

import java.util.*;

/**
 * Дано:
 * <pre>
 * public class User {
 *     private String username;
 *     private String email;
 *     private byte[] passwordHash;
 *     …
 * }
 * </pre>
 * Нужно написать утилитный метод
 * <pre>
 * public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB);
 * </pre>
 * <p>который возвращает дубликаты пользователей, которые есть в обеих коллекциях.</p>
 * <p>Одинаковыми считаем пользователей, у которых совпадают все 3 поля: username,
 * email, passwordHash. Дубликаты внутри коллекций collA, collB можно не учитывать.</p>
 * <p>Метод должен быть оптимален по производительности.</p>
 * <p>Пользоваться можно только стандартными классами Java SE.
 * Коллекции collA, collB изменять запрещено.</p>
 *
 * См. {@link User}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task1 {

    /**
     * Возвращает дубликаты пользователей, которые есть в обеих коллекциях
     *
     *
     * 1) Я выбрал HashSet так как благодаря тому что мы переопределили equals и hashCode теперь операция add и contains работают за О(1).
     * 2) Сложность O(N).
     * 3) Такая сложность, потому что мы 1 раз проходим по коллекции и за O(1) добавляем и сравниваем элементы.
     */

    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        List<User> dupl = new ArrayList<>();
        Set <User> setB = new HashSet<>(collB);
        for(User user : collA){
            if(setB.contains(user))
                dupl.add(user);
        }
        return dupl;
    }
}
