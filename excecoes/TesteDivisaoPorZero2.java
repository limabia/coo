import java.util.*;

/*

  Neste novo exemplo, é tratado o caso do denominador igual a zero,
  mas sem aproveitar o mecanismo de tratamento de exceções disponível
  no Java.

  Observe que não há como informar a quem chama o metodo div() que
  a divisão não pode ser efetuada sem que o tipo de retorno do método
  seja alterado (nenhum valor específico de retorno pode ser utilizado
  para sinalização do erro, pois qualquer valor inteiro é um resultado
  válido da operação de divisão). Resta apenas imprimir uma mensagem de 
  erro e interromper a execução do programa.

*/

public class TesteDivisaoPorZero2 {

	public static int div(int a, int b){

		if(b != 0){

			int c = a / b;
			return c;
		}
		else {
			System.out.println("Denominador igual a zero!");
			System.exit(1);

			// este return está aqui apenas para que o código 
			// compile, mas ele nunca chegará a ser executado.
			return 0; 
		}
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
