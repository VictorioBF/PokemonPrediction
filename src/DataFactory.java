import java.util.List;

public class DataFactory {

    public static Move Flamethrower =
            new Move(
                    "Flamethrower",
                    Type.FIRE,
                    Category.SPECIAL,
                    90
            );

    public static Move Recover =
            new Move(
                    "Recover",
                    Type.NORMAL,
                    Category.STATUS,
                    0
            );

    public static Move HydroPump =
            new Move(
                    "Hydro Pump",
                    Type.WATER,
                    Category.SPECIAL,
                    110
            );

    public static Pokemon charizard() {

        return new Pokemon(
                "Charizard",
                List.of(Type.FIRE, Type.FLYING),
                78,
                84,
                78,
                109,
                85,
                100,
                List.of(
                        Flamethrower,
                        Recover
                )
        );
    }

    public static Pokemon blastoise() {

        return new Pokemon(
                "Blastoise",
                List.of(Type.WATER),
                79,
                83,
                100,
                85,
                105,
                78,
                List.of(
                        HydroPump,
                        Recover
                )
        );
    }
}