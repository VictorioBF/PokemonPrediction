---
title: Análise de batalhas Pokémon
author: Lucas R. F. da Silva, Pedro Magedanz e Victorio Faraco
date: \today
geometry: margin=2cm
lang: pt
pagesize: A4
linestretch: 1.5
fontsize: 12pt
header-includes:
    - \usepackage{titling}
    - \setlength{\droptitle}{-2cm}
---

## Introdução

O documento a seguir apresenta uma análise do combate entre dois times Pokémon. Para realização do trabalho, foram simulados combates *1 vs. 1* entre os Pokémon de cada time. Os times escolhidos para a análise foram:

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

Após a execução da simulação, verificamos um empate: 13 vitórias para cada lado. Com isso, conclui-se que, pelo fato de ambos os times serem compostos por Pokémon similares, com os mesmos moviimentos, um empate é esperado. As diferenças de vida, força, velocidade, defesa, etc., não foram suficientes para que um time se sobressaísse sobre o outro, o que resultou em um empate geral.

### 2 - Qual Pokémon possui o melhor desempenho geral nos combates analisados?

O Pokémon que levou vantagem sobre os damis foi o *Venusaur*, com 4 vitórias. Em segundo lugar, com 3 vitórias, estão empatados *Charizard*, *Garchomp*, *Lapras*, *Blastoise*, *Arcanine* e *Dragonite*. Os Pokémon com o pior desempenho foram *Gengar* e *Pikachu*, que não venceram nenhum combate.

#### Vitórias dos Pokémon do Time A

| Pokémon | Vitórias |
|--------------- | --------------- |
| Charizard | 3 |
| Venusaur | 4 |
| Gengar | 0 |
| Garchomp | 3 |
| Pikachu | 0 |
| Lapras | 3 |

#### Vitórias dos Pokémon do Time B

| Pokémon | Vitórias |
|--------------- | --------------- |
| Blastoise | 3 |
| Arcanine | 3 |
| Sceptile | 1 |
| Alakazam | 1 |
| Jolteon | 2 |
| Dragonite | 3 |

### 3 - Existe alguma batalha que um Pokémon sempre vença, independente das ações tomadas?

Sim. O combate entre *Charizard* e *Blastoise*, por exemplo, ocasiona em uma vitória do *Blastoise* em todos os estados possíveis. Isso se deve ao fato de o *Blastoise* ser um Pokémon do tipo água, o que lhe dá vantagem sobre o *Charizard*, que é do tipo fogo.

![Charizard vs Blastoise](./Charizard_vs_Blastoise.png){width=60%}

Abaixo está a tabela com todos os combates em que um Pokémon sempre vence, independente das ações tomadas:

| Combate | Vencedor |
|--------------- | --------------- |
| Blastoise vs. Charizard | Blastoise |
| Charizard vs. Sceptile | Charizard |
| Charizard vs. Dragonite | Charizard |
| Venusaur vs. Blastoise | Venusaur |
| Venusaur vs. Jolteon | Venusaur |
| Garchomp vs. Jolteon | Garchomp |
| Dragonite vs. Garchomp | Dragonite |
| Arcanine vs. Pikachu | Arcanine |
| Sceptile vs. Pikachu | Sceptile |
| Jolteon vs. Pikachu | Jolteon |
| Arcanine vs. Lapras | Arcanine |
| Lapras vs. Alakazam | Lapras |

### 4 - Existem estados em que a batalha se torna interminável?

Todas as batalhas são *intermináveis*, a não ser que seja estabelecido um limite de turnos. Isso é causado pela habilidade *Recover*, que recupera 50% da vida de um Pokémon.

Como o *Recover* não possui limites ou condições, de modo a poder utilizá-lo a qualquer momento, é possível que ambos os Pokémon fiquem apenas usando o *Recover* e, assim, nunca acabem a batalha. Abaixo está um exemplo, onde o *Charizard* e o *Alakazam* ficam apenas usando o *Recover*.

![Charizard vs Alakazam](./Charizard_vs_Alakazam.png){width=60%}

### 5 - Existem casos em que um Pokémon em desvantagem de tipo ainda consegue vencer?

Sim: a batalha entre o *Pikachu* e o *Blastoise*. O *Pikachu*, sendo um Pokémon do tipo elétrico, tem vantagem sobre o *Blastoise*, que é do tipo água. No entanto, as estatísticas do *Blastoise* são superiores às do *Pikachu*, o que faz com que ele vença a batalha, mesmo estando em desvantagem de tipo.

Claro, há estados em que o *Pikachu* vence o *Blastoise*, mas a maioria dos estados leva à vitória do *Blastoise*.

![Pikachu vs Blastoise](./Pikachu_vs_Blastoise.png){width=60%}
