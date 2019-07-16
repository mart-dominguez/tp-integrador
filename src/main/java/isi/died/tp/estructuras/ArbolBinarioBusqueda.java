package isi.died.tp.estructuras;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda<E extends Comparable<E>> extends Arbol<E> {
	protected Arbol<E> izquierdo;
	protected Arbol<E> derecho;

	public ArbolBinarioBusqueda() {
		this.valor = null;
		this.izquierdo = new ArbolVacio<E>();
		this.derecho = new ArbolVacio<E>();
	}

	public ArbolBinarioBusqueda(E e) {
		this.valor = e;
		this.izquierdo = new ArbolVacio<E>();
		this.derecho = new ArbolVacio<E>();
	}

	public ArbolBinarioBusqueda(E e, Arbol<E> i, Arbol<E> d) {
		this.valor = e;
		this.izquierdo = i;
		this.derecho = d;
	}

	@Override
	public List<E> preOrden() {
		List<E> lista = new ArrayList<E>();
		lista.add(this.valor);
		lista.addAll(this.izquierdo.preOrden());
		lista.addAll(this.derecho.preOrden());
		return lista;
	}

	@Override
	public List<E> inOrden() {
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.preOrden());
		lista.add(this.valor);
		lista.addAll(this.derecho.preOrden());
		return lista;
	}

	@Override
	public List<E> posOrden() {
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.preOrden());
		lista.addAll(this.derecho.preOrden());
		lista.add(this.valor);
		return lista;

	}

	@Override
	public boolean esVacio() {
		return false;
	}

	@Override
	public E valor() {
		return this.valor;
	}

	@Override
	public Arbol<E> izquierdo() {
		return this.izquierdo;
	}

	@Override
	public Arbol<E> derecho() {
		return this.derecho;
	}

	@Override
	public void agregar(E a) {
		if (this.valor.compareTo(a) < 1) {
			if (this.derecho.esVacio()) {
				this.derecho = new ArbolBinarioBusqueda<E>(a);
			} else {
				this.derecho.agregar(a);
			}
		} else {
			if (this.izquierdo.esVacio()) {
				this.izquierdo = new ArbolBinarioBusqueda<E>(a);
			} else {
				this.izquierdo.agregar(a);
			}
		}
	}
	public E buscar(Arbol<E> t) {
		return this.buscar(t.valor());
	}
	public E buscar(E val) {
		if (this.valor.compareTo(val) == 0) {
			return this.valor();
		} else {
			if (this.valor.compareTo(val) < 1) {
				return this.derecho().buscar(val);
			} else {
				return this.izquierdo().buscar(val);
			}
		}
	}

	@Override
	public boolean equals(Arbol<E> unArbol) {
		return this.valor.equals(unArbol.valor()) && this.izquierdo.equals(unArbol.izquierdo())
				&& this.derecho.equals(unArbol.derecho());
	}

	@Override
	public boolean contiene(E unValor) {
		if (this.valor.equals(unValor)) {
			return true;
		} else {
			if (this.valor.compareTo(unValor) < 1) {
				return this.derecho.contiene(unValor);
			} else {
				return this.izquierdo.contiene(unValor);
			}
		}
	}

	@Override
	public String toString() {
		return this.valor.toString() + '(' + this.izquierdo.toString() + ',' + this.derecho.toString() + ')';
	}

	@Override
	public int profundidad() {
		if (this.derecho().profundidad() > this.izquierdo().profundidad()) {
			return this.derecho().profundidad() + 1;
		}
		return this.izquierdo().profundidad() + 1;
	}

	@Override
	public int cuentaNodosDeNivel(int nivel) {
		if (nivel == 1) {
			return 1;
		} else {
			return this.izquierdo().cuentaNodosDeNivel(nivel - 1) + this.derecho().cuentaNodosDeNivel(nivel - 1);
		}
	}

	@Override
	public boolean esCompleto() {
		if (this.esLleno()) {
			return true;
		} else {
			if (this.izquierdo.esVacio() && this.derecho.esVacio()) {
				if (this.derecho.profundidad() > this.izquierdo.profundidad()) {
					return false;
				} else {
					if (this.izquierdo.esCompleto() && this.derecho.esCompleto()) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean esLleno() {
		if (this.izquierdo.esVacio() && this.derecho.esVacio()) {
			return true;
		} else {
			if (this.izquierdo.esLleno() && this.derecho.esLleno()) {
				return true;
			}
		}
		return false;
	}

	public List<E> rango(E inicial, E fin) {
		List<E> respuesta = new ArrayList<E>();
		List<E> inOrden = this.inOrden();
		for (E e : inOrden) {
			if ((e.compareTo(inicial) >= 0) && (e.compareTo(fin) <= 0)) {
				respuesta.add(e);
			}
		}
		return respuesta;
	}

}
