public class BattleEdge {

    public State from;
    public State to;

    public Move move1;
    public Move move2;

    public BattleEdge(
            State from,
            State to,
            Move move1,
            Move move2
    ) {
        this.from = from;
        this.to = to;
        this.move1 = move1;
        this.move2 = move2;
    }
}