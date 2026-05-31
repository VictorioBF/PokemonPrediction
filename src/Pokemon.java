/*
Representa um Pokemon com atributos e lista de golpes.
*/
import java.util.List;

public class Pokemon {

    public String name;

    public List<Tipo> types;

    public int hp;
    public int attack;
    public int defense;
    public int spAttack;
    public int spDefense;
    public int speed;

    public List<Golpe> moves;

    public Pokemon(
            String name,
            List<Tipo> types,
            int hp,
            int attack,
            int defense,
            int spAttack,
            int spDefense,
            int speed,
            List<Golpe> moves
    ) {
        this.name = name;
        this.types = types;

        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;

        this.moves = moves;
    }
}