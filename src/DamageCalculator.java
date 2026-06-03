public class DamageCalculator {

    public static double[][] typeChart = new double[18][18];

    static {

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 18; j++) {
                typeChart[i][j] = 1.0;
            }
        }

        // FIRE
        typeChart[Type.FIRE.ordinal()][Type.GRASS.ordinal()] = 2.0;
        typeChart[Type.FIRE.ordinal()][Type.WATER.ordinal()] = 0.5;
        typeChart[Type.FIRE.ordinal()][Type.FIRE.ordinal()] = 0.5;
        typeChart[Type.FIRE.ordinal()][Type.ROCK.ordinal()] = 0.5;
        typeChart[Type.FIRE.ordinal()][Type.ICE.ordinal()] = 2.0;

        // WATER
        typeChart[Type.WATER.ordinal()][Type.FIRE.ordinal()] = 2.0;
        typeChart[Type.WATER.ordinal()][Type.GRASS.ordinal()] = 0.5;
        typeChart[Type.WATER.ordinal()][Type.WATER.ordinal()] = 0.5;
        typeChart[Type.WATER.ordinal()][Type.GROUND.ordinal()] = 2.0;
        typeChart[Type.WATER.ordinal()][Type.ROCK.ordinal()] = 2.0;

        // GRASS
        typeChart[Type.GRASS.ordinal()][Type.WATER.ordinal()] = 2.0;
        typeChart[Type.GRASS.ordinal()][Type.FIRE.ordinal()] = 0.5;
        typeChart[Type.GRASS.ordinal()][Type.GRASS.ordinal()] = 0.5;
        typeChart[Type.GRASS.ordinal()][Type.GROUND.ordinal()] = 2.0;
        typeChart[Type.GRASS.ordinal()][Type.ROCK.ordinal()] = 2.0;
        typeChart[Type.GRASS.ordinal()][Type.FLYING.ordinal()] = 0.5;

        // ELECTRIC
        typeChart[Type.ELECTRIC.ordinal()][Type.WATER.ordinal()] = 2.0;
        typeChart[Type.ELECTRIC.ordinal()][Type.FLYING.ordinal()] = 2.0;
        typeChart[Type.ELECTRIC.ordinal()][Type.GRASS.ordinal()] = 0.5;
        typeChart[Type.ELECTRIC.ordinal()][Type.ELECTRIC.ordinal()] = 0.5;
        typeChart[Type.ELECTRIC.ordinal()][Type.GROUND.ordinal()] = 0.0;

        // GROUND
        typeChart[Type.GROUND.ordinal()][Type.FIRE.ordinal()] = 2.0;
        typeChart[Type.GROUND.ordinal()][Type.ELECTRIC.ordinal()] = 2.0;
        typeChart[Type.GROUND.ordinal()][Type.ROCK.ordinal()] = 2.0;
        typeChart[Type.GROUND.ordinal()][Type.STEEL.ordinal()] = 2.0;
        typeChart[Type.GROUND.ordinal()][Type.GRASS.ordinal()] = 0.5;
        typeChart[Type.GROUND.ordinal()][Type.BUG.ordinal()] = 0.5;
        typeChart[Type.GROUND.ordinal()][Type.FLYING.ordinal()] = 0.0;

        // ICE
        typeChart[Type.ICE.ordinal()][Type.GRASS.ordinal()] = 2.0;
        typeChart[Type.ICE.ordinal()][Type.GROUND.ordinal()] = 2.0;
        typeChart[Type.ICE.ordinal()][Type.FLYING.ordinal()] = 2.0;
        typeChart[Type.ICE.ordinal()][Type.DRAGON.ordinal()] = 2.0;
        typeChart[Type.ICE.ordinal()][Type.FIRE.ordinal()] = 0.5;
        typeChart[Type.ICE.ordinal()][Type.WATER.ordinal()] = 0.5;
        typeChart[Type.ICE.ordinal()][Type.ICE.ordinal()] = 0.5;

        // GHOST
        typeChart[Type.GHOST.ordinal()][Type.GHOST.ordinal()] = 2.0;
        typeChart[Type.GHOST.ordinal()][Type.PSYCHIC.ordinal()] = 2.0;
        typeChart[Type.GHOST.ordinal()][Type.DARK.ordinal()] = 0.5;
        typeChart[Type.GHOST.ordinal()][Type.NORMAL.ordinal()] = 0.0;
    }

    public static double effectiveness(
            Type atk,
            Type def
    ) {
        return typeChart[
                atk.ordinal()
        ][
                def.ordinal()
        ];
    }

    public static int calculateDamage(
            Pokemon attacker,
            Pokemon defender,
            Move move
    ) {

        if (move.category ==
                Category.STATUS) {
            return 0;
        }

        double atkStat =
                move.category ==
                        Category.PHYSICAL
                        ? attacker.attack
                        : attacker.spAttack;

        double defStat =
                move.category ==
                        Category.PHYSICAL
                        ? defender.defense
                        : defender.spDefense;

        double effectiveness = 1.0;

        for (Type t : defender.types) {
            effectiveness *=
                    effectiveness(
                            move.type,
                            t
                    );
        }

        double stab = 1.0;

        for (Type t : attacker.types) {

            if (t == move.type) {
                stab = 1.5;
                break;
            }
        }

        double damage =
                (((22.0
                        * move.power
                        * (atkStat / defStat))
                        / 50.0)
                        + 2.0)
                        * stab
                        * effectiveness;

        double percent =
                (damage / defender.hp)
                        * 100.0;

        int rounded =
                (int) Math.ceil(
                        percent / 10.0
                ) * 10;

        return Math.max(
                10,
                rounded
        );
    }
}