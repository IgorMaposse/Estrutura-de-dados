package Controller;

public interface  InterfaceGeral {
	public void adicionaInicio(Object elemento) ;
	//adiciona elemento no inicio da lista

	public void adicionaPosicao(int posicao, Object elemento);
	//adiciona elemento numa dada posição

	public void adicionaFim (Object elemento) ;
	//adiciona elemento no fim da lista

	public Object pega(int posicao) ;
	//devolve elemento duma dada posicao

	public void removeInicio();
	//remove elemento no inicio

	public void removePosicao(int posicao);
	//remove elemento duma dada posição

	public void removeFim();
	//remove elemento no fim

	public boolean contem(Object elemento);
	// verifica se a lista contem um dado elemento

	public int tamanho();
	//devolve o numero de elementos da lista
}

