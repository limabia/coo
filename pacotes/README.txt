Neste arquivo zip encontram-se 2 exemplos, em diretórios distintos:

* diretório "sem_pacote":

  Exemplo simples de um programa java (classe Teste) que usa duas outras classes (A e B),
  sem haver qualquer tipo de organização das classes em pacotes. Neste caso, todas as
  classes pertencem ao que é denominado o pacote "default".

* diretório "com_pacote":

  Evolução do exemplo anterior, com organização de classes em pacotes. Há 3 pacotes:
  "projeto", "projeto.moduloA" e "projeto.moduloB". Lembre-se que deve existir uma correspondência
  entre a estrutura de diretórios em disco (onde estão os arquivos fonte) e os nomes dos pacotes.

  Foi adicionada também, a cada um dos pacotes "projeto.moduloA" e "projeto.moduloB", uma classe X,
  criando uma situação em que há ambiguidade no momento da compilação (afinal, a classe X a ser
  instanciada pela classe Teste deve ser de qual pacote?) considerando as declarações de import da 
  classe Teste do jeito que estão. Exercício: quais as formas de resolver esse problema de ambiguidade?

  Outra questão relevante em comparação ao primeiro exemplo (sem estrutura de pacotes) refere-se
  à visibilidade do atributo "valor" das classes A, B. No exemplo anterior, o atributo "valor" em 
  A e B possuem o modificador de acesso default, e portanto pode acessado diretamente por qualquer
  classe pertencente ao mesmo pacote (que é o caso da classe Teste).

  No exemplo atual, com a organização das classes em pacotes, as classes A, B e Teste passam a
  pertencer a pacotes distintos. Assim, Teste não consegue mais acessar diretamente o atributo
  "valor" em A e B. A solução adotada (e que é a mais correta do ponto de vista de modelagem OO) 
  é oferecer o acesso ao atributo "valor" através de um getter (apenas para leitura, portanto).

  Dentro do diretório "com_pacote", existe o diretório "diretorio_de_trabalho", que é a raiz
  do nosso projeto. Toda a estrutura de diretórios referente aos pacotes está definida a partir
  desta raiz. Para compilar o exemplo, entre em "diretorio_de_trabalho" e em seguida:

	javac projeto/moduloA/*.java (compilará as classes do pacote projeto.moduloA)
        javac projeto/moduloB/*.java (compilará as classes do pacote projeto.moduloB)
 	javac projeto/Teste.java     (compilará a classe Teste do pacote projeto)

  Note que a compilação de Teste.java irá falhar se a ambiguidade da classe X não tiver sido
  solucionada previamente. Uma vez que esta questão esteja resolvida e o código compilado, o
  programa pode ser executado da seguinte forma (a partir do diretório de trabalho):

	java projeto.Teste (note que o nome do pacote passa a integrar o nome completo da classe)
        
  Observação final: sabemos que deve haver uma correspondência entre a estrutura de pacotes a estrutura
  de diretórios em disco onde localizam-se os arquivos fontes do nosso projeto. Vale lembrar, contudo, que 
  a estrutura de diretórios em disco não precisa estar, necessariamente, restrita a um único local. A
  estrutura de diretórios que define a estrutura dos pacotes pode, portanto, estar estar replicada fisicamente
  em diferentes locais (isto é, podem existir diversas "raizes" de projeto, espalhadas pelo sistema de arquivos). 


