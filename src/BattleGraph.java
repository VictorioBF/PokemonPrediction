import java.util.*;

public class BattleGraph {

    // HASH TABLE
    public Map<String, State> states =
            new HashMap<>();

    // GRAFO
    public Map<String, List<BattleEdge>> graph =
            new HashMap<>();

    // HEAP
    public PriorityQueue<State> heap =
            new PriorityQueue<>(
                    Comparator.comparingInt(
                            s -> s.hp1 + s.hp2
                    )
            );

    public void build(State initial) {

        states.put(initial.identity(), initial);

        heap.add(initial);

        while (!heap.isEmpty()) {

            State current = heap.poll();

            if (current.finished()) {
                continue;
            }

            graph.putIfAbsent(
                    current.identity(),
                    new ArrayList<>()
            );

            for (int i = 0; i < current.p1.moves.size(); i++) {

                for (int j = 0; j < current.p2.moves.size(); j++) {

                    State next =
                            current.step(i, j);

                    String id =
                            next.identity();

                    if (!states.containsKey(id)) {

                        states.put(id, next);

                        heap.add(next);
                    }

                    BattleEdge edge =
                            new BattleEdge(
                                    current,
                                    states.get(id),
                                    current.p1.moves.get(i),
                                    current.p2.moves.get(j)
                            );

                    graph.get(current.identity())
                            .add(edge);
                }
            }
        }
    }
}