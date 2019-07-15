package isi.died.tp.dominio;

import isi.died.tp.estructuras.ArbolBinarioBusqueda;

public class Almacen extends ArbolBinarioBusqueda<Stock> {
	public Stock buscarInsumo(Insumo i) {
		if(this.valor().getInsumo().compareTo(i)==0) {
			return this.valor();
		}else {
			if(this.valor().getInsumo().compareTo(i)<1) {
				return ((Almacen)this.derecho).buscarInsumo(i);
			}else {
				return ((Almacen)this.izquierdo).buscarInsumo(i);
			}
		}
	}
}
