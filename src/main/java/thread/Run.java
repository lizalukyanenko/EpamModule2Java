package thread;

import java.util.Random;

public class Run {
    private static Run instance = new Run();

    public static Run getInstance() {
        return instance;
    }

    private Run() {
    }

    public void running() {
        Parking parking = new Parking(2,1);
        for (int i = 0; i < 5; i++) {
            Car car = new Car();
            parking.carPark(car);
            Main.LOG.info("Автомобиль #" + car.getNumber() + " заехал на парковку");
        }

        parking.getService().shutdown();
        parking.getTimeToLeave().shutdown();
    }
}
