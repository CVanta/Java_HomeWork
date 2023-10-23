package ru.naumen.collection.task2;

/**
 * Билет
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Ticket {
    private long id;
    private String client;

    public long get_id(){
        return id;
    }

    public String get_client(){
        return client;
    }

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Ticket that = (Ticket) object;
        return this.client.equals(that.client) && (this.id == that.id);
    }



    @Override
    public int hashCode(){
        return Long.hashCode(get_id());
    }
}
