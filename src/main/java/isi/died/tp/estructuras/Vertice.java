package isi.died.tp.estructuras;

public class Vertice<T> {

	private T valor;

	public Vertice() {
	}

	public Vertice(T v) {
		this.valor = v;
	}

	public void setValor(T v) {
		this.valor = v;
	}

	public T getValor() {
		return this.valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vertice) {
			if(this.valor.equals(((Vertice<?>)obj).valor)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return valor.toString();
	}

}