import java.util.*;

/*
 * Esta classe contem alguns exemplos que ilustram o uso e funcionamento das principais interfaces e classes 
 * disponibilizadas no "Collections Framework" do Java.
 *
 * Esta classe possui tres metodos de teste principais:
 *
 *  - testeColecaoString: uso de classes que implementam a interface Collection para armazenar objetos do tipo String.
 *  - testeColecaoPessoa: uso de classes que implementam a interface Collection para armazenar objetos do tipo Pessoa.
 *  - testeMapa: uso de classes que implementam a interface Map para associar chaves inteiras a objetos do tipo Pessoa.
 *
 * Ao executar esta classe, deve-se especificar qual dos tres testes serah executado, assim como qual implementacao
 * de Collection ou Map deve ser utilizada. Veja os comentarios de cada metodo para maiores detalhes. Como as colecoes
 * Java sao classes genericas, alem dos exemplos relativos as colecoes Java em si, esta classe de teste tambem conta
 * com diversos metodos genericos auxiliares.
 * 
 */

public class TesteColecoes{

    public static void separador(){

	System.out.println("--------------------------------------------------------------------------------------");    
    }

    /* 
     * Metodo generico que recebe uma Collection (de objetos de qualquer tipo) 
     * e imprime seus elementos atraves de um Iterator.
     */
    public static <T> void imprimeColecao(Collection<T> colecao){
	
	System.out.println("A colecao do tipo " + colecao.getClass() + " contem " + colecao.size() + " elementos:");
	
	Iterator<T> it = colecao.iterator();
	
	while(it.hasNext()){
	    
	    T elemento = it.next();
	    System.out.println(elemento);		
	}
	
	separador();
    }

    /*
     * Metodo generico que recebe uma List e imprime seus elementos em ordem reversa atraves de um ListIterator. 
     * Observe que o ListIterator soh estah disponivel para objetos que implementam a interface List. Dessa forma, 
     * este metodo nao pode receber uma Collection como eh feito metodo "imprimeColecao". 
     */
    public static <T> void imprimeColecaoR(List<T> lista){
	
	System.out.println("A lista do tipo " + lista.getClass() + " contem " + lista.size() + " elementos. Elementos na ordem reversa:");
	
	ListIterator<T> it = lista.listIterator(lista.size());
	
	while(it.hasPrevious()){
	    
	    T elemento = it.previous();
	    System.out.println(elemento);		
	}
	
	separador();
    }
    
    /*
     * Metodo generico que recebe um Iterator, um inteiro n, e itera pelos n primeiros elementos,
     * devolvendo o n-esimo elemento devolvido pelo Iterator.
     */
    public static <T> T itera(Iterator<T> it, int n){
	
	T elemento = null;

	for(int i = 0; i < n; i++){
	    
	    if(it.hasNext()) elemento = it.next();
	}

	return elemento;
    }

    /* 
     * Metodo generico que recebe uma Collection, um inteiro n, e remove o n-esimo 
     * elemento da colecao, conforme a ordem de iteracao definida pelo Iterator.
     */
    public static <T> void removeIt(Collection<T> colecao, int n){
    
	Iterator<T> it = colecao.iterator();
	T elemento = itera(it, n);
	it.remove();
	
	System.out.println(">>>>> elemento '" + elemento + "' removido da colecao.");
    }

    /*
     * Metodo generico que recebe uma List, um novo elemento e um inteiro n, e adiciona o novo elemento
     * na lista, depois do n-esimo elemento, conforme ordem de iteracao definida pelo Iterator. Observe
     * que o metodo "add" soh eh suportado pela interface ListIterator, e por isso este metodo nao pode
     * ser aplicado a objetos do tipo Collection, apenas objetos do tipo List.
     */
    public static <T> void adicionaIt(List<T> lista, T novoElemento, int n){
    
	ListIterator<T> it = lista.listIterator();
	T elemento = itera(it, n);
	it.add(novoElemento);

	System.out.println(">>>>> elemento '" + novoElemento + "' adicionado na lista depois de '" + elemento + "'.");
    }

    /*
     * Metodo generico que recebe uma List, um novo elemento e um inteiro n, e substitui o n-esimo elemento 
     * da lista (conforme ordem de iteracao definida pelo Iterator) pelo novo elemento. Observe que o metodo 
     * "set" soh eh suportado pela interface ListIterator, e por isso este metodo nao pode ser aplicado a 
     * objetos do tipo Collection, apenas objetos do tipo List.
     */
    public static <T> void modificaIt(List<T> lista, T novoElemento, int n){
    
	ListIterator<T> it = lista.listIterator();
	T elemento = itera(it, n);
	it.set(novoElemento);
	
	System.out.println(">>>>> elemento '" + elemento + "' subsituido por '" + novoElemento + "' na lista.");
    }

    /* 
     * Metodo generico que verifica se "elemento" pertence a "colecao", 
     * atraves do metodo "contains" definido pela interface Collection.
     */
    public static <T> void testaPertinencia(Collection<T> colecao, T elemento){
    
	System.out.println(elemento + " existe na colecao? " + colecao.contains(elemento));
    }

    /*
     * Metodo generico que testa se cada um dos elementos do array "valores" pertence a "colecao".
     */
    public static <T> void testaPertinencia(Collection<T> colecao, T [] valores){

	System.out.println("Testes de pertinencia:");

	for(T candidato : valores){
	    
	    testaPertinencia(colecao, candidato);
	}

	separador();
    }

    /*
     * Metodo que ilustra o uso de diversas classes que implementam a interface Collection para armazenar
     * Strings. Recebe como parametro uma String que define qual implementacao de Collection serah instanciada.
     * Este metodo contem exemplos das seguintes operacoes:
     *
     *  - adicao de elementos atraves do metodo "add".
     *
     *  - iteracao pelos elementos armazenados na colecao (atraves de chamadas ao metodo "imprimeColecao"). 
     *    Observe como a ordem em que os elementos sao iterados muda dependendo da implementacao de Collection
     *    que eh utilizada.
     *
     *  - adicao de elemento repetido (para ilustrar diferenca entre Set e Lists).
     *
     *  - impressao em ordem reversa (apenas para Collections que tambem sao Lists).
     *
     *  - remocao de elemento atraves do iterador (chamada ao metodo "removeIt").
     *
     *  - adicao e modificacao de elemento atraves do ListIterator (chamadas a "adicionaIt" e "modificaIt",
     *    apenas para Collections que tambem sao Lists).
     *
     *  - testes de pertinencia (atraves de chamada ao metodo "testaPertinencia").
     *
     *  - uso dos metodos "firt", "last", "headSet" e "tailSet" (definidos para a interface SortedSet).
     *
     */
    public static void testeColecaoString(String tipoDeColecao){
	
	Collection<String> colecao;
	
	if(tipoDeColecao.equals("array")) colecao = new ArrayList<String>();
	else if(tipoDeColecao.equals("linked")) colecao = new LinkedList<String>();
	else if(tipoDeColecao.equals("hash")) colecao = new HashSet<String>();
	else if(tipoDeColecao.equals("tree")) colecao = new TreeSet<String>();
	else{
	    
	    System.out.println("Tipo de colecao invalido!");
	    return;
	}

	colecao.add("Hugo");
	colecao.add("Gilmar");
	colecao.add("Fabio");
	colecao.add("Eduardo");
	colecao.add("Daniela");
	colecao.add("Carla");
	colecao.add("Bruno");
	colecao.add("Ana");

	imprimeColecao(colecao);

	String eduardo = "Eduardo";
	System.out.println(">>>>> insercao de elemento repetido '" + eduardo + "' foi bem sucedida? " + colecao.add(eduardo));

	imprimeColecao(colecao);
	if(colecao instanceof List) imprimeColecaoR( (List<String>) colecao );
	
	removeIt(colecao, 3);
	imprimeColecao(colecao);

	if(colecao instanceof List){
	    adicionaIt( (List<String>) colecao, "Fernanda", 2 );
	    modificaIt( (List<String>) colecao, "Anderson", 8 );
	}

	imprimeColecao(colecao);
	
	String [] nomes = {"Bruno", "Fabio", "Fernanda", "Gilmar", "Paulo"};
	testaPertinencia(colecao, nomes);

	if(colecao instanceof SortedSet){

	    SortedSet<String> set = (SortedSet<String>) colecao;
	
	    System.out.println("primeiro elemento do conjunto ordenado: " + set.first());
	    System.out.println("ultimo elemento do conjunto ordenado: " + set.last());

	    separador();

	    String s = "Eduardo";
	    System.out.println("Subconjunto dos elementos menores que '" + s + "':"); 
	    imprimeColecao(set.headSet(s));
	    System.out.println("Subconjunto dos elementos maiores ou iguais a '" + s + "':");
	    imprimeColecao(set.tailSet(s));
	}

    }

    /*
     * Metodo que ilustra o uso de diversas classes que implementam a interface Collection para armazenar
     * objetos do tipo Pessoa. Recebe como parametros uma String que define qual a implementacao de Collection
     * a ser instanciada, e um "comparator" que, se for nao nulo, sera utilizado para definir a ordenacao dos 
     * elementos quando a implementacao TreeSet for utilizada. No caso em que "comparator == null", a ordem
     * dos elementos dentro do TreeSet sera definida atraves do metodo "compareTo" da classe Pessoa.
     *
     * Este metodo mostra essencialmente as mesmas operacoes presentes no metodo "testeColecaoString", mas
     * ilustra as implicacoes de se utilizar o framework de colecoes do Java para armazenar classes definidas
     * pelo proprio programador (ao inves de se utilizar classes como String e classes empacotadoras de tipos
     * primitivos - Double, Integer, etc). Essas implicacoes sao:
     *
     *  - necessidade de sobrescrever, na classe Pessoa, o metodo "equals" da superclasse Object 
     *    (importante para que as implementacoes ArrayList, LinkedList e HashSet testadas neste 
     *    metodo funcionem como esperado).
     *
     *  - necessidade de sobrescrever, na classe Pessoa, o metodo "hashCode" da superclasse Object.
     *    (importante para que a implementacao HashSet testada neste metodo funcione como esperado).
     *
     *  - necessidade de a classe Pessoa implementar a interface Comparable<Pessoa>, que define uma ordenacao
     *    natural entre os objetos do tipo Pessoa, OU especificar um Comparator<Pessoa> alternativo ao se 
     *    instanciar uma implementacao do tipo SortedSet (importante para que a implementacao TreeSet testada
     *    neste metodo funcione da forma esperada).
     *
     * Este metodo contem exemplos das seguintes operacoes: adicao de elementos, remocao de elementos (agora
     * atraves do metodo "remove" definido em Collection ao inves de se usar o Iterator), iteracao pelos elementos
     * armazenados na colecao e teste de pertinencia. Ao final ainda fazemos o log (registro) das chamadas a 
     * "equals", "hashCode" e "compareTo" durante um unico teste de pertinencia. Observe como os metodos chamados
     * e a quantidade de vezes que sao chamados variam conforme a implementacao de Collection utilizada.
     *
     */
    public static void testeColecaoPessoa(String tipoDeColecao, Comparator<Pessoa> comparator){
	
	Collection<Pessoa> colecao;
    
	if(tipoDeColecao.equals("array")) colecao = new ArrayList<Pessoa>();
	else if(tipoDeColecao.equals("linked")) colecao = new LinkedList<Pessoa>();
	else if(tipoDeColecao.equals("hash")) colecao = new HashSet<Pessoa>();
	else if(tipoDeColecao.equals("tree")) colecao = (comparator != null ? new TreeSet<Pessoa>(comparator) : new TreeSet<Pessoa>());
	else{
	    
	    System.out.println("Tipo de colecao invalido!");
	    return;
	}

	colecao.add(new Pessoa("Xavier", 30, 1008));
	colecao.add(new Pessoa("Ana", 27, 1007));
	colecao.add(new Pessoa("Joao", 23, 1006));
	colecao.add(new Pessoa("Bianca", 28, 1005));
	colecao.add(new Pessoa("Paulo", 30, 1004));
	colecao.add(new Pessoa("Eduardo", 27, 1003));
	colecao.add(new Pessoa("Pedro", 23, 1002));
	colecao.add(new Pessoa("Maria", 28, 1001));
	
	imprimeColecao(colecao);
	
	Pessoa eduardo = new Pessoa("Eduardo", 27, 1003);
	colecao.remove(eduardo);
	System.out.println(">>>>> elemento " + eduardo + " removido da colecao.");

	imprimeColecao(colecao);
	
	Pessoa [] pessoas = { new Pessoa("Maria", 28, 1001), new Pessoa("Pedro", 23, 1002), 
			      new Pessoa("", 0, 1003), new Pessoa("", 0, 1004),
			      new Pessoa("Paulo", 0, 0), new Pessoa("Xavier", 0, 0) };

	testaPertinencia(colecao, pessoas);

	Pessoa.registraChamadas(true); 
	NomeComparator.registraChamadas(true);
	
	Pessoa p = (comparator != null ? new Pessoa("Maria", 0, 0) : new Pessoa("", 0, 1001));
	System.out.println("Verificacao de pertinencia para elemento " + p);
	System.out.println("Registro das chamadas a equals(), hashCode() e compareTo() invocadas durante chamada a contains():");
	testaPertinencia(colecao, p);  
	
	Pessoa.registraChamadas(false);
	NomeComparator.registraChamadas(false);
    }
    
    /* 
     * Metodo que ilustra o uso da interface Map e duas de suas implementacoes: HashMap e TreeMap. Neste metodo
     * usamos objetos do tipo Map para armazenar objetos do tipo Pessoa, usando valores inteiros (Integer) como
     * chave associada. Este metodo recebe como parametro uma String que define qual a implementacao de Map a ser 
     * instanciada. Alem disso, este metodo ilustra:
     *
     * - adicao de pares <chave, valor> ao mapa (atraves do metodo "put").
     *
     * - uso dos metodos "keySet", "values" e "entrySet" (que devolvem, respectivamente o conjunto de chaves, a 
     *   colecao de valores e o conjunto de pares <chave, valor> armezenados no mapa), e iteracao sobre as colecoes
     *   devolvidas (atraves do metodo "imprimeColecao"). Observe como a ordem em que as chaves/elementos/pares sao
     *   iterados depende da implementacao da interface Map que for utilizada.
     * 
     * - remocao de elementos do mapa (metodo "remove" que recebe como parametro a chave do elemento a ser removido).
     * 
     * - verificacao da existencia de uma chave no mapa (atraves do metodo "containsKey").
     * 
     * - recuperacao de uma referencia a um objeto armezanado no mapa (atraves do metodo "get" que recebe como
     *   parametro a chave do elemento a ser recuperado).
     *
     * Assim como ocorre com implementacoes de Collection, quando trabalhamos com implementacoes de Map tambem eh
     * muito importante verificar se a classe utilizada como chave implementa corretamente os metodos "equals", 
     * "hashCode" e "compareTo".
     *
     */
    public static void testeMapa(String tipoDeMapa){

	int chave;
	Pessoa p;
	
	Map<Integer, Pessoa> map;

	if(tipoDeMapa.equals("hash")) map = new HashMap<Integer, Pessoa>();
	else if(tipoDeMapa.equals("tree")) map = new TreeMap<Integer, Pessoa>();
	else {

	    System.out.println("Tipo de mapa invalido!");
	    return;
	}
	
	map.put(1008, new Pessoa("Xavier", 30, 1008));
	map.put(1007, new Pessoa("Ana", 27, 1007));
	map.put(1006, new Pessoa("Joao", 23, 1006));
	map.put(1005, new Pessoa("Bianca", 28, 1005));
	map.put(1004, new Pessoa("Paulo", 30, 1004));
	map.put(1003, new Pessoa("Eduardo", 27, 1003));
	map.put(1002, new Pessoa("Pedro", 23, 1002));
	map.put(1001, new Pessoa("Maria", 28, 1001));
	
	imprimeColecao(map.keySet());	
	imprimeColecao(map.values());
	imprimeColecao(map.entrySet());
	
	chave = 1001;
	p = map.remove(chave);
	System.out.println(">>>>> elemento " + p + " associado a chave " + chave + " removido da colecao.");
	separador();

	System.out.println("Testes de pertinencia:");
	int [] chaves = {0, 1001, 1002, 1003, 1004};
	for(int ch : chaves){
	    
	    System.out.println("Elemento associado a chave " + ch + " = " + map.get(ch));	    
	}
	separador();

	chave = 1004;
	if(map.containsKey(chave)){
	    
	    p = map.get(chave);
	    System.out.println(">>>>> editando elemento " + p + " associado a chave " + chave);
	    p.setIdade(35);
	    System.out.println(">>>>> apos edicao: " + p);
	    separador();
	}
	
	imprimeColecao(map.entrySet());
    }
    
    /* 
     * Programa principal 
     */
    public static void main(String [] args){
	
	if(args.length != 2 && args.length != 3){
	
	    System.out.println("Uso: java TesteColecoes <string|pessoa|mapa> <array|linked|hash|tree> [comparator]");
	    System.exit(1);
	}

	String teste = args[0];
	String implementacao = args[1];
	NomeComparator comparator = args.length == 3 ? (args[2].equals("comparator") ? new NomeComparator() : null) : null;

	if(teste.equals("string")) testeColecaoString(implementacao);
	else if(teste.equals("pessoa")) testeColecaoPessoa(implementacao, comparator);
	else if(teste.equals("mapa")) testeMapa(implementacao);
	else{

	    System.out.println("Opcao de teste invalida!");
	}
    }
}

/*
 * Classe Pessoa. Note que ela implementa a interface Comparable (que define o metodo "compareTo"), além de 
 * sobrescrever os metodos "equals" e "hashCode". Observe tambem que mantivemos uma coerencia na implementacao
 * destes tres metodos. Isto eh, como usamos o campo "id" como criterio para definir se dois objetos do tipo 
 * Pessoa sao iguais, objetos com o mesmo "id" tambem produzem o mesmo hashCode e, além disso, a ordenacao de
 * objetos do tipo Pessoa tambem eh baseada no valor do campo "id".
 *
 * Experimente remover e modificar essas implementacoes e veja o que acontece com os diversos testes que o 
 * programa executa. Experimente, por exemplo: 1) remover as implementacoes de "equals" e "hashCode"; 2) quebrar 
 * o contrato entre o "equals" e o "hashCode"; 3) fornecer uma implementacao de "hashCode" que embora respeite o 
 * contrato (objetos iguais produzem hash codes iguais) seja ruim (muitos objetos diferentes produzem o mesmo hash 
 * code); 4) Modificar o "compareTo" para que objetos do tipo Pessoa sejam ordenados por outro criterio.
 *
 */
class Pessoa implements Comparable<Pessoa>{

    // variavel estatica que indica se devemos ou nao fazer o 
    // log das chamadas a "equals", "hashCode" e "compareTo".
    private static boolean registra = false;

    private String nome;
    private int idade;
    private int id;
    
    public static void registraChamadas(boolean b){
	
	registra = b;
    }

    public Pessoa(String nome, int idade, int id){
	
	this.nome = nome;
	this.idade = idade;
	this.id = id;	
    }

    public String getNome(){
	
	return this.nome;
    }
    
    public void setIdade(int i){
	
	this.idade = i;
    }

    public String toString(){
	
	return "[Pessoa: '" + nome + "', " + idade + ", " + id + "]";	
    }
    
    public boolean equals(Object obj){
	
	if(Pessoa.registra) System.out.println("EQUALS: comparando " + this + " com " + obj);
	
	if(obj instanceof Pessoa){
	    
	    Pessoa p = (Pessoa) obj;
	    return this.id == p.id;
	}
	
	return false;
    }
    
    public int hashCode(){
	
	if(Pessoa.registra) System.out.println("HASHCODE: " + this);
	
	Integer i = this.id;
	return i.hashCode(); // % 2;
    }
    
    public int compareTo(Pessoa p){
	
	if(Pessoa.registra) System.out.println("COMPARE TO: comparando " + this + " com " + p);
	
	Integer i = this.id;
	return i.compareTo(p.id);
    }
}

/*
 * Comparador de objetos do tipo Pessoa. Pode ser usado como forma alternativa de se definir o criterio de 
 * ordenacao em SortedSets. Diferente da classe Pessoa, que define a ordenacao atraves do campo "id", este
 * comparador define a ordenacao atraves do campo "nome".
 */
class NomeComparator implements Comparator<Pessoa>{
    
    // variavel estatica que indica se devemos ou nao fazer o log das chamadas a "compare".
    private static boolean registra = false;

    public static void registraChamadas(boolean b){
    
	registra = b;
    }

    public int compare(Pessoa p1, Pessoa p2){
	
	if(NomeComparator.registra) System.out.println("COMPARE: comparando " + p1 + " com " + p2);

	return p1.getNome().compareTo(p2.getNome());
    }
}

