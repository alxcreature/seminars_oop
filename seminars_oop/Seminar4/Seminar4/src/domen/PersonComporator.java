package domen;

import java.util.Comparator;

/***
 * @apiNote Класс-дженерик для компаратора, расширяемый от базового класа персоны
 */
public class PersonComporator<T extends Person> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
