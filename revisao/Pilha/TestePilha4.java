import java.util.Scanner;

class Pilha {

	private int topo;
	private int  [] a;

	public Pilha(int max){

		topo = 0;
		a = new int[max];
	}

	public void push(int valor){

		if(topo < a.length){

			a[topo] = valor;
			topo++;
		}
		else {
			System.out.println("Pilha cheia!");
			System.exit(1);
		}
	}

	public int pop(){

		int r = 0;

		if(!vazia()){

			r = a[topo - 1];
			topo--;
		}
		else {
			System.out.println("Pilha vazia!");
			System.exit(1);
		}

		return r;
	}

	public boolean vazia(){

		return (topo == 0);
	}
}

public class TestePilha4 {

	public static void main(String [] args){

		int valor;
		Pilha pilha = new Pilha(100);
		Scanner scanner = new Scanner(System.in);

		while( (valor = scanner.nextInt()) != 0 ){

			pilha.push(valor);
		}

		System.out.print("elementos lidos em ordem reversa:");

		while(!pilha.vazia()){

			System.out.print(" " + pilha.pop());
		}
	
		System.out.println();
	}
}

