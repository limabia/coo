import java.util.*;

/*

  Neste exemplo, não é feito qualquer tipo de tratamento de erro,
  embora dois problemas possam acontecer durante a execução do 
  programa: quando o valor de b for igual a zero, e quando o usuário
  digitar um valor não inteiro como entrada para a ou b.

*/

public class TesteDivisaoPorZero1 {

	public static int div(int a, int b){

		int c = a / b;

		return c;
	}

	public static void main(String [] args){

		int a, b, c;
		Scanner scanner = new Scanner(System.in);

		System.out.print("a: ");
		a = scanner.nextInt();

		System.out.print("b: ");		
		b = scanner.nextInt();
		
		c = div(a, b);
		System.out.println("Resultado: " + a + " / " + b + " = " + c);
		System.out.println("Fim do programa.");
	}
}
