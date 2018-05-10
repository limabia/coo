import java.util.*;

/*

  Versão que emprega o mecanismo para tratamento de exceções
  disponível pela plataforma Java. Neste exemplo aproveitamos
  uma classe de exceção já disponível na API do Java, a 
  classe Exception.

  Observe como o código referete à logica principal do programa
  agora está separado da lógica para tratamento de erro.

*/

public class TesteMedia3 {

	private static Scanner scanner = new Scanner(System.in);

	public static double leDouble() throws Exception{

		double x = scanner.nextDouble();

		if( x < 0.0 || x > 10.0 ) throw new Exception("nota fora do intervalo.");

		return x;
	}

        public static void main(String [] args){

		try{

		        double a = leDouble();
		        double b = leDouble();
		        double c = leDouble();
			double media = (a + b + c) / 3.0;
		        
			System.out.println("Media = " + media);
		}
		catch(Exception e){

			e.printStackTrace(); // útil para depurar causas da exceções...
		}

		System.out.println("Fim!");
        }
}

