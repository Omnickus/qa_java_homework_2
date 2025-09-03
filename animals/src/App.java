import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import animals.AbsAnimals;
import data.AnimalsTypeData;
import data.CommandsData;
import data.ColorData;
import factory.AnimalsFactory;
import tools.NumbersTools;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Добро пожаловать в супер программу!");
        List<AbsAnimals> animals = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("=====Введите одну из комманд=====");
            System.out.printf("%s" + "\n", String.join(" | ", getEnumCommandNames()));
            String userCommand = scanner.next().toLowerCase().trim().toString();
            boolean isCommandExist = false;
            for (CommandsData command : CommandsData.values()) {
                if (command.name().toLowerCase().trim().equals(userCommand)) {
                    isCommandExist = true;
                    break;
                }
            }

            if (!isCommandExist) {
                System.out.println("Вы ввели неверную команду");
                continue;
            }

            if (userCommand.equals("exit")) {
                System.out.println("Вы вышли. Счастливо!");
                loop = false;
                System.exit(0);
            }

            if (userCommand.equals("add")) {
                // Фабрика животных
                AnimalsFactory new_animal = new AnimalsFactory();
                // Установка типа животного
                System.out.printf("Введите тип животного: %s\n", String.join(" | ", getEnumAnimalTypeNames()));
                String animalType = scanner.next().toLowerCase().trim();
                if ( !getEnumAnimalTypeNames().contains(animalType) ) {
                    System.out.println("Такого животного не существует. Попробуйте ещё раз!");
                    continue;
                }
                System.out.printf("Вы выбрали - %s\n", animalType);
                // Создание экземпляра животного
                AbsAnimals animal = new_animal.create(AnimalsTypeData.valueOf(animalType));

                // Установка имени животного
                System.out.println("Введите имя животного");
                animal.setName(scanner.next());
                System.out.printf("Имя животного - %s\n", animal.getName());

                // Установка возраста животного
                System.out.println("Введите возраст животного. Целое число.");
                String user_age = scanner.next().toString().trim();
                boolean isIntAge = NumbersTools.isNumber(user_age);
                if ( !isIntAge ) {
                    System.out.printf("Такого возрасты \"%s\" быть не может. Попробуйте ещё раз!\n", user_age);
                    continue;
                }
                animal.setAge(Integer.parseInt(user_age));
                System.out.printf("Возраст животного - %s\n", animal.getAge());

                // Установка веса животного
                System.out.println("Введите вес животного. Целое число.");
                String user_weight = scanner.next().toString().trim();
                boolean isIntWeight = NumbersTools.isNumber(user_weight);
                if ( !isIntWeight ) {
                    System.out.printf("Такого веса \"%s\" быть не может. Попробуйте ещё раз!\n", user_age);
                    continue;
                }
                animal.setWeight(Integer.parseInt(user_weight));
                System.out.printf("Вес животного - %s\n", animal.getWeight());

                // Установка цвета
                System.out.printf("Выберите цвет животного: %s\n", String.join(" | ", getEnumAnimalColorsNames()));
                String animalColor = scanner.next().toLowerCase().trim();
                if ( !getEnumAnimalColorsNames().contains(animalColor) ) {
                    System.out.printf("Такого цвета \"%s\" нет в предложенных вариантах. Попробуйте ещё раз!", animalColor);
                    continue;
                }
                System.out.println(ColorData.valueOf(animalColor.toUpperCase()));
                animal.setColor(ColorData.valueOf(animalColor.toUpperCase()).getName());
                System.out.printf("Вы выбрали цвет - %s\n", ColorData.valueOf(animalColor.toUpperCase()).getName());

                // Добавление животного в список созданных животных
                animals.add(animal);
                System.out.printf("Вы создали:\n%s\n", animal.toString());

            }

            if (userCommand.equals("list")) {
                if (animals.size() == 0) {
                    System.out.println("Вы ещё не создали ни одного животного");
                }
                System.out.println("Список созданных животных");
                for (AbsAnimals animal : animals) {
                    System.out.println(animal.toString());
                }
            }
        }
        scanner.close();
        
    }

    public static List<String> getEnumCommandNames() {
        List<String> commandNames = new ArrayList<>();
        for (CommandsData command : CommandsData.values()) {
            commandNames.add(command.name().toLowerCase());
        }
        return commandNames;
    }

    public static List<String> getEnumAnimalTypeNames() {
        List<String> names = new ArrayList<>();
        for (AnimalsTypeData type : AnimalsTypeData.values()) {
            names.add(type.name().toLowerCase().trim());
        }
        return names;
    }

    public static List<String> getEnumAnimalColorsNames() {
        List<String> names = new ArrayList<>();
        for (ColorData type : ColorData.values()) {
            names.add(type.name().toLowerCase().trim());
        }
        return names;
    }
}
