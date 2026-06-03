public class State {

    public Pokemon p1;
    public Pokemon p2;

    public int hp1;
    public int hp2;

    public State(Pokemon p1, Pokemon p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.hp1 = 100;
        this.hp2 = 100;
    }

    public State(Pokemon p1, Pokemon p2, int hp1, int hp2) {
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

    public State step(int move1Index, int move2Index) {

        State next =
                new State(p1, p2, hp1, hp2);

        Move move1 = p1.moves.get(move1Index);
        Move move2 = p2.moves.get(move2Index);

        Logger.log("");
        Logger.log("================================");
        Logger.log(
                p1.name + " (" + hp1 + "%)"
        );
        Logger.log(
                p2.name + " (" + hp2 + "%)"
        );
        Logger.log(
                p1.name + " escolheu: "
                + move1.name
        );
        Logger.log(
                p2.name + " escolheu: "
                + move2.name
        );

        boolean p1First =
                p1.speed >= p2.speed;

        if (p1First) {

            apply(next, p1, p2, move1, true);

            if (!next.finished()) {
                apply(next, p2, p1, move2, false);
            }

        } else {

            apply(next, p2, p1, move2, false);

            if (!next.finished()) {
                apply(next, p1, p2, move1, true);
            }
        }

        return next;
    }

    private void apply(
            State next,
            Pokemon attacker,
            Pokemon defender,
            Move move,
            boolean attackerIsP1
    ) {

        if (move.name.equals("Recover")) {

            Logger.log(
                    attacker.name
                    + " usou Recover"
            );

            if (attackerIsP1) {

                int before = next.hp1;

                next.hp1 =
                        Math.min(
                                100,
                                next.hp1 + 50
                        );

                Logger.log(
                        "HP: "
                        + before
                        + "% -> "
                        + next.hp1
                        + "%"
                );

            } else {

                int before = next.hp2;

                next.hp2 =
                        Math.min(
                                100,
                                next.hp2 + 50
                        );

                Logger.log(
                        "HP: "
                        + before
                        + "% -> "
                        + next.hp2
                        + "%"
                );
            }

            return;
        }

        double effectiveness = 1.0;

        for (Type t : defender.types) {

            effectiveness *=
                    DamageCalculator.effectiveness(
                            move.type,
                            t
                    );
        }

        int damage =
                DamageCalculator.calculateDamage(
                        attacker,
                        defender,
                        move
                );

        Logger.log(
                attacker.name
                + " usou "
                + move.name
        );

        Logger.log(
                "Dano: "
                + damage
                + "%"
        );

        if (effectiveness > 1) {

            Logger.log(
                    "Super efetivo!"
            );

        } else if (
                effectiveness < 1
                && effectiveness > 0
        ) {

            Logger.log(
                    "Pouco efetivo!"
            );

        } else if (
                effectiveness == 0
        ) {

            Logger.log(
                    "Sem efeito!"
            );
        }

        if (attackerIsP1) {

            int before = next.hp2;

            next.hp2 =
                    Math.max(
                            0,
                            next.hp2 - damage
                    );

            Logger.log(
                    defender.name
                    + ": "
                    + before
                    + "% -> "
                    + next.hp2
                    + "%"
            );

        } else {

            int before = next.hp1;

            next.hp1 =
                    Math.max(
                            0,
                            next.hp1 - damage
                    );

            Logger.log(
                    defender.name
                    + ": "
                    + before
                    + "% -> "
                    + next.hp1
                    + "%"
            );
        }

        if (next.hp1 <= 0) {

            Logger.log(
                    p1.name + " foi derrotado!"
            );
        }

        if (next.hp2 <= 0) {

            Logger.log(
                    p2.name + " foi derrotado!"
            );
        }
    }
}