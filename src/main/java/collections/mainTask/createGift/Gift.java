package collections.mainTask.createGift;

import collections.mainTask.candy.Candy;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Gift {
    private static final Logger log = Logger.getLogger(Gift.class);

    private final double volume = 50;
    private final int weight = 100;
    private List<Candy> candies = new ArrayList<Candy>();

    //get the final price of the gift
    public double priceGift() {
        double price = 0;
        for (int i = 0; i < candies.size(); i++) {
            price += candies.get(i).getCount() * candies.get(i).getPrice();
        }
        return price;
    }

    //get the final weight of the gift
    public double weightGift() {
        double weightNow = 0;
        for (int i = 0; i < candies.size(); i++) {
            weightNow += candies.get(i).getCount() * candies.get(i).getWeight();
        }
        return weightNow;
    }

    //get the final count of candy in the gift
    public int countOfGift() {
        int count = 0;
        for (int i = 0; i < candies.size(); i++) {
            count += candies.get(i).getCount();
        }
        return count;
    }

    //get the final volume of candy in the gift
    public double volumeGift() {
        double v = 0;
        for (int i = 0; i < candies.size(); i++) {
            v += candies.get(i).getV();
        }
        return v;
    }

    //add candy in the gift
    public void add(Candy candy) {
        try {
            if (volumeGift() + candy.getV() <= volume && weightGift() + candy.getWeight() <= weight) {      //checking whether the candy does not exceed the volume and weight of the gift itself
                candies.add(candy);
            } else {
                log.error("Unreal add candy " +candy.getName() + "!");
            }
        }catch (NullPointerException e){
            log.error("Something failed: " + e.getMessage());
        }
    }

    public int getSize() {                                  //get size of ArrayList "candies"
        return candies.size();
    }

    public Candy getObject(int i) {                         //get object in ArrayList by ID
        return candies.get(i);
    }

    public List<Candy> getCandies() {                       //get ArrayList object
        return candies;
    }

    @Override
    public String toString() {
        return "Gift\n{" +
                "price: " + priceGift() +
                ", weight: " + weightGift() +
                ", volume: " + volumeGift() +
                ", count candies in the gift: " + countOfGift() +
                "}"+candies.toString();
    }
}
