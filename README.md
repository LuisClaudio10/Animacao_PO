# Animação de Métodos de Ordenação

## Descrição

Este projeto tem como objetivo a criação de uma animação interativa dos métodos de ordenação **Counting Sort** e **Radix Sort** utilizando a biblioteca **JavaFX**. A animação é uma ferramenta visual para entender melhor o funcionamento desses algoritmos, mostrando o processo de ordenação de uma forma intuitiva e didática.

O projeto foi desenvolvido por **Luis Claudio** e **Luis Otavio**, onde cada um implementou uma animação para um dos métodos de ordenação: 

- **Luis Claudio**: Implementou a animação do **Counting Sort**.
- **Luis Otavio**: Implementou a animação do **Radix Sort**.

A animação simula a movimentação dos elementos na tela enquanto o algoritmo de ordenação está sendo executado. Além disso, exibe informações como as variáveis de índice, setas indicando o processo e utiliza cores para representar diferentes estágios da execução do algoritmo.

## Funcionalidades

- **Geração aleatória dos valores a serem ordenados**: Os valores são gerados aleatoriamente para garantir que a animação mostre o comportamento do algoritmo em diferentes cenários.
- **Objetos com valores sendo movidos na tela**: Cada valor gerado é representado por um objeto na tela que se move conforme o algoritmo de ordenação é executado.
- **Exibição do código-fonte**: Durante a execução do algoritmo, o código-fonte do método de ordenação é exibido, destacando cada linha de execução.
- **Exibição de variáveis de índices**: As variáveis de índice usadas pelo algoritmo são mostradas na tela, permitindo que o usuário veja como os elementos estão sendo comparados e movimentados.
- **Efeitos visuais**: Setas e cores são usadas para representar as comparações e movimentações, facilitando a visualização do algoritmo.

## Algoritmos Implementados

- **Counting Sort**: O algoritmo de ordenação Counting Sort é utilizado para ordenar os valores gerados de acordo com suas frequências.
- **Radix Sort**: O algoritmo Radix Sort é utilizado para ordenar os valores baseando-se em seus dígitos, realizando múltiplas passagens pelos elementos.

## Tecnologias Utilizadas

- **JavaFX**: Para criar a interface gráfica e a animação dos métodos de ordenação.
- **Java**: Para a implementação dos algoritmos e da lógica de animação.

## Como Executar

1. Clone este repositório.

2. Compile e execute o código Java:

```bash
javac Principal.java
java Principal
