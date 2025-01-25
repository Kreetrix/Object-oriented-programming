package Task3;

public class CoffeeMakerDriver {

    public static void main(String[] args) {
        CoffeeMaker coffeeMaker;

        coffeeMaker = new CoffeeMaker(10);

        coffeeMaker.switchStatus();
        System.out.printf("Coffee maker is %s\n", coffeeMaker.getStatus() ? "on" : "off");
        if (coffeeMaker.getStatus()) {
            coffeeMaker.changeType(CoffeeMaker.CoffeeType.ESPRESSO);
            System.out.println("Coffee type is " + coffeeMaker.currentType());
            coffeeMaker.changeAmount(80);
            System.out.printf("Coffee amount is %d ml\n", coffeeMaker.currentAmount());
            coffeeMaker.switchStatus();
            System.out.printf("Coffee maker is %s\n", coffeeMaker.getStatus() ? "on" : "off");
        }
    }

}
