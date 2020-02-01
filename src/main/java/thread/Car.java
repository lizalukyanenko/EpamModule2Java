package thread;

import java.util.Random;

public class Car {
    private int number;
    private int waitTime;
    private int parkingTime;

    public int getParkingTime() {
        return new Random().nextInt(1000);
//                (int)(Math.random()*10000);
    }

    public int getWaitTime() {
        return (int)(Math.random()*5000);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
