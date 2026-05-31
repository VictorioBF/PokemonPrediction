/*
Representa um estado da batalha.
Cada estado guarda a vida atual dos dois Pokemon.
A logica principal da simulacao acontece aqui.
*/
public class EstadoDaBatalha {

    public Pokemon p1;
    public Pokemon p2;

    public int hp1;
    public int hp2;

    public EstadoDaBatalha(Pokemon p1, Pokemon p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.hp1 = 100;
        this.hp2 = 100;
    }

    public EstadoDaBatalha(Pokemon p1, Pokemon p2, int hp1, int hp2) {
        this.p1 = p1;
        this.p2 = p2;
        this.hp1 = hp1;
        this.hp2 = hp2;
    }

    public String identity() {
        return p1.name + "_" + hp1 + "_" +
               p2.name + "_" + hp2;
    }

    public boolean finished() {
        return hp1 <= 0 || hp2 <= 0;
    }

    public EstadoDaBatalha step(int move1Index, int move2Index) {

        EstadoDaBatalha next =
                new EstadoDaBatalha(p1, p2, hp1, hp2);

        Golpe move1 = p1.moves.get(move1Index);
        Golpe move2 = p2.moves.get(move2Index);

        boolean p1First =
                p1.speed >= p2.speed;

        if (p1First) {

            apply(next, p1, p2, move1, true);

            apply(next, p2, p1, move2, false);

        } else {

            apply(next, p2, p1, move2, false);

            apply(next, p1, p2, move1, true);
        }

        return next;
    }

    private void apply(
            EstadoDaBatalha next,
            Pokemon attacker,
            Pokemon defender,
            Golpe move,
            boolean attackerIsP1
    ) {

        if (move.name.equals("Recover")) {

            if (attackerIsP1) {
                next.hp1 = Math.min(100, next.hp1 + 50);
            } else {
                next.hp2 = Math.min(100, next.hp2 + 50);
            }

            return;
        }

        int damage =
                CalculadoraDeDano.calculateDamage(
                        attacker,
                        defender,
                        move
                );

        if (attackerIsP1) {
            next.hp2 = Math.max(0, next.hp2 - damage);
        } else {
            next.hp1 = Math.max(0, next.hp1 - damage);
        }
    }
}