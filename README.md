## English README

# `The D/N/A DNA`

After carefully analyzing the flying saucer that crashed in the middle of Redenção Park, scientists reached some conclusions about the beings that occupied it (and escaped in a rescue capsule).

Scientists discovered that the DNA of aliens is made up of 3 bases instead of the 4 bases found in Earth's DNA. Ironically, they named the 3 bases D, N, and A. They also found that alien DNA undergoes mutations that deteriorate it over time: two different bases that are adjacent to each other can fuse, producing the third base and creating a slightly shorter DNA strand. This happens in a very organized way:

- In a DNA strand, the fusion of bases always occurs in the leftmost pair of different bases.

- The newly created base from the fusion is added to the end of the DNA strand.

For example, the small DNA strand undergoes deterioration in DN, resulting in the generation of AA. In contrast, a longer strand like DNANDANDANDANADNDDDAN eventually becomes simply N.

`Now the scientists are asking: given a DNA strand, what is the size and which strand can be obtained after all possible mutations?`

You should write an algorithm capable of reading the strands that scientists have placed in various test files and then report the size of the smallest strand that can be obtained in each case.

## Solution

Two solutions were implemented in Java. One of them uses a doubly linked list where each node represents a character in the strand. The other solution uses a stack and a queue to perform the mutations.

The full implementation and explanation can be found in the report in the repository.

---

## Portuguese README

# `O DNA D/N/A`

Depois de analisar cuidadosamente o disco voador que caiu no meio do parque da Redenção, os cientistas chegaram a algumas conclusões sobre os seres que o ocupavam (e que fugiram em uma cápsula de resgate).

Os cientistas descobriram que o DNA dos alienígenas é feito com 3 bases em vez das 4 bases do DNA terrestre. Ironicamente eles batizaram as 3 bases de D, N, e A. Eles também descobriram que o DNA alienígena sofre mutações que o deterioram com o tempo: duas bases diferentes que estão uma ao lado da outra podem se fundir produzindo a terceira base e criando uma cadeia de DNA um pouco menor. Isto acontece de uma forma muito organizada:

- Em uma cadeia de DNA a fusão de bases acontece sempre na dupla de bases diferentes mais à esquerda;

- À nova base criada com a fusão vai ser agregada ao final da cadeia de DNA.

Por exemplo, a pequena cadeia DNA sofre uma deterioração em DN e acaba gerando AA. Já uma cadeia maior como DNANDANDANDANADNDDDAN acaba virando simplesmente N.

`Os cientistas agora perguntam: dada uma cadeia de DNA, qual o tamanho e qual cadeia podem ser obtidos depois de todas as mutações possíveis?`

Você deve escrever um algoritmo capaz de ler as cadeias que os cientistas colocaram em vários arquivos de teste e depois informe o tamanho da menor cadeia que pode ser obtida em cada caso.

## Solução

Foi Implementado em Java duas soluções, sendo uma delas utilizando uma Lista Encadeada Dupla, onde cada nodo representa um caractere da Cadeia. Enquanto a outra solução foi utilizado uma Pilha e uma Filha para realizar as mutações. Toda a implementação e a explicação podem ser vistas no relatório presente no repositório.
