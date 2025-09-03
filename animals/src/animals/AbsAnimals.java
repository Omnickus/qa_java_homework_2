package animals;

public class AbsAnimals {

    private String name = null;
    private Integer age = null;
    private Integer weight = null;
    private String color = null;

    public AbsAnimals( String name, String color, Integer weight, Integer age) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** Сеттер возраста */
    public void setAge(Integer age) {
        this.age = age;
    }

    /** Сеттер веса */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /** Сеттер цвета */
    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return String.format(
            "Привет! Меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s",
            this.name, this.age, this.getYearCase(), this.weight, this.color
        );
    }

    private String getYearCase() {
        int remains = this.age % 10;
        if (remains == 0 || this.age >= 11 && this.age <= 14) {
            return "лет";
        }
        if (remains == 1) {
            return "год";
        }
        if (remains >= 2 && remains <= 4) {
            return "года";
        }
        return "лет";
    }

}
