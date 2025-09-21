package factory;

import animals.AbsAnimals;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.pets.Duck;
import data.AnimalsTypeData;

public class AnimalsFactory {

    public AbsAnimals create(AnimalsTypeData AnimalsTypeData, String name, String color, Integer weight, Integer age ) {
        switch (AnimalsTypeData) {
            case cat:
                return new Cat(name, color, weight, age);
            case dog:
                return new Dog(name, color, weight, age);
            case duck:
                return new Duck(name, color, weight, age);
        }

        return null;
    }

}
