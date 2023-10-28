package ru.naumen.collection.task2;

import java.util.HashMap;
import java.util.Map;

/**
 * Дано:
 * <pre>
 * public class Ticket {
 *     private long id;
 *     private String client;
 *     …
 * }</pre>
 * <p>Разработать программу для бармена в холле огромного концертного зала.
 * Зрители в кассе покупают билет (класс Ticket), на котором указан идентификатор билета (id) и имя зрителя.
 * При этом, есть возможность докупить наборы разных товаров (комбо-обед): нет товаров, напитки, еда и напитки.
 * Доп. услуги оформляются через интернет и привязываются к билету, но хранятся отдельно от билета
 * (нельзя добавить товары в класс Ticket).</p>
 * <p>Бармен сканирует билет и получает объект Ticket. По этому объекту нужно уметь
 * находить необходимые товары по номеру билета. И делать это нужно очень быстро,
 * ведь нужно как можно быстрее всех накормить.</p>
 * <p>
 * См. {@link Ticket}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 *
 *
 * 1) Я выбрал HashMap потому что благодаря тому что мы переопределили equals и hashCode теперь операция put и get работают за О(1),
 * а также можно удобно хранить пару Ticket(ключ) food(значение).
 * 2) Сложность O(1).
 * 3) Такая сложность, потому что операции put и add выполняются за константу.
 */
public class Task2 {

    Map<Ticket, String> combos = new HashMap<>();

    public void buyingFood(String food, Ticket ticket){
        combos.put(ticket, food);
    }

    public String getProduct(Ticket ticket){
        return combos.get(ticket);
    }
}
