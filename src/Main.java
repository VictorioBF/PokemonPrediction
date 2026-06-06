import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int teamAWins = 0;
    static int teamBWins = 0;

    static Map<Pokemon, Integer> pokemonWins = new HashMap<>();
//    static Map<Pokemon, Integer> pokemonRoundsWon = new HashMap<>();

    static ArrayList<String> disadvantagedBattles = new ArrayList<>();
    static ArrayList<String> endlessBattles = new ArrayList<>();
    static ArrayList<String> unfairBattles = new ArrayList<>();

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

        Logger.logHeader("POKEMON METAGAME ANALYSIS");

        for (Pokemon p1 : teamA) {
            for (Pokemon p2 : teamB) {
                runBattle(p1, p2);
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

        Logger.log("By no. of won battles:");
        pokemonWins.entrySet()
                .stream()
                .sorted(Map.Entry.<Pokemon, Integer>comparingByValue().reversed())
                .forEach(pokewin ->
                    Logger.log(pokewin.getKey().name + " -> " + pokewin.getValue() + " victories")
                );

        // Imprime a quantidade de estados que cada pokémon venceu
//        Logger.logEmptyLine();
//        Logger.log("By no. of won rounds/states:");
//        pokemonRoundsWon.entrySet()
//                .stream()
//                .sorted(Map.Entry.<Pokemon, Integer>comparingByValue().reversed())
//                .forEach(pokewin ->
//                        Logger.log(pokewin.getKey().name + " -> " + pokewin.getValue() + " rounds/states won")
//                );

        // Batalhas vencidas contra oponentes com vantagem de tipo
        if (!disadvantagedBattles.isEmpty()) {
            Logger.logEmptyLine();
            Logger.log("Battle won in disadvantage:");
            for (String db: disadvantagedBattles)
                Logger.log(db);
        } else {
            Logger.log("No battles were won while in type disadvantage");
        }

        // Batalhas injustas (um pokémon não ganha em nenhum estado)
        if (!unfairBattles.isEmpty()) {
            Logger.logEmptyLine();
            Logger.log("Unfair battles (a pokémon didn't win a single state):");
            for (String ub: unfairBattles)
                Logger.log(ub);
        } else {
            Logger.log("No battles were won while in type disadvantage");
        }

        // Batalhas com ciclo (intermináveis)
        if (endlessBattles.size() == 36) { // 36 é o máximo de batalhas entre times de 6
            Logger.logEmptyLine();
            Logger.log("Every single battle is endless!");
        } else {
            Logger.logEmptyLine();
            Logger.log("Total endless battles: " + endlessBattles.size());
            for (String eb: endlessBattles)
                Logger.log(eb);
        }

        Logger.close();
    }

    private static void runBattle(
            Pokemon p1,
            Pokemon p2) {
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

//        pokemonRoundsWon.put(p1, pokemonRoundsWon.getOrDefault(p1, 0) + p1Wins);
//        pokemonRoundsWon.put(p2, pokemonRoundsWon.getOrDefault(p2, 0) + p2Wins);

        Logger.logSeparator();

        Logger.log(p1.name + " VS " + p2.name + " Battle result");
        Logger.logEmptyLine();

        Logger.log("States: " + graph.states.size());
        Logger.log("Edges: " + totalEdges);
        Logger.log(p1.name + " winning states: " + p1Wins);
        Logger.log(p2.name + " winning states: " + p2Wins);

        boolean isEndless = GraphAnalyzer.detectCycles(graph);
        Logger.log("Can be endless? " + (isEndless ? "Yes" : "No"));

        if (isEndless)
            endlessBattles.add(p1.name + " VS " + p2.name + " can be endless!");

        Pokemon winner;
        Pokemon loser;

        if (p1Wins > p2Wins) {
            winner = p1;
            loser = p2;
        } else if (p2Wins > p1Wins) {
            winner = p2;
            loser = p1;
        } else {
            Logger.log("Result: Draw");
            return;
        }

        if (p1Wins == 0 || p2Wins == 0)
            unfairBattles.add(loser.name + " cannot defeated " + winner.name);

        Logger.log("Winner: " + winner.name);
        teamAWins++;
        pokemonWins.put(winner, pokemonWins.getOrDefault(winner, 0) + 1);
        if (winner.isWeakAgainst(loser)) {
            Logger.log(winner.name + " was in disadvantage against " + loser.name + ", but still won!");
            disadvantagedBattles.add(winner.name + " was in disadvantage against " + loser.name + ", but still won!");
        }
    }

    private static void generateDotFile(Pokemon first, Pokemon second, BattleGraph graph, String filename) {
        var dotFile = new DotFile(first.name + "_vs_" + second.name);
        dotFile.addPokemon(first, 0);
        dotFile.addPokemon(second, 1);
        for (var state : graph.states.values()) {
            dotFile.addState(state);
        }
        for (var battleEdge : graph.graph.values()) {
            for (var edge : battleEdge) {
                dotFile.addBattleEdge(edge);
            }
        }
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
