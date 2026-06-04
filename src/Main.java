import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    static int teamAWins = 0;
    static int teamBWins = 0;

    static int[] pokemonWins = new int[12];

    public static void main(String[] args) {
        Pokemon[] teamA = {
                DataFactory.charizard(),
                DataFactory.venusaur(),
                DataFactory.gengar(),
                DataFactory.garchomp(),
                DataFactory.pikachu(),
                DataFactory.lapras()
        };

        Pokemon[] teamB = {
                DataFactory.blastoise(),
                DataFactory.arcanine(),
                DataFactory.sceptile(),
                DataFactory.alakazam(),
                DataFactory.jolteon(),
                DataFactory.dragonite()
        };

        String[] names = {
                "Charizard",
                "Venusaur",
                "Gengar",
                "Garchomp",
                "Pikachu",
                "Lapras",
                "Blastoise",
                "Arcanine",
                "Sceptile",
                "Alakazam",
                "Jolteon",
                "Dragonite"
        };

        Logger.logHeader("POKEMON METAGAME ANALYSIS");

        for (Pokemon p1 : teamA) {
            for (Pokemon p2 : teamB) {
                runBattle(p1, p2, names);
            }
        }

        Logger.logHeader("FINAL RESULT");

        Logger.log("Team A wins: " + teamAWins);
        Logger.log("Team B wins: " + teamBWins);

        Logger.logEmptyLine();

        if (teamAWins > teamBWins) {
            Logger.log("Best Team: Team A");
        } else if (teamBWins > teamAWins) {
            Logger.log("Best Team: Team B");
        } else {
            Logger.log("Result: Draw");
        }

        Logger.logHeader("POKEMON RANKING");

        for (int i = 0; i < names.length; i++) {
            Logger.log(names[i] + " -> " + pokemonWins[i] + " victories");
        }

        Logger.close();
    }

    private static void runBattle(
            Pokemon p1,
            Pokemon p2,
            String[] names) {
        Logger.logHeader(p1.name + " VS " + p2.name);

        State initial = new State(p1, p2);
        BattleGraph graph = new BattleGraph();

        graph.build(initial);

        generateDotFile(p1, p2, graph, p1.name + "_vs_" + p2.name + ".dot");

        int totalEdges = 0;

        for (var edges : graph.graph.values()) {
            totalEdges += edges.size();
        }

        int p1Wins = 0;
        int p2Wins = 0;

        for (State s : graph.states.values()) {
            if (s.hp2 <= 0) {
                p1Wins++;
            }
            if (s.hp1 <= 0) {
                p2Wins++;
            }
        }

        Logger.log("States: " + graph.states.size());
        Logger.log("Edges: " + totalEdges);
        Logger.log("P1 winning states: " + p1Wins);
        Logger.log("P2 winning states: " + p2Wins);

        if (p1Wins > p2Wins) {
            Logger.log("Winner: " + p1.name);
            teamAWins++;
            addWin(names, p1.name);
        } else if (p2Wins > p1Wins) {
            Logger.log("Winner: " + p2.name);
            teamBWins++;
            addWin(names, p2.name);
        } else {
            Logger.log("Result: Draw");
        }
    }

    private static void addWin(
            String[] names,
            String pokemon) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(pokemon)) {
                pokemonWins[i]++;
                return;
            }
        }
    }

    private static void generateDotFile(Pokemon first, Pokemon second, BattleGraph graph, String filename) {
        var dotFile = new DotFile(first.name + "_vs_" + second.name);
        dotFile.addPokemon(first, 0);
        dotFile.addPokemon(second, 1);
        var dotFileContent = dotFile.toString();
        try {
            var writer = new PrintWriter(new FileWriter(filename));
            writer.write(dotFileContent);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
