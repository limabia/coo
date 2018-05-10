/*

  Implementação de uma pilha de inteiros. Este código 
  é o mesmo disponibilizado na revisão de POO.

  A maior limitação desta versão é que esta implementação
  de pilha só é capaz de armazenar elementos do tipo inteiro.
  
  Dessa forma, seria necessário criar uma implementação
  específica para cada tipo de elemento que gostaríamos
  de armazenar em uma pilha.

  Observe, contudo, que o funcionamento da pilha como
  estrutura de dados independe do tipo de elemento sendo
  armazenado na mesma. O papel da pilha, como estrutura
  de dados, é manter uma coleção de elementos especificando
  regras bem definidas para a inserção e remoção dos mesmos
  desta coleção, e os tipos dos elementos não interferem
  neste funcionamento.

  Seria interessante ter uma única implementação, capaz
  de lidar com elementos de qualquer tipo, não é mesmo? E isso
  é possível como pode ser visto em TestePilhaObject.java.

*/

class Pilha {

	private int [] dados;
	private int topo;

	public Pilha(int max){

		dados = new int[max];
		topo = 0;
	}

	public void push(int valor){

		if(topo < dados.length) {

			dados[topo] = valor;
			topo++;
		}
		else{ 
			throw new IllegalStateException("Pilha Cheia");
		}
	}

	public int pop(){

		if(topo > 0){

			topo--;
			return dados[topo];
		}

		throw new IllegalStateException("Pilha Vazia");
	}

	public String toString(){

		String s = "Pilha:";

		for(int i = 0; i < topo; i++){

			s += (" " + dados[i]);
		}

		return s;
	}	
}

public class TestePilha {

	public static void main(String [] args){

		if(args.length != 3){

			System.out.println("Uso: java " + TestePilha.class.getName() + " <capacidade pilha> <# adicoes> <# remocoes>");
			System.exit(1);
		}

		int capacidade = Integer.parseInt(args[0]);
		int num_adicoes = Integer.parseInt(args[1]);
		int num_remocoes = Integer.parseInt(args[2]);

		// Instanciando objeto da classe Pilha
		Pilha p = new Pilha(capacidade);
	
		// adicionando elementos da pilha, através do método push
		for(int i = 0; i < num_adicoes; i++){
	
			p.push(i);
		}

		// imprimindo do conteúdo da pilha
		System.out.println(p);

		// removendo elementos da pilha
		for(int i = 0; i < num_remocoes; i++){

			int x = p.pop();
			System.out.println("Elemento removido: " + x); 
		}

		// imprimindo do conteúdo da pilha
		System.out.println(p);	
	}
}
