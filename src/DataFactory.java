import java.util.List;

public class DataFactory {

    // MOVES

    public static Move Flamethrower = new Move(
            "Flamethrower",
            Type.FIRE,
            Category.SPECIAL,
            90);

    public static Move HydroPump = new Move(
            "Hydro Pump",
            Type.WATER,
            Category.SPECIAL,
            110);

    public static Move Thunderbolt = new Move(
            "Thunderbolt",
            Type.ELECTRIC,
            Category.SPECIAL,
            90);

    public static Move LeafStorm = new Move(
            "Leaf Storm",
            Type.GRASS,
            Category.SPECIAL,
            130);

    public static Move Earthquake = new Move(
            "Earthquake",
            Type.GROUND,
            Category.PHYSICAL,
            100);

    public static Move IceBeam = new Move(
            "Ice Beam",
            Type.ICE,
            Category.SPECIAL,
            90);

    public static Move ShadowBall = new Move(
            "Shadow Ball",
            Type.GHOST,
            Category.SPECIAL,
            80);

    public static Move Recover = new Move(
            "Recover",
            Type.NORMAL,
            Category.STATUS,
            0);

    // POKEMON

    public static Pokemon charizard() {

        return new Pokemon(
                6,
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
                        Recover));
    }

    public static Pokemon blastoise() {

        return new Pokemon(
                9,
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
                        Recover));
    }

    public static Pokemon venusaur() {

        return new Pokemon(
                3,
                "Venusaur",
                List.of(Type.GRASS),
                80,
                82,
                83,
                100,
                100,
                80,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon pikachu() {

        return new Pokemon(
                25,
                "Pikachu",
                List.of(Type.ELECTRIC),
                35,
                55,
                40,
                50,
                50,
                90,
                List.of(
                        Thunderbolt,
                        Recover));
    }

    public static Pokemon gengar() {

        return new Pokemon(
                94,
                "Gengar",
                List.of(Type.GHOST),
                60,
                65,
                60,
                130,
                75,
                110,
                List.of(
                        ShadowBall,
                        Recover));
    }

    public static Pokemon garchomp() {

        return new Pokemon(
                445,
                "Garchomp",
                List.of(Type.DRAGON, Type.GROUND),
                108,
                130,
                95,
                80,
                85,
                102,
                List.of(
                        Earthquake,
                        Recover));
    }

    public static Pokemon lapras() {

        return new Pokemon(
                131,
                "Lapras",
                List.of(Type.WATER, Type.ICE),
                130,
                85,
                80,
                85,
                95,
                60,
                List.of(
                        HydroPump,
                        IceBeam));
    }

    public static Pokemon arcanine() {
        return new Pokemon(
                59,
                "Arcanine",
                List.of(Type.FIRE),
                90, 110, 80, 100, 80, 95,
                List.of(
                        Flamethrower,
                        Recover));
    }

    public static Pokemon sceptile() {
        return new Pokemon(
                254,
                "Sceptile",
                List.of(Type.GRASS),
                70, 85, 65, 105, 85, 120,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon alakazam() {
        return new Pokemon(
                65,
                "Alakazam",
                List.of(Type.PSYCHIC),
                55, 50, 45, 135, 95, 120,
                List.of(
                        ShadowBall,
                        Recover));
    }

    public static Pokemon jolteon() {
        return new Pokemon(
                135,
                "Jolteon",
                List.of(Type.ELECTRIC),
                65, 65, 60, 110, 95, 130,
                List.of(
                        Thunderbolt,
                        Recover));
    }

    public static Pokemon dragonite() {
        return new Pokemon(
                149,
                "Dragonite",
                List.of(Type.DRAGON, Type.FLYING),
                91, 134, 95, 100, 100, 80,
                List.of(
                        Earthquake,
                        Recover));
    }

}
