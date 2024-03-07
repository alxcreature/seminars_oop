package SRP;
/***
 * @apiNote Абстрактный класс функционала бухгалтерии
 */
public abstract class Account {

    /**
     * Вычисление ЗП
     * @param baseSalary базовая ставка ЗП
     * @return Итог начисления
     */
    public int calculateNetSalary(int baseSalary) {
        int tax = (int) (baseSalary * 0.25);// calculate in otherway
        return baseSalary - tax;
    }
    
}
