package classes;

/***
 * @apiNote Класс покупателя участвующего в акциях
 */
public class StockClient extends Actor {
    static int stockCounter; //Счётчик участников в акциях
    private int idStockClient; //Уникальный идентификатор участника
    private String stockName; //Название акции

    static {
        stockCounter = 0;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public StockClient(String name, int idStockClient, String stockName) {
        super(name);
        stockCounter++; //Увеличение счётчика участников в акциях в конструкторе класса
        isReturnOrder = false;
        this.idStockClient = idStockClient;
        //Исключаем пустое или неназначенное имя акции
        if (stockName == null || stockName == "")
            stockName = "Undefined";
        this.stockName = stockName;
    }

    public static int getStockCount() {
        return stockCounter;
    }

    public int getIdStockClient() {
        return idStockClient;
    }

    public void setIdStockClient(int idStockClient) {
        this.idStockClient = idStockClient;
    }

    @Override
    public Actor getActor() {
        return this;
    }

    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        // if (!isReturnOrder && isTakeOrder) {
        // System.out.println(super.name + " клиент ID=" + this.idStockClient
        //         + ", участвует в акции: \"" + stockName + "\", количество участников в акции: " + stockCounter);
        // }
        return super.isTakeOrder;
    }

    @Override
    public void setMakeOrder(boolean val) {
        super.isMakeOrder=val;
    }

    @Override
    public void setTakeOrder(boolean val) {
        super.isTakeOrder=val;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    public boolean isReturnOrder() {
        return super.isReturnOrder;
    }

    //Метод устанавливает флаг возврата/отказа покупателя от заказа
    public void setReturnOrder(boolean val) {
        super.isReturnOrder = val;
        //Корректируем количество участников в акциях в случае отказа клиентом и если клиент передумал отказываться
        if (val) {
            stockCounter--;
        } else {
            stockCounter++;
        }
    }

    @Override
    public void returnOrder() {
        //super.isTakeOrder = false;
        //super.isMakeOrder = false;
        //super.isReturnOrder = true;
        
    }

}
