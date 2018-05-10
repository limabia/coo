import java.util.Scanner;

public class TestePilha2 {

	public static int push(int [] a, int topo, int valor){

		a[topo] = valor;
		return topo + 1;
	}

	public static int[] pop(int [] a, int topo){

		return new int [] { topo - 1, a[topo - 1] };
	}

	public static void main(String [] args){

		int valor;
		int topo;
		int [] a = new int[100]; 

		Scanner scanner = new Scanner(System.in);

		topo = 0;
		while( (valor = scanner.nextInt()) != 0 ){

			topo = push(a, topo, valor);
		}

		System.out.print("elementos lidos em ordem reversa:");

		while(topo > 0){

			int [] r = pop(a, topo);
			topo = r[0];
			valor = r[1]; 

			System.out.print(" " + valor);
		}
	
		System.out.println();
	}
}

