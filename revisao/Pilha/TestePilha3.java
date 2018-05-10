import java.util.Scanner;

class Pilha {

	public int topo;
	public int  [] a;
}

public class TestePilha3 {

	public static Pilha criaPilha(int max){

		Pilha p = new Pilha();
		p.topo = 0;
		p.a = new int[max];

		return p;
	}

	public static void push(Pilha p, int valor){

		if(p.topo < p.a.length){

			p.a[p.topo] = valor;
			p.topo++;
		}
		else {
			System.out.println("Pilha cheia!");
			System.exit(1);
		}
	}

	public static int pop(Pilha p){

		int r = 0;

		if(!vazia(p)){

			r = p.a[p.topo - 1];
			p.topo--;
		}
		else {
			System.out.println("Pilha vazia!");
			System.exit(1);
		}

		return r;
	}

	public static boolean vazia(Pilha p){

		return (p.topo == 0);
	}

	public static void main(String [] args){

		int valor;
		Pilha pilha = criaPilha(100);
		Scanner scanner = new Scanner(System.in);

		while( (valor = scanner.nextInt()) != 0 ){

			push(pilha, valor);
		}

		System.out.print("elementos lidos em ordem reversa:");

		while(!vazia(pilha)){

			System.out.print(" " + pop(pilha));
		}
	
		System.out.println();
	}
}

