public class PrintArrayGenerico {

	public static <T> void printArray(T [] array){

		System.out.println("Print array - versao generica");

		for(T i : array) {

			System.out.println(i);
		}
	}

	public static <T> T elementoDoMeio(T [] array){

		return array[array.length / 2];
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
		System.out.println("------------------------------------");

		int i = elementoDoMeio(intArray);
		System.out.println("Elemento do meio: " + i);

		double d = elementoDoMeio(doubleArray);
		System.out.println("Elemento do meio: " + d);

		char c = elementoDoMeio(charArray);
		System.out.println("Elemento do meio: " + c);

	}
}
