/*
Responsavel pelas analises do grafo.
Ja detecta ciclos e contabiliza estados terminais.
Ainda faltam as perguntas principais do trabalho como melhor Pokemon, chance de vitoria dos times, vitorias inevitaveis e vantagem ou desvantagem de tipo.
*/
import java.util.*;

public class AnalisadorDeCombate {

    public static void analyze(GrafoDeCombate graph) {

        int p1Wins = 0;
        int p2Wins = 0;

        for (EstadoDaBatalha s : graph.states.values()) {

            if (s.hp1 <= 0) {
                p2Wins++;
            }

            if (s.hp2 <= 0) {
                p1Wins++;
            }
        }

        System.out.println("P1 wins: " + p1Wins);
        System.out.println("P2 wins: " + p2Wins);

        detectCycles(graph);
    }

    // Detecta batalhas infinitas
    public static void detectCycles(GrafoDeCombate graph) {

        Set<String> visited =
                new HashSet<>();

        Set<String> stack =
                new HashSet<>();

        for (String node : graph.graph.keySet()) {

            if (dfs(node, graph, visited, stack)) {

                System.out.println(
                        "Infinite battle detected!"
                );

                return;
            }
        }
    }

    private static boolean dfs(
            String node,
            GrafoDeCombate graph,
            Set<String> visited,
            Set<String> stack
    ) {

        if (stack.contains(node)) {
            return true;
        }

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        stack.add(node);

        for (TransicaoDeCombate edge :
                graph.graph.getOrDefault(
                        node,
                        new ArrayList<>()
                )) {

            if (dfs(
                    edge.to.identity(),
                    graph,
                    visited,
                    stack
            )) {
                return true;
            }
        }

        stack.remove(node);

        return false;
    }
}