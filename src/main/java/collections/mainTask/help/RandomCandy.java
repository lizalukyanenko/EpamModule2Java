package collections.mainTask.help;

import collections.mainTask.candy.Candy;
import collections.mainTask.candy.Chocolate;
import collections.mainTask.candy.Jelly;
import collections.mainTask.candy.Lolipop;

import java.util.Random;

public class RandomCandy {
    Candy candy;
    final Random rnd = new Random();

    public Candy createRandomCandy(){
        double random = new Random().nextDouble();
        String name = NameCandy.values()[rnd.nextInt((10-0)+1)+0].toString();
        double price = 1+(10-1)*rnd.nextDouble();
        double weight = 1 + (random * (10 - 1));
        double sugarContent = 1 + (random * (10 - 1));
        double v = 1 + (random * (10 - 1));
        int count = rnd.nextInt((10-1)+1)+1;
        return candy = randomTypeCandy(name,price,weight,sugarContent,v,count);
    }

    private Candy randomTypeCandy(String name, double price, double weight, double sugarContent, double v, int count){
        int type = rnd.nextInt((3-1)+1)+1;
        switch (type){
            case 1: return candy = new Chocolate(name,price,weight,sugarContent,v,count);
            case 2: return candy = new Lolipop(name,price,weight,sugarContent,v,count);
            case 3: return candy = new Jelly(name,price,weight,sugarContent,v,count);
            default: throw new NullPointerException("Error");
        }
    }
}
