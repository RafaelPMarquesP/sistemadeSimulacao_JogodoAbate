# Sistema de Simulação – Jogo do Abate (Java)

Este projeto foi desenvolvido em **Java** como exercício prático para treinar conceitos fundamentais de programação aprendidos durante o curso de **Tecnologia em Sistemas para Internet**. A ideia do sistema é simular um “jogo do abate”, inspirado em batalhas entre personagens, onde jogadores entram em um sistema, podem lutar entre si, tentar escapar ou morrer durante o processo.

A aplicação funciona em **modo console**, ou seja, toda interação acontece através do terminal. O usuário escolhe opções em um **menu interativo**, que permite executar diferentes ações dentro do jogo.

O projeto foi implementado em uma classe principal chamada `TreinandoPOOAula1`, que concentra a lógica do sistema. Dentro dessa classe estão os **arrays que armazenam os jogadores**, as variáveis que controlam o estado do jogo e os métodos responsáveis por executar cada funcionalidade.

Para armazenar os jogadores, o sistema utiliza **arrays de tamanho fixo**. Um array guarda os nomes dos jogadores (`nomePlayer`) e outro guarda os níveis de poder (`nivelPower`). Cada posição do array representa um jogador, então o índice funciona como ligação entre os dois dados. Por exemplo, se o nome de um jogador estiver na posição 2 do array, o nível de poder dele também estará na posição 2 do array de poder.

Além dos jogadores vivos, o sistema também mantém registros de **jogadores mortos** e **jogadores que conseguiram escapar do jogo**. Para isso existem arrays específicos para armazenar esses nomes. Também são usadas variáveis de controle como `totPlayerV`, `totPlayerM` e `totPlayerE`, que indicam quantos jogadores existem em cada situação. Isso ajuda o sistema a saber quantos elementos realmente estão sendo utilizados dentro de cada array.

A execução do programa começa no método `main`, que apresenta o menu principal. O menu funciona dentro de um **loop `do-while`**, que mantém o sistema rodando até o usuário escolher sair do programa. As opções do menu são tratadas com uma estrutura `switch`, que chama o método correspondente a cada funcionalidade escolhida.

Uma das funcionalidades é **adicionar novos jogadores ao jogo**. Nesse processo, o usuário informa o nome do jogador e o sistema gera automaticamente um nível de poder utilizando a classe `Random`. Esse poder é um número entre 1 e 100, o que cria uma variação entre jogadores mais fortes e mais fracos.

Outra funcionalidade importante é o **sistema de combate**. Quando essa opção é escolhida, o sistema seleciona dois jogadores vivos de forma aleatória. Para evitar erros, o código garante que os dois jogadores sorteados não sejam o mesmo. Depois disso, o programa compara os níveis de poder dos dois participantes. O jogador com maior poder vence a luta e o outro é removido da lista de jogadores vivos e registrado na lista de mortos. Caso os dois tenham exatamente o mesmo poder, nenhum deles morre e o combate termina empatado.

Como o projeto utiliza arrays, remover um jogador exige reorganizar as posições do array. Para isso, o código desloca todos os elementos que estão à direita do jogador removido uma posição para a esquerda. Isso mantém o array organizado e evita que fiquem “espaços vazios” no meio da lista de jogadores.

O sistema também possui uma funcionalidade onde um jogador pode **tentar escapar do jogo**. Nesse caso, o usuário informa o nome do jogador que deseja fugir. O sistema procura esse jogador dentro da lista de vivos e remove ele do jogo. Em seguida, um número aleatório decide o resultado da fuga: o jogador pode escapar com vida ou morrer durante a tentativa.

Para facilitar os testes do sistema, também foi criado um método que realiza **inserção automática de personagens**. Esse método adiciona vários personagens já conhecidos com níveis de poder definidos ou gerados aleatoriamente dentro de determinados intervalos. Isso ajuda a testar o sistema sem precisar cadastrar vários jogadores manualmente.

Durante o desenvolvimento do projeto foram aplicadas algumas boas práticas importantes para quem está aprendendo Java. Uma delas foi dividir o código em **métodos específicos para cada tarefa**, como adicionar jogadores, listar jogadores, iniciar combates ou registrar tentativas de fuga. Isso ajuda a deixar o código mais organizado e fácil de entender.

Também foram feitas algumas verificações antes de executar certas ações. Por exemplo, o sistema verifica se existem pelo menos dois jogadores vivos antes de iniciar um combate. Esse tipo de validação evita erros durante a execução do programa.

De forma geral, este projeto foi desenvolvido com o objetivo de **praticar lógica de programação e estrutura básica da linguagem Java**, utilizando conceitos como arrays, entrada de dados, geração de números aleatórios, estruturas de repetição e organização de código em métodos.

Como melhoria futura, o sistema poderia evoluir para uma estrutura mais orientada a objetos, criando uma classe `Player` para representar cada jogador e utilizando estruturas como `ArrayList` para facilitar o gerenciamento das listas de jogadores.

Mesmo sendo um projeto simples, ele ajuda a consolidar os primeiros conceitos necessários para evoluir em Java e desenvolver aplicações mais complexas no futuro.
