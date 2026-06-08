import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int teamAWins = 0;
    static int teamBWins = 0;

    static int[] pokemonWins = new int[12];

    // Guarda o resumo calculado de cada confronto.
    // Esses dados sao usados no final para responder as perguntas de analise,
    // sem precisar reler o arquivo battle_log.txt.
    static List<BattleResult> battleResults = new ArrayList<>();

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

        Logger.logHeader("ANALISE DE BATALHAS POKEMON");

        // Executa todos os confrontos 1 contra 1 entre o Time A e o Time B.
        // Cada chamada de runBattle monta o grafo da batalha e coleta os dados
        // necessarios para as respostas finais.
        for (Pokemon p1 : teamA) {
            for (Pokemon p2 : teamB) {
                runBattle(p1, p2, names);
            }
        }

        Logger.logHeader("RESULTADO FINAL");

        Logger.log("Vitorias do Time A: " + teamAWins);
        Logger.log("Vitorias do Time B: " + teamBWins);

        Logger.logEmptyLine();

        if (teamAWins > teamBWins) {
            Logger.log("Melhor time: Time A");
        } else if (teamBWins > teamAWins) {
            Logger.log("Melhor time: Time B");
        } else {
            Logger.log("Resultado: empate");
        }

        Logger.logHeader("RANKING DOS POKEMON");

        for (int i = 0; i < names.length; i++) {
            Logger.log(names[i] + " -> " + pokemonWins[i] + " " + victoryText(pokemonWins[i]));
        }

        logQuestionAnswers(names);

        Logger.close();
    }

    private static void runBattle(
            Pokemon p1,
            Pokemon p2,
            String[] names) {
        Logger.logHeader(p1.name + " CONTRA " + p2.name);

        State initial = new State(p1, p2);
        BattleGraph graph = new BattleGraph();

        graph.build(initial);

        generateDotFile(p1, p2, graph, p1.name + "_vs_" + p2.name + ".dot");

        // Conta o total de transicoes do grafo.
        // Cada aresta representa uma combinacao de acoes escolhidas pelos dois Pokemon.
        int totalEdges = 0;

        for (var edges : graph.graph.values()) {
            totalEdges += edges.size();
        }

        int p1Wins = 0;
        int p2Wins = 0;

        // Analisa os estados finais do grafo.
        // Se hp2 chegou a zero, o Pokemon 1 venceu naquele estado.
        // Se hp1 chegou a zero, o Pokemon 2 venceu naquele estado.
        for (State s : graph.states.values()) {
            if (s.hp2 <= 0) {
                p1Wins++;
            }
            if (s.hp1 <= 0) {
                p2Wins++;
            }
        }

        Logger.log("Estados: " + graph.states.size());
        Logger.log("Arestas: " + totalEdges);
        Logger.log("Estados de vitoria do Pokemon 1: " + p1Wins);
        Logger.log("Estados de vitoria do Pokemon 2: " + p2Wins);

        // Verifica se existe ciclo no grafo.
        // Um ciclo indica que uma sequencia de acoes pode repetir estados
        // indefinidamente, caracterizando uma possivel batalha interminavel.
        boolean hasInfinitePath = hasCycle(graph);

        // Define o vencedor do confronto pela maior quantidade de estados finais
        // vencedores. Essa contagem alimenta o placar dos times e o ranking individual.
        if (p1Wins > p2Wins) {
            Logger.log("Vencedor: " + p1.name);
            teamAWins++;
            addWin(names, p1.name);
        } else if (p2Wins > p1Wins) {
            Logger.log("Vencedor: " + p2.name);
            teamBWins++;
            addWin(names, p2.name);
        } else {
            Logger.log("Resultado: empate");
        }

        // Armazena o resumo da batalha para as analises finais.
        battleResults.add(new BattleResult(
                p1,
                p2,
                p1Wins,
                p2Wins,
                hasInfinitePath));
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

    private static void logQuestionAnswers(String[] names) {
        Logger.logHeader("RESPOSTAS DAS PERGUNTAS DE ANALISE");

        // Pergunta 1:
        // usa o total de confrontos vencidos por cada time.
        Logger.log("1) Qual dos dois times tem a maior chance de vitoria num embate real?");
        if (teamAWins > teamBWins) {
            Logger.log("Resposta: Time A, com " + teamAWins + " " + victoryText(teamAWins)
                    + " contra " + teamBWins + " " + victoryText(teamBWins) + " do Time B.");
        } else if (teamBWins > teamAWins) {
            Logger.log("Resposta: Time B, com " + teamBWins + " " + victoryText(teamBWins)
                    + " contra " + teamAWins + " " + victoryText(teamAWins) + " do Time A.");
        } else {
            Logger.log("Resposta: empate, com " + teamAWins + " " + victoryText(teamAWins) + " para cada time.");
        }
        Logger.logEmptyLine();

        // Pergunta 2:
        // procura o maior numero de vitorias individuais no ranking de Pokemon.
        // Se mais de um Pokemon tiver o mesmo valor maximo, todos sao listados.
        Logger.log("2) Qual Pokemon possui o melhor desempenho geral nos combates analisados?");
        int bestWins = 0;
        for (int wins : pokemonWins) {
            bestWins = Math.max(bestWins, wins);
        }
        List<String> bestPokemon = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            if (pokemonWins[i] == bestWins) {
                bestPokemon.add(names[i]);
            }
        }
        Logger.log("Resposta: " + String.join(", ", bestPokemon) + ", com " + bestWins + " " + victoryText(bestWins) + ".");
        Logger.logEmptyLine();

        // Pergunta 3:
        // verifica confrontos em que apenas um dos Pokemon possui estados finais
        // de vitoria. Isso indica vitoria exclusiva nos estados finais analisados.
        Logger.log("3) Existe alguma batalha que um Pokemon sempre venca, independente das acoes tomadas?");
        List<String> guaranteedWins = new ArrayList<>();
        for (BattleResult result : battleResults) {
            if (result.p1Wins > 0 && result.p2Wins == 0) {
                guaranteedWins.add(result.p1.name + " sempre vence " + result.p2.name
                        + " nos estados finais analisados");
            } else if (result.p2Wins > 0 && result.p1Wins == 0) {
                guaranteedWins.add(result.p2.name + " sempre vence " + result.p1.name
                        + " nos estados finais analisados");
            }
        }
        if (guaranteedWins.isEmpty()) {
            Logger.log("Resposta: nao foi encontrada nenhuma batalha com vitoria exclusiva de um Pokemon.");
        } else {
            Logger.log("Resposta: sim. Casos encontrados:");
            for (String guaranteedWin : guaranteedWins) {
                Logger.log("- " + guaranteedWin);
            }
            Logger.log("Observacao: isso considera os estados finais de vitoria. Se houver ciclos, uma sequencia de acoes pode repetir estados antes de terminar.");
        }
        Logger.logEmptyLine();

        // Pergunta 4:
        // usa a deteccao de ciclos feita em cada grafo de batalha.
        // Se existe ciclo, existe ao menos um caminho que pode repetir estados.
        Logger.log("4) Existem estados em que a batalha se torna interminavel?");
        List<String> infiniteBattles = new ArrayList<>();
        for (BattleResult result : battleResults) {
            if (result.hasInfinitePath) {
                infiniteBattles.add(result.p1.name + " CONTRA " + result.p2.name);
            }
        }
        if (infiniteBattles.isEmpty()) {
            Logger.log("Resposta: nao foram detectados ciclos nos grafos de batalha.");
        } else {
            Logger.log("Resposta: sim. Foram detectados ciclos em " + infiniteBattles.size() + " batalhas:");
            for (String infiniteBattle : infiniteBattles) {
                Logger.log("- " + infiniteBattle);
            }
        }
        Logger.logEmptyLine();

        // Pergunta 5:
        // compara a melhor efetividade de tipo do vencedor contra o perdedor
        // com a melhor efetividade do perdedor contra o vencedor.
        // Se o vencedor tem efetividade menor e ainda venceu, ele venceu em desvantagem.
        Logger.log("5) Existem casos em que um Pokemon em desvantagem de tipo ainda consegue vencer?");
        List<String> typeDisadvantageWins = new ArrayList<>();
        for (BattleResult result : battleResults) {
            Pokemon winner = result.winner();
            Pokemon loser = result.loser();

            if (winner != null && hasTypeDisadvantage(winner, loser)) {
                double winnerEffectiveness = bestOffensiveEffectiveness(winner, loser);
                double loserEffectiveness = bestOffensiveEffectiveness(loser, winner);
                typeDisadvantageWins.add(winner.name + " venceu " + loser.name
                        + " mesmo com efetividade de tipo menor ("
                        + formatEffectiveness(winnerEffectiveness) + "x contra "
                        + formatEffectiveness(loserEffectiveness) + "x)");
            }
        }
        if (typeDisadvantageWins.isEmpty()) {
            Logger.log("Resposta: nao foram encontrados casos desse tipo.");
        } else {
            Logger.log("Resposta: sim. Casos encontrados:");
            for (String typeDisadvantageWin : typeDisadvantageWins) {
                Logger.log("- " + typeDisadvantageWin);
            }
        }
    }

    private static boolean hasTypeDisadvantage(Pokemon winner, Pokemon loser) {
        return bestOffensiveEffectiveness(winner, loser)
                < bestOffensiveEffectiveness(loser, winner);
    }

    // Calcula a melhor efetividade de tipo ofensiva entre os golpes de dano
    // de um Pokemon contra os tipos defensivos do outro Pokemon.
    private static double bestOffensiveEffectiveness(Pokemon attacker, Pokemon defender) {
        double best = 0.0;

        for (Move move : attacker.moves) {
            if (move.category == Category.STATUS) {
                continue;
            }

            double effectiveness = 1.0;
            for (Type type : defender.types) {
                effectiveness *= DamageCalculator.effectiveness(move.type, type);
            }

            best = Math.max(best, effectiveness);
        }

        return best;
    }

    private static String formatEffectiveness(double value) {
        if (value == (int) value) {
            return String.valueOf((int) value);
        }

        return String.valueOf(value);
    }

    private static String victoryText(int wins) {
        return wins == 1 ? "vitoria" : "vitorias";
    }

    // Detecta se o grafo possui ciclos usando busca em profundidade.
    // visited guarda estados ja analisados; stack guarda o caminho atual da busca.
    // Se a busca encontra um estado que ja esta na stack, existe ciclo.
    private static boolean hasCycle(BattleGraph graph) {
        Set<String> visited = new HashSet<>();
        Set<String> stack = new HashSet<>();

        for (String node : graph.graph.keySet()) {
            if (hasCycle(node, graph, visited, stack)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasCycle(
            String node,
            BattleGraph graph,
            Set<String> visited,
            Set<String> stack) {
        if (stack.contains(node)) {
            return true;
        }

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        stack.add(node);

        for (BattleEdge edge : graph.graph.getOrDefault(node, new ArrayList<>())) {
            if (hasCycle(edge.to.identity(), graph, visited, stack)) {
                return true;
            }
        }

        stack.remove(node);
        return false;
    }

    // Resultado resumido de uma batalha.
    // Ele separa os dados calculados durante a simulacao da etapa final,
    // que apenas interpreta esses dados para responder as perguntas.
    private static class BattleResult {
        Pokemon p1;
        Pokemon p2;
        int p1Wins;
        int p2Wins;
        boolean hasInfinitePath;

        BattleResult(
                Pokemon p1,
                Pokemon p2,
                int p1Wins,
                int p2Wins,
                boolean hasInfinitePath) {
            this.p1 = p1;
            this.p2 = p2;
            this.p1Wins = p1Wins;
            this.p2Wins = p2Wins;
            this.hasInfinitePath = hasInfinitePath;
        }

        Pokemon winner() {
            if (p1Wins > p2Wins) {
                return p1;
            }

            if (p2Wins > p1Wins) {
                return p2;
            }

            return null;
        }

        Pokemon loser() {
            if (p1Wins > p2Wins) {
                return p2;
            }

            if (p2Wins > p1Wins) {
                return p1;
            }

            return null;
        }
    }
}
