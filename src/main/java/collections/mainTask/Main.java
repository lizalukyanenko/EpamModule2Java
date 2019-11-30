package collections.mainTask;

import collections.mainTask.candy.Candy;
import collections.mainTask.candy.Chocolate;
import collections.mainTask.candy.Jelly;
import collections.mainTask.candy.Lolipop;
import collections.mainTask.createGift.Gift;
import org.apache.log4j.Logger;

import static collections.mainTask.help.Help.*;

public class Main {
    private final static Logger log = Logger.getLogger(Gift.class);
    public static void main(String[] args) {
        Candy type1 = new Lolipop("Lolipop", 10, 37, 2, 12, 1);
        Candy type2 = new Jelly("Jelly", 2, 4, 5, 2, 1);
        Candy type3 = new Chocolate("Chocolate", 12, 20, 3, 2, 1);
        Candy type4 = new Lolipop("MilkyWay", 7, 17, 3, 8, 1);

        Gift gift1 = new Gift();
        gift1.add(type1);
        gift1.add(type2);
        gift1.add(type3);

        log.info(gift1.toString());
        System.out.println("\n------------------------Reverse By Name----------------------------");
        reverseByName(gift1, "Lolipop", type4);
        log.info(gift1.toString());

        System.out.println("\n------------------------Sort By Price------------------------------");
        sortByPrice(gift1);
        log.info(gift1.toString());

        System.out.println("\n------------------------Delete By Name-----------------------------");
        deleteByName(gift1, "Jelly");
        log.info(gift1.toString());

    }
}
