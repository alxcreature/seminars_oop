package OCP;
/***
 * @apiNote Класс расчёта допустимой максимальной скорости езды
 */
public class SpeedCalculation {
    public SpeedCalculation(){
    }

    /**
     * Вычисление допустимой скорости езды по типу транспорта
     * @param vehicle Транспорт
     * @return Допустимая максимальная скорость
     */
    public double calculateAllowedSpeed(Vehicle vehicle) {
        if (vehicle.getType().equalsIgnoreCase("Car")) {
            return vehicle.getMaxSpeed() * 0.8;
        } else if (vehicle.getType().equalsIgnoreCase("Bus")) {
            return vehicle.getMaxSpeed() * 0.6;
        }
        return 0.0;
    }
}
