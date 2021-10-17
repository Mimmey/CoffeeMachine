package machine;

public class Machine {
    private int beans;
    private int cups;
    private int milk;
    private int money;
    private int water;

    public Machine(){
        beans = 120;
        cups = 9;
        milk = 540;
        money = 550;
        water = 400;
    }

    public int getBeans() {
        return beans;
    }

    public int getCups() {
        return cups;
    }

    public int getMilk() {
        return milk;
    }

    public int getMoney() {
        return money;
    }

    public int getWater() {
        return water;
    }

    public void addWater(int water) {
        this.water += water;
    }

    public void addBeans(int beans) {
        this.beans += beans;
    }

    public void addCups(int cups) {
        this.cups += cups;
    }

    public void addMilk(int milk) {
        this.milk += milk;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void removeBeans(int beans) {
        this.beans -= beans;
    }

    public void removeCups(int cups) {
        this.cups -= cups;
    }

    public void removeMilk(int milk) {
        this.milk -= milk;
    }

    public void removeWater(int water) {
        this.water -= water;
    }

    public void removeAllMoney(){
        this.money = 0;
    }

    public EnoughOrNot makeCoffee(Coffee coffee){
        if (coffee.getWater() > this.water) {
            return EnoughOrNot.WATER;
        } else if (coffee.getMilk() > this.milk) {
            return EnoughOrNot.MILK;
        } else if (coffee.getBeans() > this.beans) {
            return EnoughOrNot.BEANS;
        } else if (1 > this.cups) {
            return EnoughOrNot.CUPS;
        } else {
            this.removeBeans(coffee.getBeans());
            this.removeCups(1);
            this.removeMilk(coffee.getMilk());
            this.addMoney(coffee.getPrice());
            this.removeWater(coffee.getWater());
            return EnoughOrNot.NONE;
        }
    }

    public void runFill(int water, int milk, int beans, int cups){
        this.addWater(water);
        this.addCups(cups);
        this.addMilk(milk);
        this.addBeans(beans);
    }

    public void runTake(){
        this.removeAllMoney();
    }

}
