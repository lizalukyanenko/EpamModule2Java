package collections.mainTask.help;
import collections.mainTask.candy.Candy;
import collections.mainTask.createGift.Gift;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Help {
    private final static Logger logHelp = Logger.getLogger(Gift.class);

    //sort an entry in the List by price
    public static void sortByPrice(Gift gift) {
        Collections.sort(gift.getCandies(), new Comparator<Candy>() {
            public int compare(Candy o1, Candy o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
    }

    //delete an entry in the List by name
    public static void deleteByName(Gift gift, final String name) {
        gift.getCandies().removeIf(x -> x.getName() == name);
    }

    //search an entry in the List by name and reverse
    public static void reverseByName(Gift gift, String name, Candy candy) {
        for (int i = 0; i < gift.getCandies().size(); i++) {
            if (gift.getObject(i).getName().contains(name)) {
                gift.getCandies().set(i, candy);
            }
        }
    }

    //search an entry in the List by sugar content
    public static List<Candy> searchBySugarContent(int min, int max, Gift gift) {
        List<Candy> listOutSearch = new ArrayList<Candy>();
        if (min >= 0 && max >= 1 && min<max) {
            for (Candy candy : gift.getCandies()) {
                if (candy.getSugarContent() > min && candy.getSugarContent() < max) {
                    listOutSearch.add(candy);
                }
            }
        } else {
            logHelp.error("Incorrectly specified minimum and maximum parameters!");
            throw new IllegalArgumentException("Incorrectly specified minimum and maximum parameters!");
        }
        return listOutSearch;
    }
}
