// Exemplo simples de herança

class Base {

	protected int a;
	protected int b;

	public Base(){

		a = 100;
		b = 1000;
	}

	public int getA(){

		return a;
	}

	public int getB(){

		return b;
	}
}

class Derivada extends Base {

	public Derivada(){

		a = 200;
	}

	public int getB(){

		return -b;
	}
}

public class TesteHeranca {

	public static void main(String [] args){

		// Qual será o resultado devolvido pelos métodos getA()
		// e getB() em cada uma das situações abaixo? O que 
		// define quais serão os valores devolvidos, o tipo da
		// variável ou o tipo concreto do objeto instanciado?

		Base x = new Base();
		System.out.println(x.getA() + " " + x.getB());

		Derivada y = new Derivada();
		System.out.println(y.getA() + " " + y.getB());

		Base z = new Derivada();
		System.out.println(z.getA() + " " + z.getB());
	}
}
