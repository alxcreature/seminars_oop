package classes;

import java.util.ArrayList;
import java.util.List;

import interfaces.iActorBehaviour;
import interfaces.iMarketBehaviour;
import interfaces.iQueueBehaviour;
import interfaces.iReturnOrder;

/***
 * @apiNote Класс экземпляра магазина и процесс работы с покупателями
 * 
 */
public class Market implements iMarketBehaviour,iQueueBehaviour,iReturnOrder{
    private List<iActorBehaviour> queue;
    private int stockMaxClients;
    private int stockCounter;

    /**
     * @apiNote Метод получения максимального количества участников акций
     * @return Максимальное количество участников акций
     */
    public int getStockMaxClients() {
        return stockMaxClients;
    }

    /**
     * @apiNote Метод установки максимального количества участников в акциях
     * @param stockMaxClients Установка максимального количества участников участвующих в акциях
     */
    public void setStockMaxClients(int stockMaxClients) {
        this.stockMaxClients = stockMaxClients;
    }

    /**
     * @apiNote Конструктор магазина и первичная инициализация некоторых полей данных
     */
    public Market() {
        this.queue = new ArrayList<iActorBehaviour>();
        stockCounter=0;
        stockMaxClients=0;

    }
    
    /***
    * @apiNote Метод обрабоки события входа покупателя в магазин
    */
    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        System.out.println(actor.getActor().getName() + " клиент пришел в магазин ");
        takeInQueue(actor);
    }

    /***
     * @apiNote Постановка покупателя в очередь участников дальнейших событий в
     *          магазине
     */
    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        System.out.println(actor.getActor().getName() + " клиент добавлен в очередь ");
    }

    /***
     * @apiNote Высвобождения покупателя из очереди событий
     */
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " клиент ушел из магазина ");
            queue.remove(actor);
        }

    }

    /***
     * @apiNote Запуск имитации цепочек событий
     */
    @Override
    public void update() {
        takeOrder();
        giveOrder();
        returnOrder();
        releaseFromQueue();
    }

    /***
     * @apiNote События выдачи заказов
     */
    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getActor().getName() + " клиент получил свой заказ ");
            }
        }
    }

    /***
     * @apiNote События высвобождения из очеди покупателей
     */
    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.getActor());
                System.out.println(actor.getActor().getName() + " клиент ушел из очереди ");
            }
        }
        releaseFromMarket(releaseActors);
    }

    /***
    *@apiNote События оформления заказов
    */
    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getActor().getName() + " клиент сделал заказ ");

            }
            //Проверка принадлежности участника акций + проверка на отказ покупателя от заказа
            if (actor instanceof StockClient && !actor.getActor().isReturnOrder) {
                ((StockClient)actor).stockCounter++; //Увеличиваем счётчик участников акций
                System.out.println(actor.getActor().getName() + " клиент ID=" + ((StockClient) actor).getIdStockClient()
                        + ", участвует в акции: \"" + ((StockClient) actor).getStockName() + "\", количество участников в акциях: " + stockCounter);
                //Отказ в оформлении и выдаче заказа в качестве участника акций
                if (stockCounter > stockMaxClients){
                    //actor.setMakeOrder(false);
                    System.out.println(actor.getActor().getName() + " клиенту отказано в оформлении заказа, из-за превышения максимального количества участников в акциях: " + stockMaxClients);
                }
            }

        }

    }

    /***
     * @apiNote Обработка события отказа клиента от заказа
     */
    @Override
    public void returnOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isReturnOrder())  {
                //actor.setTakeOrder(false);
                //actor.setMakeOrder(false);
                System.out.println(actor.getActor().getName() + " клиент отказался от заказа");
                if (stockCounter > 0) stockCounter--;
            }
        }
    }

    
}
