import java.util.*;

/*

  Note que o código de validação da nota se repete diversas vezes dentro
  do programa, assim uma melhoria seria mover esse código para um método.

  Uma ideia é implementar a validação dentro do próprio leDouble(), mas como
  não queremos que a responsabilidade de encerrar o programa seja deste método,
  mas sim do programa principal, leDouble() deve ser capaz de informar a quem o
  chamou se o valor lido está dentro ou não do intervalo esperado. Para nossa 
  sorte, como valores válidos de notas encontram-se entre o intervalo 0.0 e 10.0,
  é possível especificar um valor especial de retorno para o método leDouble()
  para indicar que uma nota lida é invalida. Assim a validação da nota poderia
  ser feita dentro do método leDouble().

  Apesar da melhoria, ainda há a mistura a lógica principal com o tratamento de erro.

*/

public class TesteMedia2 {

	private static Scanner scanner = new Scanner(System.in);

	public static double leDouble(){

		double x = scanner.nextDouble();

		if( x < 0.0 || x > 10.0 ) return -1;

		return x;
	}

	public static void erro(){

        	System.out.println("Nota fora do intervalo.");
       		System.exit(1);
	}

        public static void main(String [] args){

                double a = leDouble();
        	if(a < 0) erro();

                double b = leDouble();
		if(b < 0) erro();

                double c = leDouble();
		if(c < 0) erro();

		double media = (a + b + c) / 3.0;
                System.out.println("Media = " + media);
        }
}

