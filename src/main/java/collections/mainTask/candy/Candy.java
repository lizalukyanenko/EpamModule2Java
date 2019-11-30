package collections.mainTask.candy;

public abstract class Candy {
    private String name;
    private double price;
    private double weight;
    private double sugarContent;
    private double v;              //объем
    private int count;

    @Override
    public String toString() {
        return "\nCandy\n{" +
                "name: " + name +
                ", price: " + price +
                ", weight: " + weight +
                ", sugarContent: " + sugarContent +
                ", volume: " + v +
                ", count: " + count +
                "}";
    }

    public Candy(String _name, double _price, double _weight, double _sugarContent, double _v, int _count) {
        if (!_name.isEmpty() && _price>0 && _weight>0 && _sugarContent>=0 && _v>0 && _count>0) {
            this.name = _name;
            this.price = _price;
            this.weight = _weight;
            this.sugarContent = _sugarContent;
            this.v = _v;
            this.count = _count;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public double getV() {
        return v;
    }

    public int getCount() {
        return count;
    }

}
