package animals.pets;

import animals.AbsAnimals;
import interfaces.Flying;

public class Duck extends AbsAnimals implements Flying {

    public Duck(String name, String color, Integer weight, Integer age) {
        super(name, color, weight, age);
    }

    public void fly() {
        System.out.println("Я лечу");
    }

}
