//
// Neste terceio exemplo são corrigidos os problemas da versão
// anterior. Os atributos apenas podem ser atualizados através
// de métodos, havendo maior controle sobre o estado interno
// dos objetos. Sempre que uma das componentes de um vetor for
// atualizada, seu modulo será automaticamente recalculado e
// sempre estará consistente.
//
// Observe, contudo, que para criar uma classe bem encapsulada é preciso
// de análise para decidir quais serão as vias pelas quais o cliente
// da classe poderá modifcar um objeto (ou seja, qual deverá ser a interface
// de métodos exposta pela classe), e o que exatamente poderá ser modificado.
// Não podemos, portanto, adotar um comportamento quase automatizado de 
// proteger todos os atributos (declarando-os como privado) e declarar
// setters e getters para todos eles sem critério. Por exemplo, se declararmos 
// o método setModulo(...), ainda será possível que instâncias de Vetor2D 
// fiquem inconsistentes.
// 

class Vetor2D {

	// atributos privados
	private double x, y, modulo;

	// construtor
	Vetor2D(double x, double y){

		setXY(x, y);
	}

	// setter para x
	public void setX(double x){

		setXY(x, this.y);
	}

	// setter para y
	public void setY(double y){

		setXY(this.x, y);
	}
	
	// setter para x e y
	public void setXY(double x, double y){

		this.x = x;
		this.y = y;

		atualizaModulo();
	}

	// metodo privado, pois não há necessidade 
	// de os clientes o usarem diretamente.
	private void atualizaModulo(){

		modulo = Math.sqrt(x * x + y * y);
	}

	// getter para o módulo. Note que não 
	// existe um setter para este atributo.
	public double getModulo(){

		return modulo;
	}

	public String toString(){

		return "(" + x + ", " + y + ")";
	}
}

public class TesteVetor3 {

	public static void main(String [] args){

		Vetor2D a = new Vetor2D(1.0, 1.0);

		System.out.println("modulo do vetor " + a + ": " + a.getModulo());
		
		a.setX(0.0);
		System.out.println("modulo do vetor " + a + ": " + a.getModulo());
		
		a.setY(0.0);
		System.out.println("modulo do vetor " + a + ": " + a.getModulo());
        }
}
