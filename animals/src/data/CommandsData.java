package data;

public enum CommandsData {

    exit("Выйти"),
    add("Добавить животное"),
    list("Список животных");

    private String command = null;

    CommandsData(String command) {
        this.command = command;
    }

    public String getName() {
        return this.command;
    }

}
