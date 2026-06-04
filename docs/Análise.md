---
title: Análise de batalhas Pokémon
author: Lucas R. F. da Silva, Pedro Magedanz e Victorio Faraco
date: \today
geometry: margin=2cm
lang: pt
pagesize: A4
linestretching: 1.5
---

## Introdução

O documento a seguir apresenta uma análise do combate entre dois times Pokémon. Para realização do trabalho, foram simulados combates *1x1* entre os Pokémon de cada time. Os times escolhidos para a análise foram:

| Time A   | Time B    |
|--------------- | --------------- |
| Charizard   | Blastoise   |
| Venusaur   | Arcanine   |
| Gengar   | Sceptile   |
| Garchomp   | Alakazam   |
| Pikachu | Jolteon |
| Lapras | Dragonite |

### Golpes escolhidos

Para simplificar a análise, foram considerados apenas dois golpes por Pokémon: um golpe ofensivo e o *Recover*, o qual todos têm acesso, e que recupera 50% da vida do Pokémon.

#### Golpes do Time A

| Pokémon | Golpe |
|--------------- | --------------- |
|Charizard | Flamethrower |
|Venusaur | LeafStorm |
|Gengar | ShadowBall |
|Garchomp | Earthquake |
|Pikachu | Thunderbolt |
|Lapras | HydroPump |

#### Golpes do Time B

| Pokémon | Golpe |
|--------------- | --------------- |
| Blastoise | HydroPump |
| Arcanine | Flamethrower |
| Sceptile | LeafStorm |
| Alakazam | ShadowBall |
| Jolteon | Thunderbolt |
| Dragonite | Earthquake |

### Critério de vitória

Para determinar a vitória de um Pokémon ou de outro em determinado combate, considerou-se a quantidade total de estados em que o Pokémon se saiu vitorioso. Por exemplo, se o *Pikachu* venceu o *Jolteon* em 3 estados diferentes, mas o *Jolteon* venceu o *Pikachu* em 4 estados, então o vencedor do combate entre os dois seria o *Jolteon*. Da mesma forma, se o *Pikachu* venceu o *Jolteon* em 3 estados, e o *Jolteon* venceu o *Pikachu* em 3 estados, então não há vencedor e o combate é considerado um empate.

Assim, para fins de somatório de quantidade de vitórias para o time A ou B, somou-se a quantidade de vitórias de cada Pokémon do time, e o time com mais vitórias é considerado o vencedor geral.

## Análise dos combates

### 1 - Qual dos dois times tem a maior chance de vitória?

Após a execução da simulação, vemos que o Time B tem uma leve vantagem sobre o Time A. Enquanto que o Time A venceu 12 combates, o Time B venceu 15. A conclusão que podemos tirar disso é que os Pokémon do Time B têm superioridade em relação aos do Time A, seja por terem mais pontos de vida, ou por serem mais rápidos, ou por terem mais força de ataque.

### 2 - Qual Pokémon possui o melhor desempenho geral nos combates analisados?

Dois Pokémon empataram como os melhores do combate: o Blastoise e o Venusaur. Ambos venceram 4 combates, o que é o maior número de vitórias entre os Pokémon analisados. Em segundo lugar, também empatados, seguem Charizard, Garchomp, Arcanine e Dragonite, com 3 vitórias cada.

### 3 - Existe alguma batalha que um Pokémon sempre vença, independente das ações tomadas?

### 4 - Existem estados em que a batalha se torna interminável?

Sim, e isso surge, em grande parte, pela mecânica do *Recover*. Por exemplo, se ambos os Pokémon começarem com o movimento *Recover*, nenhum tomará dano, e o próximo turno estará no mesmo estado que o inicial. Assim sucessivamente.

O ciclo só será quebrado no instante em que um dos Pokémon escolher um golpe ofensivo, de forma a causar dano ao oponente, até que ele perca.

### 5 - Existem casos em que um Pokémon em desvantagem de tipo ainda consegue vencer?

Sim. Um exemplo é o da batalha entre o *Pikachu* e o *Blastoise*. O *Pikachu*, sendo um Pokémon do tipo elétrico, tem vantagem sobre o *Blastoise*, que é do tipo água. No entanto, as estatísticas do *Blastoise* são superiores às do *Pikachu*, o que faz com que ele vença a batalha, mesmo estando em desvantagem de tipo.

Claro, há estados em que o *Pikachu* vence o *Blastoise*, mas a maioria dos estados leva à vitória do *Blastoise*.

![Pikachu vs Blastoise](./Pikachu_vs_Blastoise.png){width=60%}


