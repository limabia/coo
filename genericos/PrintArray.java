public class PrintArray {

	public static void printArray(Integer [] array){

		System.out.println("Print array - versao Integer");

		for(Integer i : array) {

			System.out.println(i);
		}
	}

	public static void printArray(Double [] array){

		System.out.println("Print array - versao Double");

		for(Double i : array) {

			System.out.println(i);
		}
	}

	
	// Experimente comentar a versão abaixo do método printArray
 	// e verifique o que muda na execução do programa.

	public static void printArray(Character [] array){

		System.out.println("Print array - versao Character");

		for(Character i : array) {

			System.out.println(i);
		}
	}

	public static void printArray(Object [] array){

		System.out.println("Print array - versao Object");

		for(Object i : array) {

			System.out.println(i);
		}
	}

	public static void main(String [] args){

		Integer [] intArray = { 1, 2, 3, 4, 5 };
		Double [] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Character [] charArray = { 'H', 'E', 'L', 'L', 'O' };

		printArray(intArray);
		System.out.println("------------------------------------");
		printArray(doubleArray);
		System.out.println("------------------------------------");
		printArray(charArray);

	}
}
