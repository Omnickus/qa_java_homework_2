package factory;

import animals.AbsAnimals;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.pets.Duck;
import data.AnimalsTypeData;

public class AnimalsFactory {

    public AbsAnimals create(AnimalsTypeData AnimalsTypeData) {
        switch (AnimalsTypeData) {
            case cat:
                return new Cat(null, null, null, null);
            case dog:
                return new Dog(null, null, null, null);
            case duck:
                return new Duck(null, null, null, null);
        }

        return null;
    }

}
