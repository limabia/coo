import java.util.Scanner;

public class TestePilha1 {

	public static void main(String [] args){

		int valor;
		int topo;
		int [] a = new int[100]; 

		Scanner scanner = new Scanner(System.in);

		topo = 0;
		while( (valor = scanner.nextInt()) != 0 ){

			a[topo] = valor;
			topo++;
		}

		System.out.print("elementos lidos em ordem reversa:");

		while(topo > 0){

			System.out.print(" " + a[topo - 1]);
			topo--;
		}
	
		System.out.println();
	}
}

