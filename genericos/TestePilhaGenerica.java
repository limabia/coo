/*

  Versão genérica da pilha.

*/

class PilhaGenerica <T> {

	private T [] dados;
	private int topo;

	@SuppressWarnings("unchecked")
	public PilhaGenerica(int max){

		dados = (T []) new Object[max];
		topo = 0;
	}

	public void push(T obj){

		if(topo < dados.length) {

			dados[topo] = obj;
			topo++;
		}
		else{ 
			throw new IllegalStateException("Pilha Cheia");
		}
	}

	public T pop(){

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

	public Elemento(String s, int i){

		descricao = s;
		valor = i;
	}

	public String toString(){

		return "['" + descricao + "', " + valor + "]";
	}
}

public class TestePilhaGenerica {

	public static void testeInt(){

		PilhaGenerica<Integer> p = new PilhaGenerica<Integer>(10);

		p.push(10);
		p.push(20);
		p.push(30);
		p.push(40);
		p.push(50);
	
		/* Descomente a linha abaixo e tente compilar */
		/* o código para verificar o que acontece.    */
		//p.push(new Elemento("xyz", 100));

		System.out.println(p);	

		for(int i = 0; i < 3; i++) {

			// Note que a conversão de tipo não
			// é necessária na linha abaixo.
			int x = p.pop();
			System.out.println("Elemento removido: " + x); 
		}
		
		System.out.println(p);	
	}

	public static void testeElemento(){

		PilhaGenerica<Elemento> p = new PilhaGenerica<Elemento>(10);

		p.push(new Elemento("aaa", 100));
		p.push(new Elemento("bbb", 200));
		p.push(new Elemento("ccc", 300));
		p.push(new Elemento("ddd", 400));
		p.push(new Elemento("eee", 500));

		/* Descomente a linha abaixo e tente compilar */
		/* o código para verificar o que acontece.    */
		//p.push(256);

		System.out.println(p);	

		for(int i = 0; i < 3; i++) {

			// Note que a conversão de tipo não
			// é necessária na linha abaixo.
			Elemento x = p.pop();
			System.out.println("Elemento removido: " + x); 
		}
		
		System.out.println(p);	
	}

	public static void main(String [] args){

		testeInt();

		System.out.println("-------------------------------------------------------------------------");
	
		testeElemento();
	}
}
