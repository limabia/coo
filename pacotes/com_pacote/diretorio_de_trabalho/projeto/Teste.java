package projeto;

// Este código não compilará com as declarações de import abaixo...
// O que precisa ser modificado para que a compilação seja possível?

import projeto.moduloA.*;
import projeto.moduloB.*;

public class Teste {

	public static void main(String [] args){

		A a = new A();
		B b = new B();
		X x = new X(); // o objeto a ser instanciado será de qual pacote?

		System.out.println("a.valor = " + a.getValor());
		System.out.println("b.valor = " + b.getValor());
		System.out.println("x.valor = " + x.getValor());
	}
}
