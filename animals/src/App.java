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

        try {
            while (true) {
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
                    System.exit(0);
                }

                if (userCommand.equals("add")) {
                    // Установка типа животного
                    String animalType;
                    while (true) {
                        System.out.printf("Введите тип животного: %s\n", String.join(" | ", getEnumAnimalTypeNames()));
                        animalType = scanner.next().toLowerCase().trim();
                        if (animalType.equals("exit")) {
                            System.out.println("Вы вышли. Счастливо!");
                            System.exit(0);
                        }
                        if (!getEnumAnimalTypeNames().contains(animalType)) {
                            System.out.println("Такого животного не существует. Попробуйте ещё раз!");
                            continue;
                        }
                        break;
                    }
                    System.out.printf("Вы выбрали - %s\n", animalType);

                    // Установка имени животного
                    String animalName;
                    while (true) {
                        System.out.println("Введите имя животного");
                        animalName = scanner.next().trim();
                        if (animalName.equals("exit")) {
                            System.out.println("Вы вышли. Счастливо!");
                            System.exit(0);
                        }
                        System.out.printf("Имя животного - %s\n", animalName);
                        break;
                    }

                    // Установка возраста животного
                    String animalAge;
                    while (true) {
                        System.out.println("Введите возраст животного. Целое число.");
                        animalAge = scanner.next().toString().trim();
                        if (animalAge.equals("exit")) {
                            System.out.println("Вы вышли. Счастливо!");
                            System.exit(0);
                        }
                        boolean isIntAge = NumbersTools.isNumber(animalAge);
                        if (!isIntAge) {
                            System.out.printf("Такого возрасты \"%s\" быть не может. Попробуйте ещё раз!\n", animalAge);
                            continue;
                        }
                        break;
                    }
                    System.out.printf("Возраст животного - %s\n", animalAge);

                    // Установка веса животного
                    String animalWeight;
                    while (true) {
                        System.out.println("Введите вес животного. Целое число.");
                        animalWeight = scanner.next().toString().trim();
                        if (animalWeight.equals("exit")) {
                            System.out.println("Вы вышли. Счастливо!");
                            System.exit(0);
                        }
                        boolean isIntWeight = NumbersTools.isNumber(animalWeight);
                        if (!isIntWeight) {
                            System.out.printf("Такого веса \"%s\" быть не может. Попробуйте ещё раз!\n", animalWeight);
                            continue;
                        }
                        break;
                    }
                    System.out.printf("Вес животного - %s\n", animalWeight);

                    // Установка цвета
                    String animalColor;
                    while (true) {
                        System.out.printf("Выберите цвет животного: %s\n",
                                String.join(" | ", getEnumAnimalColorsNames()));
                        animalColor = scanner.next().toLowerCase().trim();
                        if (animalColor.equals("exit")) {
                            System.out.println("Вы вышли. Счастливо!");
                            System.exit(0);
                        }
                        if (!getEnumAnimalColorsNames().contains(animalColor)) {
                            System.out.printf("Такого цвета \"%s\" нет в предложенных вариантах. Попробуйте ещё раз!\n",
                                    animalColor);
                            continue;
                        }
                        break;
                    }
                    System.out.printf("Вы выбрали цвет - %s\n", ColorData.valueOf(animalColor.toUpperCase()).getName());

                    // Создаю животного по полученным данным
                    AnimalsFactory new_animal = new AnimalsFactory();
                    // Создание экземпляра животного
                    AbsAnimals animal = new_animal.create(
                            AnimalsTypeData.valueOf(animalType),
                            animalName,
                            animalColor,
                            Integer.parseInt(animalWeight),
                            Integer.parseInt(animalAge));

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
        } catch (Exception e) {
            System.out.println("Возникла ошибка: " + e);
        } finally {
            scanner.close();
        }
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
