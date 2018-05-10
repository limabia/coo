/*

  Execute este programa variando de 1 a 4 o parâmetro fornecido
  pela linha de comando e verifique como se dá o fluxo de execução
  em cada um dos casos. Observe, em particular, que o bloco finally
  sempre é executado, independente do que acontece durante a execução
  do programa.

*/

public class TesteFinally {

	public static void main(String [] args){
	
		System.out.println("Inicio.");

		int teste = Integer.parseInt(args[0]);

		try{

			System.out.println("Abertura do bloco try.");

			if(teste == 1) {

				// Este trecho de código não 
				// lança nenhuma exceção.

				int a = 10 + 20;
			}

			if(teste == 2){

				// Este trecho de código lança uma
				// ArithmeticException que é capturada
				// em um bloco catch. 

				int b = 10 / 0;
			}

			if(teste == 3){

				// Este trecho de código lança uma
				// ArrayIndexOutOfBoundsException que 
				// é capturada em um bloco catch. 
	
				int [] v = new int[10];
				v[10] = 1234;
			}

			if(teste == 4){
			
				// Este trecho de código lança uma
				// NullPointerException que não é 
				// capturada em nenhum bloco catch.

				Object o = null;
				o.toString();
			}

			System.out.println("Fechamento do bloco try.");
		}
		catch(ArithmeticException e){

			System.out.println("Arithmetic exception.");
		}
		catch(ArrayIndexOutOfBoundsException e){

			System.out.println("Array index out of bounds exception.");
		}
		finally{

			System.out.println("Finally.");
		}

		System.out.println("Fim!");
	}
}
