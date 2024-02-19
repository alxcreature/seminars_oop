package interfaces;

import classes.Actor;

/***
 * @apiNote Интерфейс реализации методов поведения покупателя в магазине
 */
public interface iActorBehaviour {
    public boolean isTakeOrder();
    public boolean isMakeOrder();
    public void setTakeOrder(boolean val); 
    public void setMakeOrder(boolean val); 
    public Actor getActor(); 
    public boolean isReturnOrder();
    public void setReturnOrder(boolean val);
}

