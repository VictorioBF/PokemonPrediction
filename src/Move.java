public class Move {

    public String name;
    public Type type;
    public Category category;
    public int power;

    public Move(String name, Type type, Category category, int power) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
    }

    @Override
    public String toString() {
        return name;
    }
}