//
// Classe Vetor2D usado como exemplo durante a revisão de conceitos de POO.
// Apesar do encapsulamento pobre (os atributos x e y são visíveis para outras
// classe do mesmo pacote, incluindo a classe de teste que é uma classe
// cliente/usuária da classe Vetor2D), à primeira vista não há maiores prejuízos se
// assumirmos que é esperado que um cliente da classe Vetor2D seja capaz de
// atualizar os valores dos atributos x e y. Note que a possibilidade de o cliente
// modificar diretamente os valores destes atributos não traz o risco de comprometer o
// estado interno de instâncias de Vetor2D ou de mal funcionamento ao programa de teste.
//
// Esta aparente falta de prejuízo, contudo, não deve ser usada como justificativa
// para manter-se um encapsulamento ruim pois, em atualizações futuras da classe
// Vetor2D, problemas podem aperecer. Assim, é importante que se busque sempre
// definir classes bem encapsuladas, mesmo que em um primeiro instante não pareça
// algo necessário. O bom encapsulamento pode ser conseguido restringindo a visibilidade
// dos atributos da classe e permitindo que clientes modifiquem o estado de um objeto
// apenas através e métodos. Desta forma, tem-se maior controle sobre as modificações.
//

class Vetor2D {

	double x, y;

	Vetor2D(double x, double y){

		this.x = x;
		this.y = y;
	}

	public double getModulo(){

		return Math.sqrt(x * x + y * y);
	}

	public String toString(){

		return "(" + x + ", " + y + ")";
	}
}

public class TesteVetor1 {

	public static void main(String [] args){

		Vetor2D a = new Vetor2D(1.0, 1.0);

		System.out.println("modulo do vetor " + a + ": " + a.getModulo());
		
		a.x = 0.0;
		System.out.println("modulo do vetor " + a + ": " + a.getModulo());

		a.y = 0.0;
		System.out.println("modulo do vetor " + a + ": " + a.getModulo());
        }
}
