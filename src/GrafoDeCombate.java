/*
Responsavel por construir o grafo de estados da batalha.

Esta e a classe principal do trabalho, pois nela sao utilizadas
as tres estruturas exigidas pelo enunciado:

Hash Table
Grafo
Heap

Tambem e aqui que ocorre o reaproveitamento de estados equivalentes.
*/
import java.util.*;

public class GrafoDeCombate {

    /*
    HASH TABLE

    Armazena todos os estados ja descobertos durante a exploracao.

    A chave e uma identificacao unica do estado.
    O valor e o proprio objeto EstadoDaBatalha.

    Essa estrutura permite verificar rapidamente se um estado
    ja foi criado anteriormente.

    Isso atende ao requisito do trabalho de reutilizar estados
    equivalentes e evitar duplicacao de nodos no grafo.
    */
    public Map<String, EstadoDaBatalha> states =
            new HashMap<>();

    /*
    GRAFO

    Estrutura principal utilizada para representar o combate.

    Cada chave representa um estado da batalha.
    A lista associada contem todas as transicoes possiveis
    a partir daquele estado.

    Vertice = EstadoDaBatalha
    Aresta = TransicaoDeCombate
    */
    public Map<String, List<TransicaoDeCombate>> graph =
            new HashMap<>();

    /*
    HEAP

    Fila de prioridade utilizada durante a construcao do grafo.

    Ela controla quais estados ainda precisam ser processados.

    O trabalho pede o uso de Heap e a implementacao escolhida
    foi PriorityQueue da biblioteca Java.
    */
    public PriorityQueue<EstadoDaBatalha> heap =
            new PriorityQueue<>(
                    Comparator.comparingInt(
                            s -> s.hp1 + s.hp2
                    )
            );

    /*
    Constrói o grafo completo a partir de um estado inicial.

    O algoritmo continua expandindo estados ate que nao existam
    mais estados pendentes na heap.
    */
    public void build(EstadoDaBatalha initial) {

        // Registra o primeiro estado na Hash Table
        states.put(initial.identity(), initial);

        // Adiciona o estado inicial na Heap
        heap.add(initial);

        while (!heap.isEmpty()) {

            // Remove da Heap o proximo estado a ser expandido
            EstadoDaBatalha current = heap.poll();

            // Se a batalha terminou nao existem novos estados
            if (current.finished()) {
                continue;
            }

            // Cria a lista de arestas do vertice atual
            graph.putIfAbsent(
                    current.identity(),
                    new ArrayList<>()
            );

            /*
            Testa todas as combinacoes de golpes.

            Cada combinacao gera uma possivel transicao
            dentro do grafo.
            */
            for (int i = 0; i < current.p1.moves.size(); i++) {

                for (int j = 0; j < current.p2.moves.size(); j++) {

                    // Gera o proximo estado da batalha
                    EstadoDaBatalha next =
                            current.step(i, j);

                    String id =
                            next.identity();

                    /*
                    Verifica na Hash Table se o estado
                    ja foi criado anteriormente.

                    Se nao existir, ele e armazenado
                    e colocado na Heap para processamento.
                    */
                    if (!states.containsKey(id)) {

                        states.put(id, next);

                        heap.add(next);
                    }

                    /*
                    Cria uma aresta ligando o estado atual
                    ao estado resultante da combinacao de golpes.
                    */
                    TransicaoDeCombate edge =
                            new TransicaoDeCombate(
                                    current,
                                    states.get(id),
                                    current.p1.moves.get(i),
                                    current.p2.moves.get(j)
                            );

                    // Adiciona a aresta ao grafo
                    graph.get(current.identity())
                            .add(edge);
                }
            }
        }
    }
}