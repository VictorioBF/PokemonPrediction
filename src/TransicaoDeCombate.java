/*
Representa uma aresta do grafo.
Cada aresta liga um estado ao proximo estado gerado por uma combinacao de golpes.
*/
public class TransicaoDeCombate {

    public EstadoDaBatalha from;
    public EstadoDaBatalha to;

    public Golpe move1;
    public Golpe move2;

    public TransicaoDeCombate(
            EstadoDaBatalha from,
            EstadoDaBatalha to,
            Golpe move1,
            Golpe move2
    ) {
        this.from = from;
        this.to = to;
        this.move1 = move1;
        this.move2 = move2;
    }
}