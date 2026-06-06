import java.util.List;

public class Pokemon {

    public int pokedexNumber;
    public String name;

    public List<Type> types;

    public int hp;
    public int attack;
    public int defense;
    public int spAttack;
    public int spDefense;
    public int speed;

    public List<Move> moves;

    public Pokemon(
            int pokedexNumber,
            String name,
            List<Type> types,
            int hp,
            int attack,
            int defense,
            int spAttack,
            int spDefense,
            int speed,
            List<Move> moves
    ) {
        this.pokedexNumber = pokedexNumber;
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

    public boolean isWeakAgainst(Pokemon other) {
        double thisEffectiveness = 0;
        double otherEffectiveness = 0;

        for (Type t1 : this.types) {
            for (Type t2 : other.types) {
                thisEffectiveness += DamageCalculator.effectiveness(t1, t2);
                otherEffectiveness += DamageCalculator.effectiveness(t2, t1);
            }
        }

        return otherEffectiveness > thisEffectiveness;

    }
}
