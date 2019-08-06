package isi.died.tp.estructuras;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda<E extends Comparable<E>> extends Arbol<E> {
	protected Arbol<E> izquierdo;
	protected Arbol<E> derecho;
	protected Integer indexBalance;

	public Arbol<E> borrarElemento(E va) {
		Arbol<E> me = this;
		if(this.valor().equals(va)) {
			if(this.derecho.esVacio() && this.izquierdo.esVacio()) {
				return new ArbolVacio<E>();
			}
			else {
				if(!this.derecho.esVacio() && !this.izquierdo.esVacio()) {
					Arbol<E> p = this.derecho;
					if(p.izquierdo().esVacio()) {
						((ArbolBinarioBusqueda<E>) p).izquierdo = this.izquierdo;
						return p;
					}
					else {
						Arbol<E> qmenosuno = null;
						while(!p.izquierdo().esVacio()) {
							qmenosuno = p;
							p = p.izquierdo();
						}
						((ArbolBinarioBusqueda<E>) qmenosuno).izquierdo = p.derecho();
						((ArbolBinarioBusqueda<E>) p).izquierdo = this.izquierdo;
						((ArbolBinarioBusqueda<E>) p).derecho = this.derecho;
						return p;
					}
				}
				else {
					if(this.derecho.esVacio()) {
						return this.izquierdo;
					}
					else {
						return this.derecho;
					}
				}
			}
		}
		else {
			if(this.valor.compareTo(va)<0) {
				this.derecho = ((ArbolBinarioBusqueda<E>) me.derecho()).borrarElemento(va);
			}
			else {
				this.izquierdo = ((ArbolBinarioBusqueda<E>) me.izquierdo()).borrarElemento(va);
			}
		}
		return me;
	}
	public Arbol<E> dosDerecha() {
		Arbol<E> q = this.izquierdo;
		Arbol<E> r = q.derecho();
		this.izquierdo = r.derecho();
		((ArbolBinarioBusqueda<E>) q).derecho = r.izquierdo();
		((ArbolBinarioBusqueda<E>) r).derecho = this;
		((ArbolBinarioBusqueda<E>) r).izquierdo = q;
		return r;
	}

	public Arbol<E> dosIzquierda() {
		Arbol<E> q = this.derecho;
		Arbol<E> r = q.izquierdo();
		this.derecho = r.izquierdo();
		((ArbolBinarioBusqueda<E>) q).izquierdo = r.derecho();
		((ArbolBinarioBusqueda<E>) r).izquierdo = this;
		((ArbolBinarioBusqueda<E>) r).derecho = q;
		return r;
	}

	public Arbol<E> rotIzquierda() {
		ArbolBinarioBusqueda<E> b = (ArbolBinarioBusqueda<E>) this.izquierdo;
		this.izquierdo = b.derecho;
		b.derecho = this;
		return b;
	}

	public Arbol<E> rotDerecha() {
		ArbolBinarioBusqueda<E> b = (ArbolBinarioBusqueda<E>) this.derecho;
		this.derecho = b.izquierdo;
		b.izquierdo = this;
		return b;
	}

	public ArbolBinarioBusqueda<E> equilibrar() {
		Arbol<E> actual = this;
		if (!this.esAVL()) {
			if (this.derecho.profundidad() > this.izquierdo.profundidad()) {
				if (this.derecho().derecho().profundidad() > this.derecho().izquierdo().profundidad()) {
					actual = ((ArbolBinarioBusqueda<E>) actual).rotDerecha();
				} else {
					actual = ((ArbolBinarioBusqueda<E>) actual).dosIzquierda();
				}
			} else {
				if (this.izquierdo().izquierdo().profundidad() > this.izquierdo().derecho().profundidad()) {
					actual = ((ArbolBinarioBusqueda<E>) actual).rotIzquierda();
				} else {
					actual = ((ArbolBinarioBusqueda<E>) actual).dosDerecha();
				}

			}
		}
		return (ArbolBinarioBusqueda<E>) actual;
	}

	public boolean esAVL() {
		if (this.indexBalance < 2) {
			return true;
		}
		return false;
	}

	public void updateIndexBalance() {
		this.indexBalance = Math.abs(this.derecho.profundidad() - this.izquierdo.profundidad());
	}

	public ArbolBinarioBusqueda() {
		this.valor = null;
		this.izquierdo = new ArbolVacio<E>();
		this.derecho = new ArbolVacio<E>();
		this.updateIndexBalance();
	}

	public ArbolBinarioBusqueda(E e) {
		this.valor = e;
		this.izquierdo = new ArbolVacio<E>();
		this.derecho = new ArbolVacio<E>();
		this.updateIndexBalance();
	}

	public ArbolBinarioBusqueda(E e, Arbol<E> i, Arbol<E> d) {
		this.valor = e;
		this.izquierdo = i;
		this.derecho = d;
		this.updateIndexBalance();
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
		this.updateIndexBalance();
	}

	public Integer getIndexBalance() {
		return indexBalance;
	}

	public void setIndexBalance(Integer indexBalance) {
		this.indexBalance = indexBalance;
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
