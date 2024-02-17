package services;

import java.util.ArrayList;
import java.util.List;

import domen.Places;

public class Holder {
    private List<Places> places;

    /***
     * @apiNote Конструктор товарных полок и рядов
     * @param xSize количество рядов на одной полке
     * @param ySize количество полок
     */
    public Holder(int xSize, int ySize){
        places = new ArrayList<>(xSize*ySize);
        for(int x = 0; x < xSize; x++){
            for(int y = 0; y < ySize; y++){
                places.add(new Places(x, y));
            }
        }
    }

   /***
    * @apiNote Функция высвобождения товара
    * @param x номер товарного ряда
    * @param y номер полки по вертикали
    * @return успех/неудачно
    */ 
    public boolean release(int x, int y){
        return places.stream().filter(place -> place.getCol() == x && place.getRow() == y)
                .findFirst().get().setEmpty(true);
    }

/***
 * @apiNote Метод возвращает товарный остаток в рядах на полках
 * @return Общее количество наличия товаров
 */    public int getBalance() {
        return 0;
    }
    
}
