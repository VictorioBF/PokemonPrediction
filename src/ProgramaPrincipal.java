/*
Arquivo principal.
Hoje executa apenas uma batalha entre Charizard e Blastoise.
Falta criar dois times com 6 Pokemon cada e executar todas as 36 combinacoes exigidas pelo trabalho.
*/
public class ProgramaPrincipal {

    public static void main(String[] args) {

        Pokemon p1 =
                FabricaDeDados.charizard();

        Pokemon p2 =
                FabricaDeDados.blastoise();

        EstadoDaBatalha initial =
                new EstadoDaBatalha(p1, p2);

        GrafoDeCombate graph =
                new GrafoDeCombate();

        graph.build(initial);

        System.out.println(
                "Total states: "
                + graph.states.size()
        );

        AnalisadorDeCombate.analyze(graph);
    }
}