/*

  Uma forma de criar uma pilha capaz de armazenar
  qualquer tipo de elemento, é implementar uma pilha de
  Objects. Como todos os objetos em Java herdam, direta
  ou indiretamente, de Object, então uma pilha capaz de
  armazenar Objects pode guardar qualquer tipo de elemento.

  A exceção fica para os tipos primitivos (byte, char, int, 
  long, float, double), que não são objetos, mas podem ser
  substituidos pelos tipos empacotadores (Byte, Character,
  Integer, Long, Float, Double).

  Embora funcione, tal implementação traz alguns inconvenientes:

  - Ao remover elementos da pilha é necessário realizar conversões de tipo (cast).
 
  - Mesmo que nossa intenção seja usar a pilha para armazenar apenas elementos do 
    tipo X, inserções de elementos de outros tipos (Y, Z, W, etc...) serão bem 
    sucedidas, afinal também são subclasses de Object, levando ao próxmo 
    inconveniente...

  - Se existirem elementos na pilha de tipos diferente do tipo esperado, 
    podem ocorrer erros de conversão quando tais elemento forem removidos, 
    resultando no lançamento de ClassCastExceptions. A presença de elementos
    na pilha de tipo diferente do esperado provavelmente indica erros de 
    programação, contudo tais erros só serão detectados quando o programa estiver
    em execução.

  Uma forma de contornar tais inconvenientes é criar uma "casca" por cima
  de PilhaObject, como por exemplo a classe PilhaInt. Esta classe possui, 
  internamente, uma instancia de PilhaObject e oferece os mesmos métodos para
  manipulação da pilha. Observe que PilhaInt não implementa, de fato, uma pilha.
  Ela apenas repassa as chamadas de metodos feitas a ela para a instancia interna
  de PilhaObject. Além disso, os metodos push() e pop() de PilhaInt trabalham
  especificamente com o tipo "int", o que garante a verificação de tipo em
  tempo de compilação (não há a possibilidade de adicionar elementos de outros tipos, 
  não são necessárias realizar conversões de tipo nas remoções e também não existe
  o risco de ClassCastExceptions serem lançadas em tempo de execução).

  A desvantagem desta abordagem é que para cada novo tipo de dado que desejamos
  guardar em uma pilha devemos implementar uma "casca" correspondente (mas pelo 
  menos a lógica de funcionamento da pilha é implementada uma única vez em 
  PilhaObject). Além disso, não existe uma relação de tipo e subtipo entre PilhaObject 
  e as cascas implementadas.

  Como poderá ser observado no próximo exemplo, o uso dos tipos genéricos não
  só soluciona os inconvientes listados acima, como também é uma alternativa
  mais interessante do que a criação das "cascas".

*/

class PilhaObject {

	private Object [] dados;
	private int topo;

	public PilhaObject(int max){

		dados = new Object[max];
		topo = 0;
	}

	public void push(Object obj){

		if(topo < dados.length) {

			dados[topo] = obj;
			topo++;
		}
		else{ 
			throw new IllegalStateException("Pilha Cheia");
		}
	}

	public Object pop(){

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

class Elemento {

	private String descricao;
	private int valor;

	public Elemento(String descricao, int valor){

		this.descricao = descricao;
		this.valor = valor;
	}

	public String toString(){

		return "['" + descricao + "', " + valor + "]";
	}
}

class PilhaInt {

	private PilhaObject pilha;

	public PilhaInt(int max){

		pilha = new PilhaObject(max);
	}

	public void push(int valor){

		pilha.push(valor);
	}

	public int pop(){

		int x = (int) pilha.pop();
		return x;
	}

	public String toString(){

		return pilha.toString();
	}
}

public class TestePilhaObject {

	public static void testeInt(){

		PilhaObject p = new PilhaObject(10);

		p.push(10);
		p.push(20);
		p.push(30);
		p.push(40);
		p.push(50);

		System.out.println(p);	

		for(int i = 0; i < 3; i++) {

			// Experimente remover o a conversão de tipo
			// na linha abaixo e veja se o código compila.
			int x = (int) p.pop();
			System.out.println("Elemento removido: " + x); 
		}
		
		System.out.println(p);	
	}

	public static void testeElemento(){

		PilhaObject p = new PilhaObject(10);

		p.push(new Elemento("aaa", 100));
		p.push(new Elemento("bbb", 200));
		p.push(new Elemento("ccc", 300));
		p.push(new Elemento("ddd", 400));
		p.push(new Elemento("eee", 500));

		// Experimente adicionar um elemento do tipo inteiro
		// na pilha, e veja o que acontece durante a execução 
		// do programa.

		System.out.println(p);	

		for(int i = 0; i < 3; i++) {

			Elemento x = (Elemento) p.pop();
			System.out.println("Elemento removido: " + x); 
		}
		
		System.out.println(p);	
	}

	public static void testePilhaInt(){

		PilhaInt p = new PilhaInt(10);

		p.push(1);
		p.push(2);
		p.push(4);
		p.push(8);
		p.push(16);

		// Experimente adicionar um elemento do tipo Elemento
		// na pilha, e veja que o compilador impede tal tentativa
		// de adição.
	
		System.out.println(p);	

		for(int i = 0; i < 3; i++) {

			// Note que a conversão de tipo não
			// é necessária na linha abaixo.
			int x = p.pop();
			System.out.println("Elemento removido: " + x); 
		}
		
		System.out.println(p);	
	}

	public static void main(String [] args){

		testeInt();
		
		System.out.println("-------------------------------------------------------------------------");

		testeElemento();

		System.out.println("-------------------------------------------------------------------------");

		testePilhaInt();
	}
}

