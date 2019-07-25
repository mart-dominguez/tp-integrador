package isi.died.tp.estructuras;

public class Arista<T> {
	protected Vertice<T> inicio;
	protected Vertice<T> fin;
	private Number valor;

	public Arista() {
		valor = 1.0;
	}

	public Arista(Vertice<T> ini, Vertice<T> fin) {
		this();
		this.inicio = ini;
		this.fin = fin;
	}

	public Arista(Vertice<T> ini, Vertice<T> fin, Number val) {
		this(ini, fin);
		this.valor = val;
	}

	public Vertice<T> getInicio() {
		return inicio;
	}

	public void setInicio(Vertice<T> inicio) {
		this.inicio = inicio;
	}

	public Vertice<T> getFin() {
		return fin;
	}

	public void setFin(Vertice<T> fin) {
		this.fin = fin;
	}

	public Number getValor() {
		return valor;
	}

	public void setValor(Number valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "( " + this.inicio.getValor() + " --> " + this.fin.getValor() + " )";
	}

	@Override
	public boolean equals(Object obj) {
		Integer mihash = this.hashCode();
		Integer otro= obj.hashCode();
		if( (obj instanceof Arista<?>) && (mihash.equals(otro))) {
			if(((Arista<?>) obj).fin.equals(this.fin) && ((Arista<?>) obj).inicio.equals(this.inicio)) {
				return true;
			}
		}
		return false;
	}
}