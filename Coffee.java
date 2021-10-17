package machine;

public enum Coffee {

    ESPRESSO(16, 0, 250, 4),
    LATTE(20, 75, 350, 7),
    CAPPUCCINO(12, 100, 200, 6);

    protected int beans;
    protected int milk;
    protected int water;
    protected int price;

    Coffee(int beans, int milk, int water, int price) {
        this.beans = beans;
        this.milk = milk;
        this.water = water;
        this.price = price;
    }

    public int getBeans() {
        return beans;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    public int getPrice() {
        return price;
    }
}
