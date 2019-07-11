package ru.dumsky284.Ducks;

import ru.dumsky284.Ducks.Behaviors.FlyNoWay;
import ru.dumsky284.Ducks.Behaviors.FlyRocketPowered;
import ru.dumsky284.Ducks.Behaviors.Squeak;

public class Main {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        Duck woodenDuck = new WoodenDuck();

        System.out.println("------------- MallardDuck test -------------");

        mallardDuck.performFly();
        mallardDuck.performQuack();

        System.out.println("------------- Changing mallard duck's behaviour -------------");

        mallardDuck.setFlyBehavior(new FlyNoWay());
        mallardDuck.setQuackBehavior(new Squeak());

        mallardDuck.performFly();
        mallardDuck.performQuack();

        Duck modelDuck = new ModelDuck();

        System.out.println("------------- modelDuck test -------------");
        modelDuck.performFly();
        System.out.println("------------- Changing model duck's behaviour -------------");
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();



        //woodenDuck.performFly();
        //woodenDuck.performQuack();

    }
}
