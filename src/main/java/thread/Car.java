package thread;

import java.util.Random;

public class Car {
    private int number;
    private int waitTime;
    private int parkingTime;

    public int getParkingTime() {
        return new Random().nextInt(1000);
    }

    public int getWaitTime() {
        return new Random().nextInt(5000);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
