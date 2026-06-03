public class Main {

    public static void main(String[] args) {

        Pokemon p1 =
                DataFactory.charizard();

        Pokemon p2 =
                DataFactory.blastoise();

        State initial =
                new State(p1, p2);

        BattleGraph graph =
                new BattleGraph();

        graph.build(initial);

        System.out.println(
                "Total states: "
                + graph.states.size()
        );

        GraphAnalyzer.analyze(graph);
    }
}