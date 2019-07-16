package isi.died.tp.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import isi.died.tp.estructuras.*;

public class Planta { 
	private int id;
	private String nombre;
	private ArbolBinarioBusqueda<Stock> almacen;
	public Planta(Integer i, String nomb) {
		this.setId(i);
		this.setNombre(nomb);
		this.almacen = null;
	}
	public Planta(Integer i, String nomb, ArbolBinarioBusqueda<Stock> cosas) {
		this.setId(i);
		this.setNombre(nomb);
		this.setAlmacen(cosas);
	}
	public Double costoTotal() {
		return this.almacen.posOrden().stream().mapToDouble((s) -> s.getCantidad() * s.getInsumo().getCosto()).sum();
	}


	public List<Insumo> stockEntre(Integer s1, Integer s2) {
		return this.almacen.posOrden().stream().filter((s) -> (s.getInsumo().getStock() >= s1 && s.getInsumo().getStock() <= s2)).map(Stock::getInsumo).collect(Collectors.toList());
	}

	public Boolean necesitaInsumo(Insumo i) {
		List<Insumo> buscado = this.almacen.inOrden().stream().filter(s -> s.getInsumo().getId() == i.getId() &&(s.getCantidad() < s.getPuntoPedido())).map(Stock::getInsumo).collect(Collectors.toList());
		if (!buscado.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public ArbolBinarioBusqueda<Stock> getAlmacen() {
		return almacen;
	}
	public void setAlmacen(ArbolBinarioBusqueda<Stock> stock) {
		this.almacen = stock;
	}
	public void addStock(Stock o) {
		if(this.almacen == null) {
			ArbolBinarioBusqueda<Stock> nuevo = new ArbolBinarioBusqueda<Stock>(o);
			this.almacen =nuevo;
		}
		else {
			this.almacen.agregar(o);
		}
	}
	@Override
	public String toString() {
		return this.nombre;
	}
}
