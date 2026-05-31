/*
Representa um golpe.
*/
public class Golpe {

    public String name;
    public Tipo type;
    public CategoriaGolpe category;
    public int power;

    public Golpe(String name, Tipo type, CategoriaGolpe category, int power) {
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