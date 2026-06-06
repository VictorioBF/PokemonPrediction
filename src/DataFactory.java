import java.util.List;

public class DataFactory {

    // MOVES

        // NORMAL

    public static Move BodySlam = new Move(
            "Body Slam",
            Type.NORMAL,
            Category.PHYSICAL,
            85);

        // FIRE

    public static Move Flamethrower = new Move(
            "Flamethrower",
            Type.FIRE,
            Category.SPECIAL,
            90);

        // WATER

    public static Move HydroPump = new Move(
            "Hydro Pump",
            Type.WATER,
            Category.SPECIAL,
            110);

        // ELECTRIC

    public static Move Thunderbolt = new Move(
            "Thunderbolt",
            Type.ELECTRIC,
            Category.SPECIAL,
            90);

        // GRASS

    public static Move LeafStorm = new Move(
            "Leaf Storm",
            Type.GRASS,
            Category.SPECIAL,
            130);

        // ICE

    public static Move IceBeam = new Move(
            "Ice Beam",
            Type.ICE,
            Category.SPECIAL,
            90);

        // FIGHTING

    public static Move HighJumpKick = new Move(
            "High Jump Kick",
            Type.FIGHTING,
            Category.PHYSICAL,
            130);

        // POISON

    public static Move Sludge = new Move(
            "Sludge",
            Type.POISON,
            Category.SPECIAL,
            65);

        // GROUND

    public static Move Earthquake = new Move(
            "Earthquake",
            Type.GROUND,
            Category.PHYSICAL,
            100);

        // FLYING

    public static Move SkyAttack = new Move(
            "Sky Attack",
            Type.FLYING,
            Category.PHYSICAL,
            140);

        // PSYCHIC

    public static Move DreamEater = new Move(
            "Dream Eater",
            Type.PSYCHIC,
            Category.SPECIAL,
            100);

        // BUG

    public static Move LeechLife = new Move(
            "Leech Life",
            Type.BUG,
            Category.PHYSICAL,
            80);

        // ROCK

    public static Move RockSlide = new Move(
            "Rock Slide",
            Type.ROCK,
            Category.PHYSICAL,
            75);

        // GHOST

    public static Move ShadowBall = new Move(
            "Shadow Ball",
            Type.GHOST,
            Category.SPECIAL,
            80);

        // DRAGON

    public static Move Twister = new Move(
            "Twister",
            Type.DRAGON,
            Category.SPECIAL,
            40);

        // DARK

    public static Move FoulPlay = new Move(
            "Foul Play",
            Type.DARK,
            Category.PHYSICAL,
            95);

        // STEEL

    public static Move MetalClaw = new Move(
            "Metal Claw",
            Type.STEEL,
            Category.PHYSICAL,
            50);

        // FAIRY

    public static Move Moonblast = new Move(
            "Moonblast",
            Type.FAIRY,
            Category.SPECIAL,
            95);

        // RECOVER


    public static Move Recover = new Move(
            "Recover",
            Type.NORMAL,
            Category.STATUS,
            0);

    // POKEMON

    public static Pokemon bulbasaur() {
        return new Pokemon(
                1,
                "Bulbasaur",
                List.of(Type.GRASS, Type.POISON),
                45, 49, 49, 65, 65, 45,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon ivysaur() {
        return new Pokemon(
                2,
                "Ivysaur",
                List.of(Type.GRASS, Type.POISON),
                60, 62, 63, 80, 80, 60,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon venusaur() {
        return new Pokemon(
                3,
                "Venusaur",
                List.of(Type.GRASS, Type.POISON),
                80, 82, 83, 100, 100, 80,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon charmander() {
        return new Pokemon(
                4,
                "Charmander",
                List.of(Type.FIRE),
                39, 52, 43, 60, 50, 65,
                List.of(
                        Flamethrower,
                        Recover));
    }

    public static Pokemon charmeleon() {
        return new Pokemon(
                5,
                "Charmeleon",
                List.of(Type.FIRE),
                58, 64, 58, 80, 65, 80,
                List.of(
                        Flamethrower,
                        Recover));
    }

    public static Pokemon charizard() {
        return new Pokemon(
                6,
                "Charizard",
                List.of(Type.FIRE, Type.FLYING),
                78, 84, 78, 109, 85, 100,
                List.of(
                        Flamethrower,
                        Recover));
    }

    public static Pokemon squirtle() {
        return new Pokemon(
                7,
                "Squirtle",
                List.of(Type.WATER),
                44, 48, 65, 50, 64, 43,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon wartortle() {
        return new Pokemon(
                8,
                "Wartortle",
                List.of(Type.WATER),
                59, 63, 80, 65, 80, 58,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon blastoise() {
        return new Pokemon(
                9,
                "Blastoise",
                List.of(Type.WATER),
                79, 83, 100, 85, 105, 78,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon caterpie() {
        return new Pokemon(
                10,
                "Caterpie",
                List.of(Type.BUG),
                45, 30, 35, 20, 20, 45,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon metapod() {
        return new Pokemon(
                11,
                "Metapod",
                List.of(Type.BUG),
                50, 20, 55, 25, 25, 30,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon butterfree() {
        return new Pokemon(
                12,
                "Butterfree",
                List.of(Type.BUG, Type.FLYING),
                60, 45, 50, 90, 80, 70,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon weedle() {
        return new Pokemon(
                13,
                "Weedle",
                List.of(Type.BUG, Type.POISON),
                40, 35, 30, 20, 20, 50,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon kakuna() {
        return new Pokemon(
                14,
                "Kakuna",
                List.of(Type.BUG, Type.POISON),
                45, 25, 50, 25, 25, 35,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon beedrill() {
        return new Pokemon(
                15,
                "Beedrill",
                List.of(Type.BUG, Type.POISON),
                65, 90, 40, 45, 80, 75,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon pidgey() {
        return new Pokemon(
                16,
                "Pidgey",
                List.of(Type.NORMAL, Type.FLYING),
                40, 45, 40, 35, 35, 56,
                List.of(
                        SkyAttack,
                        Recover));
    }

    public static Pokemon pidgeotto() {
        return new Pokemon(
                17,
                "Pidgeotto",
                List.of(Type.NORMAL, Type.FLYING),
                63, 60, 55, 50, 50, 71,
                List.of(
                        SkyAttack,
                        Recover));
    }

    public static Pokemon pidgeot() {
        return new Pokemon(
                18,
                "Pidgeot",
                List.of(Type.NORMAL, Type.FLYING),
                83, 80, 75, 70, 70, 101,
                List.of(
                        SkyAttack,
                        Recover));
    }

    public static Pokemon rattata() {
        return new Pokemon(
                19,
                "Rattata",
                List.of(Type.NORMAL),
                30, 56, 35, 25, 35, 72,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon raticate() {
        return new Pokemon(
                20,
                "Raticate",
                List.of(Type.NORMAL),
                55, 81, 60, 50, 70, 97,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon spearow() {
        return new Pokemon(
                21,
                "Spearow",
                List.of(Type.NORMAL, Type.FLYING),
                40, 60, 30, 31, 31, 70,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon fearow() {
        return new Pokemon(
                22,
                "Fearow",
                List.of(Type.NORMAL, Type.FLYING),
                65, 90, 65, 61, 61, 100,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon ekans() {
        return new Pokemon(
                23,
                "Ekans",
                List.of(Type.POISON),
                35, 60, 44, 40, 54, 55,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon arbok() {
        return new Pokemon(
                24,
                "Arbok",
                List.of(Type.POISON),
                60, 95, 69, 65, 79, 80,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon pikachu() {
        return new Pokemon(
                25,
                "Pikachu",
                List.of(Type.ELECTRIC),
                35, 55, 40, 50, 50, 90,
                List.of(
                        Thunderbolt,
                        Recover));
    }

    public static Pokemon raichu() {
        return new Pokemon(
                26,
                "Raichu",
                List.of(Type.ELECTRIC),
                60, 90, 55, 90, 80, 110,
                List.of(
                        Thunderbolt,
                        Recover));
    }

    public static Pokemon sandshrew() {
        return new Pokemon(
                27,
                "Sandshrew",
                List.of(Type.GROUND),
                50, 75, 85, 20, 30, 40,
                List.of(
                        Earthquake,
                        Recover));
    }

    public static Pokemon sandslash() {
        return new Pokemon(
                28,
                "Sandslash",
                List.of(Type.GROUND),
                75, 100, 110, 45, 55, 65,
                List.of(
                        Earthquake,
                        Recover));
    }

    public static Pokemon nidorina() {
        return new Pokemon(
                30,
                "Nidorina",
                List.of(Type.POISON),
                70, 62, 67, 55, 55, 56,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon nidoqueen() {
        return new Pokemon(
                31,
                "Nidoqueen",
                List.of(Type.POISON, Type.GROUND),
                90, 92, 87, 75, 85, 76,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon nidorino() {
        return new Pokemon(
                33,
                "Nidorino",
                List.of(Type.POISON),
                61, 72, 57, 55, 55, 65,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon nidoking() {
        return new Pokemon(
                34,
                "Nidoking",
                List.of(Type.POISON, Type.GROUND),
                81, 102, 77, 85, 75, 85,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon clefairy() {
        return new Pokemon(
                35,
                "Clefairy",
                List.of(Type.FAIRY),
                70, 45, 48, 60, 65, 35,
                List.of(
                        Moonblast,
                        Recover));
    }

    public static Pokemon clefable() {
        return new Pokemon(
                36,
                "Clefable",
                List.of(Type.FAIRY),
                95, 70, 73, 95, 90, 60,
                List.of(
                        Moonblast,
                        Recover));
    }

    public static Pokemon vulpix() {
        return new Pokemon(
                37,
                "Vulpix",
                List.of(Type.FIRE),
                38, 41, 40, 50, 65, 65,
                List.of(
                        Flamethrower,
                        Recover));
    }

    public static Pokemon ninetales() {
        return new Pokemon(
                38,
                "Ninetales",
                List.of(Type.FIRE),
                73, 76, 75, 81, 100, 100,
                List.of(
                        Flamethrower,
                        Recover));
    }

    public static Pokemon jigglypuff() {
        return new Pokemon(
                39,
                "Jigglypuff",
                List.of(Type.NORMAL, Type.FAIRY),
                115, 45, 20, 45, 25, 20,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon wigglytuff() {
        return new Pokemon(
                40,
                "Wigglytuff",
                List.of(Type.NORMAL, Type.FAIRY),
                140, 70, 45, 85, 50, 45,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon zubat() {
        return new Pokemon(
                41,
                "Zubat",
                List.of(Type.POISON, Type.FLYING),
                40, 45, 35, 30, 40, 55,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon golbat() {
        return new Pokemon(
                42,
                "Golbat",
                List.of(Type.POISON, Type.FLYING),
                75, 80, 70, 65, 75, 90,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon oddish() {
        return new Pokemon(
                43,
                "Oddish",
                List.of(Type.GRASS, Type.POISON),
                45, 50, 55, 75, 65, 30,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon gloom() {
        return new Pokemon(
                44,
                "Gloom",
                List.of(Type.GRASS, Type.POISON),
                60, 65, 70, 85, 75, 40,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon vileplume() {
        return new Pokemon(
                45,
                "Vileplume",
                List.of(Type.GRASS, Type.POISON),
                75, 80, 85, 110, 90, 50,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon paras() {
        return new Pokemon(
                46,
                "Paras",
                List.of(Type.BUG, Type.GRASS),
                35, 70, 55, 45, 55, 25,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon parasect() {
        return new Pokemon(
                47,
                "Parasect",
                List.of(Type.BUG, Type.GRASS),
                60, 95, 80, 60, 80, 30,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon venonat() {
        return new Pokemon(
                48,
                "Venonat",
                List.of(Type.BUG, Type.POISON),
                60, 55, 50, 40, 55, 45,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon venomoth() {
        return new Pokemon(
                49,
                "Venomoth",
                List.of(Type.BUG, Type.POISON),
                70, 65, 60, 90, 75, 90,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon diglett() {
        return new Pokemon(
                50,
                "Diglett",
                List.of(Type.GROUND),
                10, 55, 25, 35, 45, 95,
                List.of(
                        Earthquake,
                        Recover));
    }

    public static Pokemon dugtrio() {
        return new Pokemon(
                51,
                "Dugtrio",
                List.of(Type.GROUND),
                35, 100, 50, 50, 70, 120,
                List.of(
                        Earthquake,
                        Recover));
    }

    public static Pokemon meowth() {
        return new Pokemon(
                52,
                "Meowth",
                List.of(Type.NORMAL),
                40, 45, 35, 40, 40, 90,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon persian() {
        return new Pokemon(
                53,
                "Persian",
                List.of(Type.NORMAL),
                65, 70, 60, 65, 65, 115,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon psyduck() {
        return new Pokemon(
                54,
                "Psyduck",
                List.of(Type.WATER),
                50, 52, 48, 65, 50, 55,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon golduck() {
        return new Pokemon(
                55,
                "Golduck",
                List.of(Type.WATER),
                80, 82, 78, 95, 80, 85,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon mankey() {
        return new Pokemon(
                56,
                "Mankey",
                List.of(Type.FIGHTING),
                40, 80, 35, 35, 45, 70,
                List.of(
                        HighJumpKick,
                        Recover));
    }

    public static Pokemon primeape() {
        return new Pokemon(
                57,
                "Primeape",
                List.of(Type.FIGHTING),
                65, 105, 60, 60, 70, 95,
                List.of(
                        HighJumpKick,
                        Recover));
    }

    public static Pokemon growlithe() {
        return new Pokemon(
                58,
                "Growlithe",
                List.of(Type.FIRE),
                55, 70, 45, 70, 50, 60,
                List.of(
                        Flamethrower,
                        Recover));
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

    public static Pokemon poliwag() {
        return new Pokemon(
                60,
                "Poliwag",
                List.of(Type.WATER),
                40, 50, 40, 40, 40, 90,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon poliwhirl() {
        return new Pokemon(
                61,
                "Poliwhirl",
                List.of(Type.WATER),
                65, 65, 65, 50, 50, 90,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon poliwrath() {
        return new Pokemon(
                62,
                "Poliwrath",
                List.of(Type.WATER, Type.FIGHTING),
                90, 95, 95, 70, 90, 70,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon abra() {
        return new Pokemon(
                63,
                "Abra",
                List.of(Type.PSYCHIC),
                25, 20, 15, 105, 55, 90,
                List.of(
                        DreamEater,
                        Recover));
    }

    public static Pokemon kadabra() {
        return new Pokemon(
                64,
                "Kadabra",
                List.of(Type.PSYCHIC),
                40, 35, 30, 120, 70, 105,
                List.of(
                        DreamEater,
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

    public static Pokemon machop() {
        return new Pokemon(
                66,
                "Machop",
                List.of(Type.FIGHTING),
                70, 80, 50, 35, 35, 35,
                List.of(
                        HighJumpKick,
                        Recover));
    }

    public static Pokemon machoke() {
        return new Pokemon(
                67,
                "Machoke",
                List.of(Type.FIGHTING),
                80, 100, 70, 50, 60, 45,
                List.of(
                        HighJumpKick,
                        Recover));
    }

    public static Pokemon machamp() {
        return new Pokemon(
                68,
                "Machamp",
                List.of(Type.FIGHTING),
                90, 130, 80, 65, 85, 55,
                List.of(
                        HighJumpKick,
                        Recover));
    }

    public static Pokemon bellsprout() {
        return new Pokemon(
                69,
                "Bellsprout",
                List.of(Type.GRASS, Type.POISON),
                50, 75, 35, 70, 30, 40,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon weepinbell() {
        return new Pokemon(
                70,
                "Weepinbell",
                List.of(Type.GRASS, Type.POISON),
                65, 90, 50, 85, 45, 55,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon victreebel() {
        return new Pokemon(
                71,
                "Victreebel",
                List.of(Type.GRASS, Type.POISON),
                80, 105, 65, 100, 70, 70,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon tentacool() {
        return new Pokemon(
                72,
                "Tentacool",
                List.of(Type.WATER, Type.POISON),
                40, 40, 35, 50, 100, 70,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon tentacruel() {
        return new Pokemon(
                73,
                "Tentacruel",
                List.of(Type.WATER, Type.POISON),
                80, 70, 65, 80, 120, 100,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon geodude() {
        return new Pokemon(
                74,
                "Geodude",
                List.of(Type.ROCK, Type.GROUND),
                40, 80, 100, 30, 30, 20,
                List.of(
                        RockSlide,
                        Recover));
    }

    public static Pokemon graveler() {
        return new Pokemon(
                75,
                "Graveler",
                List.of(Type.ROCK, Type.GROUND),
                55, 95, 115, 45, 45, 35,
                List.of(
                        RockSlide,
                        Recover));
    }

    public static Pokemon golem() {
        return new Pokemon(
                76,
                "Golem",
                List.of(Type.ROCK, Type.GROUND),
                80, 120, 130, 55, 65, 45,
                List.of(
                        RockSlide,
                        Recover));
    }

    public static Pokemon ponyta() {
        return new Pokemon(
                77,
                "Ponyta",
                List.of(Type.FIRE),
                50, 85, 55, 65, 65, 90,
                List.of(
                        Flamethrower,
                        Recover));
    }

    public static Pokemon rapidash() {
        return new Pokemon(
                78,
                "Rapidash",
                List.of(Type.FIRE),
                65, 100, 70, 80, 80, 105,
                List.of(
                        Flamethrower,
                        Recover));
    }

    public static Pokemon slowpoke() {
        return new Pokemon(
                79,
                "Slowpoke",
                List.of(Type.WATER, Type.PSYCHIC),
                90, 65, 65, 40, 40, 15,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon slowbro() {
        return new Pokemon(
                80,
                "Slowbro",
                List.of(Type.WATER, Type.PSYCHIC),
                95, 75, 110, 100, 80, 30,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon magnemite() {
        return new Pokemon(
                81,
                "Magnemite",
                List.of(Type.ELECTRIC, Type.STEEL),
                25, 35, 70, 95, 55, 45,
                List.of(
                        Thunderbolt,
                        Recover));
    }

    public static Pokemon magneton() {
        return new Pokemon(
                82,
                "Magneton",
                List.of(Type.ELECTRIC, Type.STEEL),
                50, 60, 95, 120, 70, 70,
                List.of(
                        Thunderbolt,
                        Recover));
    }

    public static Pokemon farfetchd() {
        return new Pokemon(
                83,
                "FarfetchÆd",
                List.of(Type.NORMAL, Type.FLYING),
                52, 90, 55, 58, 62, 60,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon doduo() {
        return new Pokemon(
                84,
                "Doduo",
                List.of(Type.NORMAL, Type.FLYING),
                35, 85, 45, 35, 35, 75,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon dodrio() {
        return new Pokemon(
                85,
                "Dodrio",
                List.of(Type.NORMAL, Type.FLYING),
                60, 110, 70, 60, 60, 110,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon seel() {
        return new Pokemon(
                86,
                "Seel",
                List.of(Type.WATER),
                65, 45, 55, 45, 70, 45,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon dewgong() {
        return new Pokemon(
                87,
                "Dewgong",
                List.of(Type.WATER, Type.ICE),
                90, 70, 80, 70, 95, 70,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon grimer() {
        return new Pokemon(
                88,
                "Grimer",
                List.of(Type.POISON),
                80, 80, 50, 40, 50, 25,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon muk() {
        return new Pokemon(
                89,
                "Muk",
                List.of(Type.POISON),
                105, 105, 75, 65, 100, 50,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon shellder() {
        return new Pokemon(
                90,
                "Shellder",
                List.of(Type.WATER),
                30, 65, 100, 45, 25, 40,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon cloyster() {
        return new Pokemon(
                91,
                "Cloyster",
                List.of(Type.WATER, Type.ICE),
                50, 95, 180, 85, 45, 70,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon gastly() {
        return new Pokemon(
                92,
                "Gastly",
                List.of(Type.GHOST, Type.POISON),
                30, 35, 30, 100, 35, 80,
                List.of(
                        ShadowBall,
                        Recover));
    }

    public static Pokemon haunter() {
        return new Pokemon(
                93,
                "Haunter",
                List.of(Type.GHOST, Type.POISON),
                45, 50, 45, 115, 55, 95,
                List.of(
                        ShadowBall,
                        Recover));
    }

    public static Pokemon gengar() {
        return new Pokemon(
                94,
                "Gengar",
                List.of(Type.GHOST, Type.POISON),
                60, 65, 60, 130, 75, 110,
                List.of(
                        ShadowBall,
                        Recover));
    }

    public static Pokemon onix() {
        return new Pokemon(
                95,
                "Onix",
                List.of(Type.ROCK, Type.GROUND),
                35, 45, 160, 30, 45, 70,
                List.of(
                        RockSlide,
                        Recover));
    }

    public static Pokemon drowzee() {
        return new Pokemon(
                96,
                "Drowzee",
                List.of(Type.PSYCHIC),
                60, 48, 45, 43, 90, 42,
                List.of(
                        DreamEater,
                        Recover));
    }

    public static Pokemon hypno() {
        return new Pokemon(
                97,
                "Hypno",
                List.of(Type.PSYCHIC),
                85, 73, 70, 73, 115, 67,
                List.of(
                        DreamEater,
                        Recover));
    }

    public static Pokemon krabby() {
        return new Pokemon(
                98,
                "Krabby",
                List.of(Type.WATER),
                30, 105, 90, 25, 25, 50,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon kingler() {
        return new Pokemon(
                99,
                "Kingler",
                List.of(Type.WATER),
                55, 130, 115, 50, 50, 75,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon voltorb() {
        return new Pokemon(
                100,
                "Voltorb",
                List.of(Type.ELECTRIC),
                40, 30, 50, 55, 55, 100,
                List.of(
                        Thunderbolt,
                        Recover));
    }

    public static Pokemon electrode() {
        return new Pokemon(
                101,
                "Electrode",
                List.of(Type.ELECTRIC),
                60, 50, 70, 80, 80, 150,
                List.of(
                        Thunderbolt,
                        Recover));
    }

    public static Pokemon exeggcute() {
        return new Pokemon(
                102,
                "Exeggcute",
                List.of(Type.GRASS, Type.PSYCHIC),
                60, 40, 80, 60, 45, 40,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon exeggutor() {
        return new Pokemon(
                103,
                "Exeggutor",
                List.of(Type.GRASS, Type.PSYCHIC),
                95, 95, 85, 125, 75, 55,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon cubone() {
        return new Pokemon(
                104,
                "Cubone",
                List.of(Type.GROUND),
                50, 50, 95, 40, 50, 35,
                List.of(
                        Earthquake,
                        Recover));
    }

    public static Pokemon marowak() {
        return new Pokemon(
                105,
                "Marowak",
                List.of(Type.GROUND),
                60, 80, 110, 50, 80, 45,
                List.of(
                        Earthquake,
                        Recover));
    }

    public static Pokemon hitmonlee() {
        return new Pokemon(
                106,
                "Hitmonlee",
                List.of(Type.FIGHTING),
                50, 120, 53, 35, 110, 87,
                List.of(
                        HighJumpKick,
                        Recover));
    }

    public static Pokemon hitmonchan() {
        return new Pokemon(
                107,
                "Hitmonchan",
                List.of(Type.FIGHTING),
                50, 105, 79, 35, 110, 76,
                List.of(
                        HighJumpKick,
                        Recover));
    }

    public static Pokemon lickitung() {
        return new Pokemon(
                108,
                "Lickitung",
                List.of(Type.NORMAL),
                90, 55, 75, 60, 75, 30,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon koffing() {
        return new Pokemon(
                109,
                "Koffing",
                List.of(Type.POISON),
                40, 65, 95, 60, 45, 35,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon weezing() {
        return new Pokemon(
                110,
                "Weezing",
                List.of(Type.POISON),
                65, 90, 120, 85, 70, 60,
                List.of(
                        Sludge,
                        Recover));
    }

    public static Pokemon rhyhorn() {
        return new Pokemon(
                111,
                "Rhyhorn",
                List.of(Type.GROUND, Type.ROCK),
                80, 85, 95, 30, 30, 25,
                List.of(
                        Earthquake,
                        Recover));
    }

    public static Pokemon rhydon() {
        return new Pokemon(
                112,
                "Rhydon",
                List.of(Type.GROUND, Type.ROCK),
                105, 130, 120, 45, 45, 40,
                List.of(
                        Earthquake,
                        Recover));
    }

    public static Pokemon chansey() {
        return new Pokemon(
                113,
                "Chansey",
                List.of(Type.NORMAL),
                250, 5, 5, 35, 105, 50,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon tangela() {
        return new Pokemon(
                114,
                "Tangela",
                List.of(Type.GRASS),
                65, 55, 115, 100, 40, 60,
                List.of(
                        LeafStorm,
                        Recover));
    }

    public static Pokemon kangaskhan() {
        return new Pokemon(
                115,
                "Kangaskhan",
                List.of(Type.NORMAL),
                105, 95, 80, 40, 80, 90,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon horsea() {
        return new Pokemon(
                116,
                "Horsea",
                List.of(Type.WATER),
                30, 40, 70, 70, 25, 60,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon seadra() {
        return new Pokemon(
                117,
                "Seadra",
                List.of(Type.WATER),
                55, 65, 95, 95, 45, 85,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon goldeen() {
        return new Pokemon(
                118,
                "Goldeen",
                List.of(Type.WATER),
                45, 67, 60, 35, 50, 63,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon seaking() {
        return new Pokemon(
                119,
                "Seaking",
                List.of(Type.WATER),
                80, 92, 65, 65, 80, 68,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon staryu() {
        return new Pokemon(
                120,
                "Staryu",
                List.of(Type.WATER),
                30, 45, 55, 70, 55, 85,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon starmie() {
        return new Pokemon(
                121,
                "Starmie",
                List.of(Type.WATER, Type.PSYCHIC),
                60, 75, 85, 100, 85, 115,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon mrMime() {
        return new Pokemon(
                122,
                "Mr. Mime",
                List.of(Type.PSYCHIC, Type.FAIRY),
                40, 45, 65, 100, 120, 90,
                List.of(
                        DreamEater,
                        Recover));
    }

    public static Pokemon scyther() {
        return new Pokemon(
                123,
                "Scyther",
                List.of(Type.BUG, Type.FLYING),
                70, 110, 80, 55, 80, 105,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon jynx() {
        return new Pokemon(
                124,
                "Jynx",
                List.of(Type.ICE, Type.PSYCHIC),
                65, 50, 35, 115, 95, 95,
                List.of(
                        IceBeam,
                        Recover));
    }

    public static Pokemon electabuzz() {
        return new Pokemon(
                125,
                "Electabuzz",
                List.of(Type.ELECTRIC),
                65, 83, 57, 95, 85, 105,
                List.of(
                        Thunderbolt,
                        Recover));
    }

    public static Pokemon magmar() {
        return new Pokemon(
                126,
                "Magmar",
                List.of(Type.FIRE),
                65, 95, 57, 100, 85, 93,
                List.of(
                        Flamethrower,
                        Recover));
    }

    public static Pokemon pinsir() {
        return new Pokemon(
                127,
                "Pinsir",
                List.of(Type.BUG),
                65, 125, 100, 55, 70, 85,
                List.of(
                        LeechLife,
                        Recover));
    }

    public static Pokemon tauros() {
        return new Pokemon(
                128,
                "Tauros",
                List.of(Type.NORMAL),
                75, 100, 95, 40, 70, 110,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon magikarp() {
        return new Pokemon(
                129,
                "Magikarp",
                List.of(Type.WATER),
                20, 10, 55, 15, 20, 80,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon gyarados() {
        return new Pokemon(
                130,
                "Gyarados",
                List.of(Type.WATER, Type.FLYING),
                95, 125, 79, 60, 100, 81,
                List.of(
                        HydroPump,
                        Recover));
    }

    public static Pokemon lapras() {
        return new Pokemon(
                131,
                "Lapras",
                List.of(Type.WATER, Type.ICE),
                130, 85, 80, 85, 95, 60,
                List.of(
                        HydroPump,
                        IceBeam));
    }

    public static Pokemon ditto() {
        return new Pokemon(
                132,
                "Ditto",
                List.of(Type.NORMAL),
                48, 48, 48, 48, 48, 48,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon eevee() {
        return new Pokemon(
                133,
                "Eevee",
                List.of(Type.NORMAL),
                55, 55, 50, 45, 65, 55,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon vaporeon() {
        return new Pokemon(
                134,
                "Vaporeon",
                List.of(Type.WATER),
                130, 65, 60, 110, 95, 65,
                List.of(
                        HydroPump,
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

    public static Pokemon flareon() {
        return new Pokemon(
                136,
                "Flareon",
                List.of(Type.FIRE),
                65, 130, 60, 95, 110, 65,
                List.of(
                        Flamethrower,
                        Recover));
    }

    public static Pokemon porygon() {
        return new Pokemon(
                137,
                "Porygon",
                List.of(Type.NORMAL),
                65, 60, 70, 85, 75, 40,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon omanyte() {
        return new Pokemon(
                138,
                "Omanyte",
                List.of(Type.ROCK, Type.WATER),
                35, 40, 100, 90, 55, 35,
                List.of(
                        RockSlide,
                        Recover));
    }

    public static Pokemon omastar() {
        return new Pokemon(
                139,
                "Omastar",
                List.of(Type.ROCK, Type.WATER),
                70, 60, 125, 115, 70, 55,
                List.of(
                        RockSlide,
                        Recover));
    }

    public static Pokemon kabuto() {
        return new Pokemon(
                140,
                "Kabuto",
                List.of(Type.ROCK, Type.WATER),
                30, 80, 90, 55, 45, 55,
                List.of(
                        RockSlide,
                        Recover));
    }

    public static Pokemon kabutops() {
        return new Pokemon(
                141,
                "Kabutops",
                List.of(Type.ROCK, Type.WATER),
                60, 115, 105, 65, 70, 80,
                List.of(
                        RockSlide,
                        Recover));
    }

    public static Pokemon aerodactyl() {
        return new Pokemon(
                142,
                "Aerodactyl",
                List.of(Type.ROCK, Type.FLYING),
                80, 105, 65, 60, 75, 130,
                List.of(
                        RockSlide,
                        Recover));
    }

    public static Pokemon snorlax() {
        return new Pokemon(
                143,
                "Snorlax",
                List.of(Type.NORMAL),
                160, 110, 65, 65, 110, 30,
                List.of(
                        BodySlam,
                        Recover));
    }

    public static Pokemon articuno() {
        return new Pokemon(
                144,
                "Articuno",
                List.of(Type.ICE, Type.FLYING),
                90, 85, 100, 95, 125, 85,
                List.of(
                        IceBeam,
                        Recover));
    }

    public static Pokemon zapdos() {
        return new Pokemon(
                145,
                "Zapdos",
                List.of(Type.ELECTRIC, Type.FLYING),
                90, 90, 85, 125, 90, 100,
                List.of(
                        Thunderbolt,
                        Recover));
    }

    public static Pokemon moltres() {
        return new Pokemon(
                146,
                "Moltres",
                List.of(Type.FIRE, Type.FLYING),
                90, 100, 90, 125, 85, 90,
                List.of(
                        Flamethrower,
                        Recover));
    }

    public static Pokemon dratini() {
        return new Pokemon(
                147,
                "Dratini",
                List.of(Type.DRAGON),
                41, 64, 45, 50, 50, 50,
                List.of(
                        Twister,
                        Recover));
    }

    public static Pokemon dragonair() {
        return new Pokemon(
                148,
                "Dragonair",
                List.of(Type.DRAGON),
                61, 84, 65, 70, 70, 70,
                List.of(
                        Twister,
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

    public static Pokemon mewtwo() {
        return new Pokemon(
                150,
                "Mewtwo",
                List.of(Type.PSYCHIC),
                106, 110, 90, 154, 90, 130,
                List.of(
                        DreamEater,
                        Recover));
    }

    public static Pokemon mew() {
        return new Pokemon(
                151,
                "Mew",
                List.of(Type.PSYCHIC),
                100, 100, 100, 100, 100, 100,
                List.of(
                        DreamEater,
                        Recover));
    }

        // RESTO

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

}
