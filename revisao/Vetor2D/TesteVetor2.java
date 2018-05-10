//
// Este segundo exemplo relacionado ilustra os problemas que podem  
// surgir se mantido um encapsulamento ruim para a classe Vetor2D. 
//
// Considere a seguinte modificação na classe Vetor2D: a fim de evitar o 
// cálculo do modulo *sempre* que o método modulo() é chamado, é acrescentado
// um atributo "modulo" que é calculado *apenas* quando há modificação nos 
// atributos x e/ou y (realizada através dos métodos setX, setY ou setXY).
// [OBS: este tipo de estratégia, de se calcular algo apenas quando realmente
// necessário, é especialmente útil quando o cálculo é pesado e demanda
// bastante recurso computacional, o que não é bem o caso do exemplo pois
// o cálculo do modulo é relativament simples]
//
// Esta nova versão possui dois problemas sérios:
//
// 1) Apesar dos setters para atribuir valores aos atributos x e y,
//    estes ainda encontram-se desprotegidos, podendo ser modificados
//    pelos clientes da classe Vetor2D. Assim, na situação em que um cliente
//    modifica diretamente um dos atributos, o atributo "modulo" não tem
//    seu valor recalculado, podendo levar instâncias da classe Vetor2D
//    a ficarem inconsistentes.
//
//  2) O próprio atributo "modulo" também não está devidamente protegido,
//     podendo ser alterado diretamente por um cliente das classe Vetor2D,
//     novamente levando a situações de comprometimento do estado interno
//     das instâncias.
//
//  Outro problema, embora menos grave, é que o método atualizaModulo está
//  declarado como público, permitindo que seja chamado por clientes em situações
//  em que não há necessidade. Embora não cause prejuízo maior (comprometimento
//  do estado interno, ou mal funcionamento), não cabe ao cliente decidir
//  quando este método deve ser chamado, mas sim à própria classe Vetor2D.
// 

class Vetor2D {

	double x, y, modulo;

	Vetor2D(double x, double y){

		setXY(x, y);
	}

	public void setX(double x){

		setXY(x, this.y);
	}

	public void setY(double y){

		setXY(this.x, y);
	}
	
	public void setXY(double x, double y){

		this.x = x;
		this.y = y;

		atualizaModulo();
	}

	public void atualizaModulo(){

		modulo = Math.sqrt(x * x + y * y);
	}

	public double getModulo(){

		return modulo;
	}

	public String toString(){

		return "(" + x + ", " + y + ")";
	}
}

public class TesteVetor2 {

	public static void main(String [] args){

		Vetor2D a = new Vetor2D(1.0, 1.0);

		System.out.println("modulo do vetor " + a + ": " + a.getModulo());
		
		a.x = 0.0;
		System.out.println("modulo do vetor " + a + ": " + a.getModulo());
		
		a.y = 0.0;
		System.out.println("modulo do vetor " + a + ": " + a.getModulo());
		
		a.modulo = 100;
		System.out.println("modulo do vetor " + a + ": " + a.getModulo());
        }
}
