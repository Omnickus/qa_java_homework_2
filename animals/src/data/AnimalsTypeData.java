package data;

public enum AnimalsTypeData {

    cat("Кошка"),
    dog("Собака"),
    duck("Утка");

    private String name = null;

    AnimalsTypeData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
