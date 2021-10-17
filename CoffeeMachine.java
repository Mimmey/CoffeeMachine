package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static Scanner scanner;
    public static Machine machine;

    public static void makeCoffee(Coffee coffee) {
        EnoughOrNot enoughOrNot = machine.makeCoffee(coffee);

        switch (enoughOrNot){
            case WATER:
                System.out.println("Sorry, not enough water!");
                break;
            case MILK:
                System.out.println("Sorry, not enough milk!");
                break;
            case BEANS:
                System.out.println("Sorry, not enough coffee beans!");
                break;
            case CUPS:
                System.out.println("Sorry, not enough disposable cups!");
                break;
            case NONE:
                System.out.println("I have enough resources, making you a coffee!");
                break;
        }
    }

    public static void runBuy() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        int choice;

        try{
            choice = scanner.nextInt();
        }catch (Exception e){
            return;
        }

        Coffee coffee;

        switch (choice) {
            case 1:
                coffee = Coffee.ESPRESSO;
                break;
            case 2:
                coffee = Coffee.LATTE;
                break;
            default:
                coffee = Coffee.CAPPUCCINO;
                break;
        }

        scanner.nextLine();
        makeCoffee(coffee);
    }

    public static void runFill() {
        System.out.println();
        System.out.println("Write how many ml of water do you want to add: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int cups = scanner.nextInt();
        machine.runFill(water, milk, beans, cups);
        scanner.nextLine();
    }

    public static void runTake() {
        System.out.println();
        System.out.printf("I gave you $%d%n", machine.getMoney());
        machine.runTake();
    }

    public static void runRemaining() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water%n", machine.getWater());
        System.out.printf("%d of milk%n", machine.getMilk());
        System.out.printf("%d of coffee beans%n", machine.getBeans());
        System.out.printf("%d of disposable cups%n", machine.getCups());
        System.out.printf("$%d of money%n", machine.getMoney());
    }

    public static void runMenu() {
        String choice;

        do{
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            choice = scanner.nextLine();

            switch (choice) {
                case "buy":
                    runBuy();
                    break;
                case "fill":
                    runFill();
                    break;
                case "take":
                    runTake();
                    break;
                case "remaining":
                    runRemaining();
                    break;
                default:
                    break;
            }
        }while(!choice.equals("exit"));
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        machine = new Machine();
        runMenu();
    }
}
