package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Line {
    private Lock lock = new ReentrantLock();
    private Place place;

    public Line(Place place) {
        this.place = place;
        place.setLock(lock);
    }

    public boolean parking (Car car){
        if(lock.tryLock()){
            place.takePlace(car);
            return true;
        } else {
            return false;
        }
    }

}
