/*
Calcula o dano simplificado.
A discretizacao da vida em blocos de 10 por cento esta implementada.
Falta completar a tabela de tipos, atualmente apenas alguns tipos basicos foram cadastrados.
*/
public class CalculadoraDeDano {

    public static double[][] typeChart = new double[18][18];

    static {

        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 18; j++) {
                typeChart[i][j] = 1.0;
            }
        }

        typeChart[Tipo.FIRE.ordinal()][Tipo.GRASS.ordinal()] = 2;
        typeChart[Tipo.WATER.ordinal()][Tipo.FIRE.ordinal()] = 2;
        typeChart[Tipo.GRASS.ordinal()][Tipo.WATER.ordinal()] = 2;

        typeChart[Tipo.FIRE.ordinal()][Tipo.WATER.ordinal()] = 0.5;
        typeChart[Tipo.WATER.ordinal()][Tipo.GRASS.ordinal()] = 0.5;
        typeChart[Tipo.GRASS.ordinal()][Tipo.FIRE.ordinal()] = 0.5;
    }

    public static double effectiveness(Tipo atk, Tipo def) {
        return typeChart[atk.ordinal()][def.ordinal()];
    }

    public static int calculateDamage(
            Pokemon attacker,
            Pokemon defender,
            Golpe move
    ) {

        if (move.category == CategoriaGolpe.STATUS) {
            return 0;
        }

        double atkStat =
                move.category == CategoriaGolpe.PHYSICAL
                        ? attacker.attack
                        : attacker.spAttack;

        double defStat =
                move.category == CategoriaGolpe.PHYSICAL
                        ? defender.defense
                        : defender.spDefense;

        double effectiveness = 1.0;

        for (Tipo t : defender.types) {
            effectiveness *= effectiveness(move.type, t);
        }

        double stab = 1.0;

        for (Tipo t : attacker.types) {
            if (t == move.type) {
                stab = 1.5;
                break;
            }
        }

        double damage =
                (((22.0 * move.power * (atkStat / defStat)) / 50.0) + 2.0)
                        * stab
                        * effectiveness;

        double percent = (damage / defender.hp) * 100.0;

        int rounded =
                (int) Math.ceil(percent / 10.0) * 10;

        return Math.max(10, rounded);
    }
}