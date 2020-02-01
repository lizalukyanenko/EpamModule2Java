package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parking {
    private Lock lock = new ReentrantLock();
    private Queue<Car> carQueue;
    private List<Line> lines;
    private int lineQuantity;
    private ExecutorService service;
    private AtomicInteger count;
    ScheduledExecutorService timeToLeave = Executors.newScheduledThreadPool(10);

    public Parking(int numberOfCar, int lineQuantity) {
        carQueue = new ArrayBlockingQueue(numberOfCar);
        lines = new ArrayList();
        this.lineQuantity = lineQuantity;
        service = Executors.newFixedThreadPool(lineQuantity + 1);
        this.count = new AtomicInteger(0);
        for (int i = 0; i < lineQuantity; i++) {
            Line line = initializeLine();
            this.lines.add(line);
        }

    }

    public void carPark(Car car) {
        car.setNumber(count.incrementAndGet());
        service.submit(() -> process(car));
    }

    public ExecutorService getService() {
        return service;
    }

    public ScheduledExecutorService getTimeToLeave() {
        return timeToLeave;
    }

    public Queue<Car> getCar() {
        return carQueue;
    }

    private Line initializeLine() {
        Place place = new Place(10 + new Random().nextInt(5));
        Line line = new Line(place);
        place.setCarQueue(this.carQueue);
        return line;
    }

    private void process(Car car) {
        if (this.carQueue.isEmpty()) {
            boolean isOn = false;
            for (Line line : lines) {
                if (line.parking(car)) {
                    isOn = true;
                    break;
                }
            }
            if (!isOn) {
                queueCar(car);
            }
        } else {
            queueCar(car);
        }
    }

    private void queueCar(Car car) {
        boolean isAdded = false;
        try {
            isAdded = this.carQueue.add(car);
        } catch (Exception ex) {
            Main.LOG.info("Автомобиль #" + car.getNumber() + " не был припаркован и уехал. Очередь переполнена!");
        }
        if (isAdded) {
            timeToLeave.schedule(() -> leaveQueue(car), car.getWaitTime(), TimeUnit.MILLISECONDS);
            Main.LOG.info("Автомобиль #" + car.getNumber() + " добавлен в очередь на ожидание парковочного места");
        }
    }

    private void leaveQueue(Car car){
        lock.lock();
        if(carQueue.contains(car)){
            carQueue.remove(car);
            Main.LOG.info("Автомобиль #" + car.getNumber() + " не был припаркован и уехал. Не хочет снова пробовать припарковаться, время истекло!");
            tryAgain(car);
        }
        lock.unlock();
    }

    private void tryAgain(Car car){
        boolean isWant2TryAgain = new Random().nextBoolean();
        if(isWant2TryAgain){
            if(carQueue.add(car)){
                Main.LOG.info("Автомобиль #" + car.getNumber() + " не был припаркован и хочет попробовать припарковаться снова");
            }
        }
    }
}
