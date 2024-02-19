package interfaces;

import java.util.List;

import classes.Actor;
/***
 * @apiNote Интерфейс методов класса реализации поведения магазина
 */
public interface iMarketBehaviour {
    public void acceptToMarket(iActorBehaviour actor);
    public void releaseFromMarket(List<Actor> actors);
    public void update();
    
}
