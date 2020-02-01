package thread;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Place {
    private Lock lock;
    private Queue<Car> carQueue;
    private int numberOfCar;

    public void takePlace(Car car){
        while ((car != null) && (numberOfCar > 0)) {
            try {
                Thread.sleep(car.getParkingTime());
                Main.LOG.info("Автомобиль #" + car.getNumber() + " освободил парковочное место");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            car = null;
            numberOfCar--;
            if (numberOfCar > 0) {
                car = carQueue.poll();
                if (car != null) {
                    Main.LOG.info("Автомобиль #" + car.getNumber() + " припарковался");
                }
            }
        }
        if ((car == null) && (this.numberOfCar > 0)) {
            lock.unlock();
        }
    }

    public Place(int numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public Lock getLock() {
        return lock;
    }

    public Queue<Car> getCarQueue() {
        return carQueue;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public void setCarQueue(Queue<Car> carQueue) {
        this.carQueue = carQueue;
    }
}
